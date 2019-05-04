package com.lynk.business.ccdi.file.ftp;

import com.lynk.business.ccdi.common.ParamKey;
import com.lynk.system.exception.SystemException;
import com.lynk.system.ftp.FtpConnect;
import com.lynk.system.ftp.FtpFactory;
import com.lynk.system.tool.SysParamManager;

/**
 * @author Lynk @ 2019-05-04 09:55
 */
public class CcdiFtpUtil {
    public static FtpConnect getCcdiFtpConnect() throws SystemException {
        String ip = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_IP);
        int port = SysParamManager.getInstance().getIntParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_PORT);
        String userName = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_USER);
        String password = SysParamManager.getInstance().getParam(ParamKey.BIZ_PARAM_CATEGORY_CCDI_FTP, ParamKey.BIZ_PARAM_FTP_PASSWORD);

        FtpConnect ftpConnect = FtpFactory.getConnect(ip, port, userName, password);
        ftpConnect.setPassive(true);
        return ftpConnect;
    }
}
