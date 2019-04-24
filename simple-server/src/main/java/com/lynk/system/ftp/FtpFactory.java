package com.lynk.system.ftp;

import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lynk on 2016/12/30.
 */
public class FtpFactory {
    private static List<FtpConnect> ftpConnects = new ArrayList<>();

    public static synchronized FtpConnect getConnect(String host, int port, String userName, String password) throws SystemException {
        FtpConnect ftpConnect = null;
        for (FtpConnect ftpConnectTemp: ftpConnects) {
            if (!ftpConnectTemp.isConnected()) {
                ftpConnect = ftpConnectTemp;
                break;
            }
        }
        if (ftpConnect == null) {
            ftpConnect = new FtpConnect();
            ftpConnects.add(ftpConnect);
        }

        try {
            ftpConnect.connect(host, port, userName, password);
        } catch (Exception e) {
            throw new SystemException(ErrorCode.FTP001, e);
        }
        return ftpConnect;
    }
}
