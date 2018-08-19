package com.lynk.system.ftp;

import com.lynk.system.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lynk on 2016/12/30.
 */
public class FtpFactory {
    private static List<FtpConnect> connects = new ArrayList<>();

    public static synchronized FtpConnect getConnect(String url, int port, String userName, String password, String encoding) throws SystemException {
        for (FtpConnect connect: connects) {
            if (!connect.isConnected()) {
                connect.connect(url, port, userName, password, encoding);
                return connect;
            }
        }

        FtpConnect connect = new FtpConnect();
        connect.connect(url, port, userName, password, encoding);
        connects.add(connect);
        return connect;
    }

    public static FtpConnect getConnect(String url, int port, String userName, String password) throws SystemException {
        return getConnect(url, port, userName, password, FtpConnect.DEFAULT_ENCODING);
    }
}
