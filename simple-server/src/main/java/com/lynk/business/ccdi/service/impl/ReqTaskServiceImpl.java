package com.lynk.business.ccdi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lynk.business.ccdi.common.Constant;
import com.lynk.business.ccdi.common.ParamKey;
import com.lynk.business.ccdi.dao.ReqZipDao;
import com.lynk.business.ccdi.entity.ReqAttachment;
import com.lynk.business.ccdi.entity.ReqZip;
import com.lynk.business.ccdi.service.IReqAttachmentService;
import com.lynk.business.ccdi.service.IReqTaskService;
import com.lynk.system.common.DateUtil;
import com.lynk.system.common.ValidateUtil;
import com.lynk.system.exception.SystemException;
import com.lynk.system.ftp.FtpConnect;
import com.lynk.system.ftp.FtpFactory;
import com.lynk.system.tool.SysParamManager;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.apache.commons.io.FilenameUtils;
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
    private ReqZipDao reqZipDao;
    @Autowired
    private IReqAttachmentService reqAttachmentService;

    /**
     * 下载FTP上的请求包
     *
     * @throws SystemException
     */
    @Override
    public void downloadReqFile() throws SystemException {
        String ip = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_IP);
        int port = SysParamManager.getInstance().getIntParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_PORT);
        String userName = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_USER);
        String password = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_PASSWORD);

        String reqPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_REQ_PATH);
        String reqOkPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_REQ_OK_PATH);
        String reqLocalPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_REQ_LOCAL_PATH);
        String currentDate = DateUtil.getCurrentDate8();

        FtpConnect ftpConnect = null;

        try {
            ftpConnect = FtpFactory.getConnect(ip, port, userName, password);
            ftpConnect.setPassive(true);
            ftpConnect.changeDirectory(reqPath);
            List<String> fileNames = ftpConnect.listFileName(Constant.ZIP_FILE_SPEC);
            for (String fileName: fileNames) {
                int count = reqZipDao.selectCount(new QueryWrapper<ReqZip>().eq(ReqZip.REQ_ZIP_NAME, fileName));
                if (count > 0) {
                    LOGGER.warn("存在下载记录: {0}", fileName);
//                    continue;
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
     *
     * @throws SystemException
     */
    private void dealZipFile(File localFile) throws SystemException {
        String nestedStatus = Constant.NESTED_STATUS_NORMAL;
        String status = Constant.REQ_ZIP_STATUS_00;
        String hzdm = Constant.REQ_ZIP_HZDM_SUCCESS;
        String hzsm = "";

        //解压缩
        File extractPathFile = new File(localFile.getParent(), FilenameUtils.getBaseName(localFile.getName()));
        if (!extractPathFile.exists()) {
            extractPathFile.mkdirs();
        }

        List<ReqAttachment> reqAttachments = new ArrayList<>(16);
        try {
            ZipFile zipFile = new ZipFile(localFile);
            //是否托管包
            boolean isNested = false;
            List<FileHeader> fileHeaders = zipFile.getFileHeaders();
            for (FileHeader fileHeader: fileHeaders) {
                String inFileName = fileHeader.getFileName();
                if (ValidateUtil.isNotEmpty(inFileName)) {
                    inFileName = inFileName.toLowerCase();
                    if ("zip".equals(FilenameUtils.getExtension(inFileName).toLowerCase())) {
                        isNested = true;
                        break;
                    }
                }
            }
            if (!isNested) {
                zipFile.extractAll(extractPathFile.getAbsolutePath());
                File[] listFiles = extractPathFile.listFiles();
                for (File listFile: listFiles) {
                    String fileName = listFile.getName();

                    ReqAttachment reqAttachment = new ReqAttachment();
                    reqAttachment.setAttachmentType(fileName.substring(0, 4));
                    reqAttachment.setFilePath(listFile.getParent());
                    reqAttachment.setFileName(fileName);

                    reqAttachments.add(reqAttachment);
                }
            } else {
                //托管包,暂时没有
            }
        } catch (ZipException e) {
            LOGGER.error("解压缩请求包失败: {0}", localFile.getName(), e);
            status = Constant.REQ_ZIP_STATUS_02;
            hzdm = Constant.REQ_ZIP_HZDM_FAIL_PARSE;
            hzsm = "解压缩请求包失败";
        }
        //解压缩

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
            reqZipDao.insert(reqZip);
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
}
