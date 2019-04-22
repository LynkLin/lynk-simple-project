package com.lynk.system.ftp;

import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.exception.SystemException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author Lynk on 2016/12/30.
 */
public class FtpConnect {
    private static final Logger LOGGER = LoggerFactory.getLogger(FtpConnect.class);

    public static String DEFAULT_ENCODING = "UTF-8";

    private static FTPClient client = new FTPClient();

    protected void connect(String url, int port, String userName, String password, String encoding) throws SystemException {
        if (encoding == null) {
            encoding = DEFAULT_ENCODING;
        }
        client.setControlEncoding(encoding);

        try {
            client.connect(url, port);
        } catch (IOException e) {
            throw new SystemException(ErrorCode.FTP001, e);
        }
        try {
            boolean flag = client.login(userName, password);
            if (!flag) {
                throw new Exception("ftp login return false");
            }
        } catch (Exception e) {
            throw new SystemException(ErrorCode.FTP002, e);
        }
        client.enterLocalPassiveMode();
        try {
            client.setFileType(FTPClient.BINARY_FILE_TYPE);
        } catch (IOException e) {
            throw new SystemException(ErrorCode.FTP003, e);
        }
    }

    protected boolean isConnected() {
        return client.isConnected();
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                client.disconnect();
            } catch (IOException e) {
                LOGGER.error("disconnect ftp server error", e);
            }
        }
    }

    public FTPFile[] list(String remotePath, FTPFileFilter filter) throws SystemException {
        try {
            return client.listFiles(remotePath, filter);
        } catch (Exception e) {
            throw new SystemException(ErrorCode.FTP006, e);
        }
    }

    public void download(String remotePath, String localPath, String fileName) throws SystemException {
        download(remotePath, fileName, localPath, fileName);
    }

    public void download(String remotePath, String remoteFileName, String localPath, String localFileName) throws SystemException {
        OutputStream os = null;
        try {
            boolean flag;
            flag = client.changeWorkingDirectory(remotePath);
            if (!flag) {
                throw new Exception("FTP更改文件目录失败");
            }

            if (localFileName == null) {
                localFileName = remoteFileName;
            }

            File localPathFile = new File(localPath);
            if (!localPathFile.exists()) {
                boolean result = localPathFile.mkdirs();
                if (!result) {
                    throw new Exception("创建文件夹失败");
                }
            }

            os = new FileOutputStream(new File(localPath, localFileName));
            flag = client.retrieveFile(remoteFileName, os);
            if (!flag) {
                throw new Exception("FTP执行下载返回失败!");
            }
        } catch (Exception e) {
            throw new SystemException(ErrorCode.FTP005, e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    LOGGER.error("upload fail: close output stream error", e);
                }
            }
        }
    }

    public void upload(String remotePath, String localPath, String fileName) throws SystemException {
        upload(remotePath, fileName, localPath, fileName);
    }

    public void upload(String remotePath, String remoteFileName, String localPath, String localFileName) throws SystemException {
        InputStream is = null;
        try {
            boolean flag;
            flag = client.changeWorkingDirectory(remotePath);
            if (!flag) {
                flag = client.makeDirectory(remotePath);
                if (!flag) {
                    throw new Exception("FTP更改文件目录失败");
                }
            }

            if (remoteFileName == null) {
                remoteFileName = localFileName;
            }

            is = new FileInputStream(new File(localPath, localFileName));
            flag = client.storeFile(remoteFileName, is);
            if (!flag) {
                throw new Exception("FTP执行上传返回失败!");
            }
        } catch (Exception e) {
            throw new SystemException(ErrorCode.FTP004, e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("upload fail: close input stream error", e);
                }
            }
        }
    }

    public void makeDirectory(String path) throws SystemException {
        try {
            boolean result = client.makeDirectory(path);
            if (!result) {
                throw new Exception("FTP创建目录失败");
            }
        } catch (Exception e) {
            throw new SystemException(ErrorCode.FTP008, path);
        }
    }

    public void delete(String remotePath, String fileName) throws SystemException {
        try {
            client.deleteFile(remotePath + File.separator + fileName);
        } catch (Exception e) {
            throw new SystemException(ErrorCode.FTP007, fileName);
        }
    }

//    public void remove(String remotePath, String fileName) throws SystemException {
//        try {
//            boolean flag;
//            flag = client.changeWorkingDirectory(remotePath);
//            if (!flag) {
//                throw new Exception("FTP更改文件目录失败");
//            }
//
//            flag = client.deleteFile(remotePath + File.separator + fileName);
//            if (!flag) {
//                throw new Exception("删除文件失败!");
//            }
//        } catch (Exception e) {
//            throw new SystemException(ErrorCode.FTP004, e);
//        }
//    }
}
