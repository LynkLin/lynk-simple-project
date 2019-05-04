package com.lynk.business.ccdi.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lynk.business.ccdi.common.Constant;
import com.lynk.business.ccdi.common.ParamKey;
import com.lynk.business.ccdi.entity.*;
import com.lynk.business.ccdi.file.ftp.CcdiFtpUtil;
import com.lynk.business.ccdi.file.req.*;
import com.lynk.business.ccdi.file.req.basic.ReqForm;
import com.lynk.business.ccdi.file.service.IReqTaskService;
import com.lynk.business.ccdi.service.*;
import com.lynk.system.common.DateUtil;
import com.lynk.system.exception.SystemException;
import com.lynk.system.ftp.FtpConnect;
import com.lynk.system.tool.SysParamManager;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lynk @ 2019/04/24
 */
@Service
public class ReqTaskServiceImpl implements IReqTaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReqTaskServiceImpl.class);

    @Autowired
    private IReqZipService reqZipService;
    @Autowired
    private IReqAttachmentService reqAttachmentService;
    @Autowired
    private IReqBasicService reqBasicService;
    @Autowired
    private IReqPersonService reqPersonService;
    @Autowired
    private IReqMainService reqMainService;
    @Autowired
    private ReqParser reqParser;

    /**
     * 下载FTP上的请求包
     * @throws SystemException throw it
     */
    @Override
    public void downloadUnzipReqFile() throws SystemException {
        String reqPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_REQ_PATH);
        String reqOkPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_REQ_OK_PATH);
        String reqLocalPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_REQ_LOCAL_PATH);
        String currentDate = DateUtil.getCurrentDate8();

        FtpConnect ftpConnect = null;

        try {
            ftpConnect = CcdiFtpUtil.getCcdiFtpConnect();
            ftpConnect.changeDirectory(reqPath);
            List<String> fileNames = ftpConnect.listFileName("*.ZIP");
            for (String fileName: fileNames) {
                int count = reqZipService.count(new QueryWrapper<ReqZip>().eq(ReqZip.REQ_ZIP_NAME, fileName));
                if (count > 0) {
                    LOGGER.warn("存在下载记录: {}", fileName);
                } else {
                    File localDatePath = new File(reqLocalPath, currentDate);
                    if (!localDatePath.exists()) {
                        localDatePath.mkdirs();
                    }
                    File localFile = new File(localDatePath, fileName);
                    ftpConnect.download(reqPath, fileName, localFile);

                    dealZipFile(localFile);
                }

                boolean exists = ftpConnect.directoryExists(reqOkPath, currentDate);
                if (!exists) {
                    ftpConnect.changeDirectory(reqOkPath);
                    ftpConnect.createDirectory(currentDate);
                }
                ftpConnect.moveFile(reqPath + File.separator + fileName, reqOkPath + File.separator + currentDate + File.separator + fileName);
            }
        } catch (SystemException e) {
            throw e;
        } finally {
            if (ftpConnect != null) {
                ftpConnect.disconnect();
            }
        }
    }

    /**
     * 解析待处理zip包的xml文件
     *
     * @throws SystemException
     */
    @Override
    public void parseReqZip() throws SystemException {
        //更改为中间状态
        List<ReqZip> reqZips = reqZipService.list(new QueryWrapper<ReqZip>().eq(ReqZip.STATUS, Constant.REQ_ZIP_STATUS_00));
        if (reqZips.size() == 0) {
            return;
        }

        for (ReqZip reqZip: reqZips) {
            reqZip.setStatus(Constant.REQ_ZIP_STATUS_01);
        }
        reqZipService.updateBatchById(reqZips);

        for (ReqZip reqZip: reqZips) {
            try {
                parseOneReqZip(reqZip);
                reqZip.setStatus(Constant.REQ_ZIP_STATUS_02);
                reqZip.setHzdm(Constant.REQ_ZIP_HZDM_SUCCESS);
                reqZipService.updateById(reqZip);
            } catch (Exception e) {
                LOGGER.error("parseOneReqZip ERROR", e);
                reqZip.setStatus(Constant.REQ_ZIP_STATUS_02);
                reqZip.setHzdm(Constant.REQ_ZIP_HZDM_FAIL_PARSE);
                reqZip.setHzsm(e.getMessage());
                reqZipService.updateById(reqZip);
            }
        }
    }

    /**
     * 解压缩ZIP包
     * @throws SystemException
     */
    private void dealZipFile(File localFile) {
        String nestedStatus = Constant.NESTED_STATUS_NORMAL;
        String status = Constant.REQ_ZIP_STATUS_00;
        String hzdm = Constant.REQ_ZIP_HZDM_SUCCESS;
        String hzsm = "";

        //解压缩开始
        File extractPathFile = null;
        try {
            extractPathFile = unzipFile(localFile);
            localFile.delete();
        } catch (Exception e) {
            //解压缩失败
            LOGGER.error("解压缩请求包失败: {}", localFile.getName(), e);
            status = Constant.REQ_ZIP_STATUS_02;
            hzdm = Constant.REQ_ZIP_HZDM_FAIL_PARSE;
            hzsm = "解压缩请求包失败";
        }

        List<ReqAttachment> reqAttachments = new ArrayList<>(16);
        if (extractPathFile != null) {
            File[] listFiles = extractPathFile.listFiles();
            boolean hasXml = false;
            boolean hasPdf = false;
            for (File listFile: listFiles) {
                String fileName = listFile.getName();
                String fldm = fileName.substring(0, 4);

                ReqAttachment reqAttachment = new ReqAttachment();
                reqAttachment.setAttachmentType(fldm);
                if (fldm.startsWith("SS")) {
                    hasXml = true;
                }
                if (Constant.FLDM_LI25.equals(fldm)) {
                    hasPdf = true;
                }
                reqAttachment.setFilePath(listFile.getParent());
                reqAttachment.setFileName(fileName);

                reqAttachments.add(reqAttachment);
            }
            if (!hasXml) {
                status = Constant.REQ_ZIP_STATUS_02;
                hzdm = Constant.REQ_ZIP_HZDM_FAIL_MISSING_XML;
                hzsm = "查控请求XML缺失";
                reqAttachments.clear();
            } else if (!hasPdf) {
                status = Constant.REQ_ZIP_STATUS_02;
                hzdm = Constant.REQ_ZIP_HZDM_FAIL_MISSING_PDF;
                hzsm = "查控法律文件缺失";
                reqAttachments.clear();
            }
        }

        ReqZip reqZip = new ReqZip();
        reqZip.setReqZipPath(localFile.getParent());
        reqZip.setReqZipName(localFile.getName());
        reqZip.setNestedStatus(nestedStatus);
        reqZip.setStatus(status);
        reqZip.setHzdm(hzdm);
        reqZip.setHzsm(hzsm);
        if (localFile.getName().startsWith(Constant.FILE_ORG)) {
            reqZip.setSqjgdm(Constant.FILE_ORG);
            reqZip.setMbjgdm(localFile.getName().substring(8, 25));
            reqZip.setQqdbs(localFile.getName().substring(25, 47));
            reqZipService.save(reqZip);
        } else {
            //如果以后文件名不是以ZYJWGJJW开头的逻辑
        }

        if (reqAttachments.size() > 0) {
            for (ReqAttachment reqAttachment: reqAttachments) {
                reqAttachment.setReqZipId(reqZip.getId());
            }
            //写入文件
            reqAttachmentService.saveBatch(reqAttachments);
        }
    }

    /**
     * 解压缩文件
     * @param file
     * @return
     * @throws Exception
     */
    private File unzipFile(File file) throws Exception {
        File extractPathFile = new File(file.getParent(), FilenameUtils.getBaseName(file.getName()));
        if (!extractPathFile.exists()) {
            extractPathFile.mkdirs();
        } else {
            extractPathFile.delete();
            extractPathFile.mkdirs();
        }
        try {
            ZipFile zipFile = new ZipFile(file);
            zipFile.extractAll(extractPathFile.getAbsolutePath());
        } catch (ZipException e) {
            extractPathFile.delete();
            throw e;
        }
        return extractPathFile;
    }

    /**
     * 解析一个请求包的xml文件
     * @param reqZip
     * @throws Exception
     */
    private void parseOneReqZip(ReqZip reqZip) throws Exception {
        String processApprovalAuto = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI, ParamKey.BIZ_PARAM_CCDI_PROCESS_APPROVAL_AUTO);
        String respApprovalAuto = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI, ParamKey.BIZ_PARAM_CCDI_RESP_APPROVAL_AUTO);

        List<ReqMain> reqMains = new ArrayList<>(16);

        List<ReqAttachment> reqAttachments = reqAttachmentService.list(new QueryWrapper<ReqAttachment>().eq(ReqAttachment.REQ_ZIP_ID, reqZip.getId()).likeRight(ReqAttachment.ATTACHMENT_TYPE, "SS"));
        for (ReqAttachment reqAttachment: reqAttachments) {
            File xmlFile = new File(reqAttachment.getFilePath(), reqAttachment.getFileName());
            Class<? extends ReqForm> clz = convertFldm(reqAttachment.getAttachmentType());
            ReqForm reqForm = reqParser.parseReqXmlFile(xmlFile, clz);
            if (reqForm == null) {
                // 解析失败!
                throw new Exception("解析文件异常, 解析出的结果为空.");
            }

            ReqBasic reqBasic = reqParser.parse2ReqBasic(reqForm);
            reqBasic.setReqZipId(reqZip.getId());
            reqBasic.setAttachmentId(reqAttachment.getId());
            reqBasicService.save(reqBasic);

            ReqPerson reqPerson = reqParser.parse2ReqPerson(reqForm);
            reqPerson.setReqBasicId(reqBasic.getId());
            reqPersonService.save(reqPerson);

            List<ReqMain> reqSubMains = reqParser.parse2ReqMain(reqAttachment.getAttachmentType(), reqForm);
            for (int i = 0; i < reqSubMains.size(); i++) {
                ReqMain reqMain = reqSubMains.get(i);
                reqMain.setReqBasicId(reqBasic.getId());
                reqMain.setFldm(reqAttachment.getAttachmentType());
                reqMain.setSeqNo(StringUtils.leftPad(Integer.toString(i + 1), 12, "0"));
                reqMain.setProcessApproval(Constant.YES.equals(processApprovalAuto)? Constant.REQ_APPROVAL_PASS: Constant.REQ_APPROVAL_WAIT);
                reqMain.setRespApproval(Constant.YES.equals(respApprovalAuto)? Constant.REQ_APPROVAL_PASS: Constant.REQ_APPROVAL_WAIT);
                reqMain.setStatus(Constant.REQ_STATUS_WAIT_PROCESS);

                if (Constant.FLDM_GROUP_REQ_DYNAMIC.contains(reqAttachment.getAttachmentType())) {
                    // 动态查询时, 计算动态查询到期时间
                    String kssj = DateUtil.getCurrentDate8();
                    String jssj;
                    switch (reqMain.getZxsjqj()) {
                        case Constant.REQ_DYNAMICAL_ZXJSQJ_100_DAY:
                            jssj = DateUtil.plusDay(kssj, 100, "yyyyMMdd");
                            break;
                        case Constant.REQ_DYNAMICAL_ZXJSQJ_3_MONTH:
                            jssj = DateUtil.plusMonth(kssj, 3, "yyyyMMdd");
                            break;
                        case Constant.REQ_DYNAMICAL_ZXJSQJ_2_MONTH:
                            jssj = DateUtil.plusMonth(kssj, 2, "yyyyMMdd");
                            break;
                        case Constant.REQ_DYNAMICAL_ZXJSQJ_1_MONTH:
                        default:
                            jssj = DateUtil.plusMonth(kssj, 1, "yyyyMMdd");
                    }

                    reqMain.setKssj(kssj);
                    reqMain.setJssj(jssj);
                    reqMain.setDynamicalStatus(Constant.REQ_DYNAMICAL_STATUS_NORMAL);
                    reqMain.setFksjhm(SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI, ParamKey.BIZ_PARAM_CCDI_RESP_PHONE_NO));
                }
            }
            reqMains.addAll(reqSubMains);
        }

        if (reqMains.size() > 0) {
            reqMainService.saveBatch(reqMains);
        }
    }

    /**
     * 分类代码转class
     * @param fldm
     * @return
     */
    private Class<? extends ReqForm> convertFldm(String fldm) throws Exception {
        switch (fldm) {
            case Constant.FLDM_SS01:
            case Constant.FLDM_SS02:
                return Ss0102Form.class;
            case Constant.FLDM_SS05:
            case Constant.FLDM_SS06:
                return Ss0506Form.class;
            case Constant.FLDM_SS11:
            case Constant.FLDM_SS12:
                return Ss1112Form.class;
            case Constant.FLDM_SS17:
            case Constant.FLDM_SS18:
                return Ss1718Form.class;
            case Constant.FLDM_SS21:
            case Constant.FLDM_SS22:
                return Ss2122Form.class;
            case Constant.FLDM_SS25:
                return Ss25Form.class;
            case Constant.FLDM_SS32:
            case Constant.FLDM_SS33:
                return Ss3233Form.class;
            default:
                LOGGER.error("未知的分类代码:{}", fldm);
                throw new Exception("未知的分类代码");
        }
    }

}
