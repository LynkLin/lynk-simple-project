package com.lynk.business.ccdi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lynk.business.ccdi.common.Constant;
import com.lynk.business.ccdi.common.ParamKey;
import com.lynk.business.ccdi.entity.ReqZip;
import com.lynk.business.ccdi.dao.ReqZipDao;
import com.lynk.business.ccdi.service.IReqZipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lynk.system.common.DateUtil;
import com.lynk.system.common.ValidateUtil;
import com.lynk.system.exception.SystemException;
import com.lynk.system.ftp.FtpConnect;
import com.lynk.system.ftp.FtpFactory;
import com.lynk.system.tool.SysParamManager;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lynk
 * @since 2019-04-18
 */
@Service
public class ReqZipServiceImpl extends ServiceImpl<ReqZipDao, ReqZip> implements IReqZipService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReqZipServiceImpl.class);
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
        FtpConnect ftpConnect = FtpFactory.getConnect(ip, port, userName, password);

        String currentDate = DateUtil.getCurrentDate8();
        String reqPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_REQ_PATH);
        String reqLocalPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_REQ_LOCAL_PATH);
        reqLocalPath = reqLocalPath + File.separator + currentDate;
        String reqOkPath = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_REQ_OK_PATH);
        reqOkPath = reqOkPath + File.separator + currentDate;


        FTPFile[] ftpFiles;
        try {
            ftpFiles = ftpConnect.list(reqPath, file -> {
                String name = file.getName();
                if (ValidateUtil.isNotEmpty(name)) {
                    name = name.toLowerCase();
                    return file.isFile() && name.endsWith(Constant.SUFFIX);
                } else {
                    return false;
                }

            });

            for (FTPFile ftpFile: ftpFiles) {
                String fileName = ftpFile.getName();

                int count = count(new QueryWrapper<ReqZip>().eq(ReqZip.REQ_ZIP_NAME, fileName));
                if (count > 0) {
                    LOGGER.warn("存在下载记录: {0}", fileName);
                    continue;
                }

                ftpConnect.download(reqPath, reqLocalPath ,fileName);


                ReqZip reqZip = new ReqZip();
                reqZip.setReqZipPath(reqLocalPath);
                reqZip.setReqZipName(fileName);
                reqZip.setNestedStatus(Constant.NESTED_STATUS_NORMAL);
                reqZip.setStatus("0");
                if (fileName.startsWith(Constant.FILE_ORG)) {
                    reqZip.setSqjgdm(Constant.FILE_ORG);
                    reqZip.setMbjgdm(fileName.substring(8, 25));
                    reqZip.setQqdbs(fileName.substring(25, 47));

                    save(reqZip);
                } else {
                    //如果以后文件名不是以ZYJWGJJW开头的逻辑
                }

                ftpConnect.delete(reqPath, fileName);
//                ftpConnect.makeDirectory(reqOkPath);
                ftpConnect.upload(reqOkPath, reqLocalPath, fileName);

            }
        } catch (SystemException e) {
            throw e;
        } finally {
            ftpConnect.disconnect();
        }
    }
}
