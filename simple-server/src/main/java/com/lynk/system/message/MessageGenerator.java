package com.lynk.system.message;

import com.lynk.system.common.DateUtil;
import com.lynk.system.common.ParamKey;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.ftp.FtpConnect;
import com.lynk.system.ftp.FtpFactory;
import com.lynk.system.tool.SequenceManager;
import com.lynk.system.tool.SysParamManager;
import it.sauronsoftware.ftp4j.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author Lynk
 * @since 2017/11/10
 */
public class MessageGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageGenerator.class);
    /**
     *
     * @param phone 手机号
     * @param content 内容
     * @throws Exception
     */
    public static void sendMessage(String phone, String content) throws SystemException {
        String filePath = createMessageTxt(phone, content);
        File txtFile = new File(filePath);

        String ip = SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_IP);
        int port = SysParamManager.getInstance().getIntParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_PORT);
        String user = SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_USER);
        String password = SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_PASSWORD);
        String remotePath = SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_REMOTE_PATH);

        FtpConnect ftpConnect = FtpFactory.getConnect(ip, port, user, password);
        ftpConnect.changeDirectory(remotePath);
        ftpConnect.upload(txtFile);
    }

    private static String createMessageTxt(String phone, String content) throws SystemException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("start generate msg, phone: {} | content: {}", phone, content);
        }

        String msg = SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_CONTENT_START)
                + SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_CONTENT_SPLIT)
                + phone
                + SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_CONTENT_SPLIT)
                + content
                + SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_CONTENT_SPLIT)
                + SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_CONTENT_END);

        String serialNumber = SequenceManager.getInstance().nextSequenceId();
        serialNumber = serialNumber.substring(serialNumber.length() - 4);
        String txtName = "dx_"
                + SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_CHANNEL)
                + "_"
                + DateUtil.getCurrentDateTime12()
                + serialNumber + ".txt";
        File msgFile = new File(SysParamManager.getInstance().getParam(ParamKey.SYSTEM_PARAM_CATEGORY_MSG, ParamKey.SYSTEM_PARAM_MSG_LOCAL_PATH), txtName);

        try (
                FileOutputStream fis = new FileOutputStream(msgFile)
        ) {
            fis.write(msg.getBytes("GBK"));
            fis.flush();

            return msgFile.getAbsolutePath();
        } catch (Exception e) {
            throw new SystemException(ErrorCode.MSG001, e);
        }
    }
}
