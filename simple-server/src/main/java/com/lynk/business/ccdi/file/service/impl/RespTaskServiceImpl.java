package com.lynk.business.ccdi.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lynk.business.ccdi.common.Constant;
import com.lynk.business.ccdi.common.ParamKey;
import com.lynk.business.ccdi.entity.ReqZip;
import com.lynk.business.ccdi.file.ftp.CcdiFtpUtil;
import com.lynk.business.ccdi.file.resp.RespParser;
import com.lynk.business.ccdi.file.service.IRespTaskService;
import com.lynk.business.ccdi.service.IReqZipService;
import com.lynk.system.common.DateUtil;
import com.lynk.system.exception.SystemException;
import com.lynk.system.ftp.FtpConnect;
import com.lynk.system.tool.SysParamManager;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author Lynk @ 2019-05-03 07:37
 */
@Service
public class RespTaskServiceImpl implements IRespTaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RespTaskServiceImpl.class);

    @Autowired
    private IReqZipService reqZipService;
    @Autowired
    private RespParser respParser;

    @Override
    public void fedRr28() throws SystemException {
        List<ReqZip> reqZips = reqZipService.list(new QueryWrapper<ReqZip>().eq(ReqZip.STATUS, Constant.REQ_ZIP_STATUS_02));
        for (ReqZip reqZip: reqZips) {
            try {
                fedRr28Single(reqZip);
            } catch (Exception e) {
                reqZip.setStatus(Constant.REQ_ZIP_STATUS_07);
                reqZipService.updateById(reqZip);
            }
        }
    }

    private void fedRr28Single(ReqZip reqZip) throws Exception {
        reqZip.setStatus(Constant.REQ_ZIP_STATUS_03);
        reqZipService.updateById(reqZip);

        String respRootPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_RESP_LOCAL_PATH);
        String currentDate = DateUtil.getCurrentDate8();
        String reqFileName = reqZip.getReqZipName();
        reqFileName = FilenameUtils.getBaseName(reqFileName);
        File respDir = new File(respRootPath + File.separator + currentDate + File.separator + reqFileName);
        if (!respDir.exists()) {
            respDir.mkdirs();
        }

        String rr28FileName = Constant.FLDM_RR28 + reqZip.getMbjgdm() + reqZip.getQqdbs() + "000000000001.xml";
        File rr28File = new File(respDir, rr28FileName);
        respParser.parse2Rr28File(rr28File, reqZip);

        String hzZipName = reqZip.getSqjgdm() + reqZip.getMbjgdm() + reqZip.getQqdbs() + "000000000001.ZIP";
        File hzZipFile = new File(respDir, hzZipName);
        if (hzZipFile.exists()) {
            hzZipFile.delete();
        }

        ZipParameters zipParameters = new ZipParameters();

        try {
            ZipFile zipFile = new ZipFile(hzZipFile);
            zipFile.addFile(rr28File, zipParameters);
        } catch (ZipException e) {
            LOGGER.error("生成RR28压缩文件失败", e);
            throw e;
        }

        String respPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_RESP_PATH);
        FtpConnect ftpConnect = null;
        try {
            ftpConnect = CcdiFtpUtil.getCcdiFtpConnect();
            ftpConnect.changeDirectory(respPath);
            ftpConnect.upload(hzZipFile);
        } catch (SystemException e) {
            LOGGER.error("FTP上传RR28压缩文件失败", e);
            throw e;
        } finally {
            if (ftpConnect != null) {
                ftpConnect.disconnect();
            }
        }

        reqZip.setStatus(Constant.REQ_ZIP_STATUS_04);
        reqZip.setHzZipPath(respDir.getPath());
        reqZip.setHzZipName(hzZipName);
        reqZipService.updateById(reqZip);
    }
}
