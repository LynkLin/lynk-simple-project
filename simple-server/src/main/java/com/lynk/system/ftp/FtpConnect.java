package com.lynk.system.ftp;

import com.lynk.system.common.ValidateUtil;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lynk @ 2019/04/23
 */
public class FtpConnect {
    private static final Logger LOGGER = LoggerFactory.getLogger(FtpConnect.class);

    private FTPClient ftpClient;

    public void connect(String host, int port, String userName, String password) throws SystemException {
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(host, port);
        } catch (Exception e) {
            throw new SystemException(ErrorCode.FTP001, e);
        }

        try {
            ftpClient.login(userName, password);
            ftpClient.setType(FTPClient.TYPE_BINARY);
        } catch (Exception e) {
            LOGGER.error("FTP connect", e);
            throw new SystemException(ErrorCode.FTP002, e);
        }
    }

    public void setPassive(boolean passive) {
        ftpClient.setPassive(passive);
    }

    public boolean isConnected() {
        return ftpClient.isConnected();
    }

    public void disconnect() throws SystemException {
        try {
            ftpClient.disconnect(true);
        } catch (Exception e) {
            LOGGER.error("FTP disconnect", e);
            throw new SystemException(ErrorCode.FTP011, e);
        }
    }

    public List<String> listFileName(String fileSpec) throws SystemException {
        List<String> fileNames = new ArrayList<>(16);
        FTPFile[] ftpFiles = null;
        if (ValidateUtil.isNotEmpty(fileSpec)) {
            try {
                ftpFiles = ftpClient.list(fileSpec);
            } catch (Exception e) {

                LOGGER.error("FTP list", e);
                throw new SystemException(ErrorCode.FTP006, fileSpec, e);
            }

        } else {
            try {
                ftpFiles = ftpClient.list();
            } catch (Exception e) {

                LOGGER.error("FTP list", e);
                throw new SystemException(ErrorCode.FTP006, "*", e);
            }
        }
        if (ftpFiles != null && ftpFiles.length > 0) {
            for (FTPFile ftpFile: ftpFiles) {
                if (ftpFile.getType() == FTPFile.TYPE_FILE) {
                    fileNames.add(ftpFile.getName());
                }
            }
        }
        return fileNames;
    }

    public boolean fileExists(String fileName) throws SystemException {
        try {
            FTPFile[] files = ftpClient.list();
            for (FTPFile file: files) {
                if (file.getType() == FTPFile.TYPE_FILE && file.getName().equals(fileName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            LOGGER.error("fileExists error", e);
            return false;
        }
    }

    public boolean directoryExists(String parentPath, String directory) {
        try {
            changeDirectory(parentPath);
            FTPFile[] files = ftpClient.list();
            for (FTPFile file: files) {
                if (file.getType() == FTPFile.TYPE_DIRECTORY && file.getName().equals(directory)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            LOGGER.error("directoryExists error", e);
            return false;
        }
    }

    public void changeDirectory(String path) throws SystemException {
        try {
            ftpClient.changeDirectory(path);
        } catch (Exception e) {

            LOGGER.error("FTP change directory", e);
            throw new SystemException(ErrorCode.FTP010, path, e);
        }
    }

    public void createDirectory(String directoryName) throws SystemException {
        try {
            ftpClient.createDirectory(directoryName);
        } catch (Exception e) {

            LOGGER.error("FTP create directory", e);
            throw new SystemException(ErrorCode.FTP008, directoryName, e);
        }
    }

    public void download(String remotePath, String remoteFileName, File localFile) throws SystemException {
        if (localFile.exists()) {
            localFile.delete();
        }
        try {
            ftpClient.changeDirectory(remotePath);
            ftpClient.download(remoteFileName, localFile);
        } catch (Exception e) {
            LOGGER.error("FTP download", e);
            throw new SystemException(ErrorCode.FTP005, remoteFileName, e);
        }
    }

    public void moveFile(String oldPathName, String newPathName) throws SystemException {
        try {
            ftpClient.rename(oldPathName, newPathName);
        } catch (Exception e) {

            LOGGER.error("FTP rename", e);
            throw new SystemException(ErrorCode.FTP009, oldPathName, newPathName, e);
        }
    }
    public void upload(File localFile) throws SystemException {
        if (!localFile.exists()) {
            throw new SystemException(ErrorCode.FTP012);
        }
        try {
            ftpClient.upload(localFile);
        } catch (Exception e) {

            LOGGER.error("FTP upload", e);
            throw new SystemException(ErrorCode.FTP004, localFile.getName(), e);
        }
    }

    public void deleteFile(String fileName) throws SystemException {
        try {
            ftpClient.deleteFile(fileName);
        } catch (Exception e) {

            LOGGER.error("FTP delete file", e);
            throw new SystemException(ErrorCode.FTP007, fileName, e);
        }
    }

    public void deleteDirectory(String directoryPath) throws SystemException {
        try {
            ftpClient.deleteDirectory(directoryPath);
        } catch (Exception e) {

            LOGGER.error("FTP delete directory", e);
            throw new SystemException(ErrorCode.FTP007, directoryPath, e);
        }
    }
}
