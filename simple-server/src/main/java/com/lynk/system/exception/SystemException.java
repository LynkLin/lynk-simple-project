package com.lynk.system.exception;

import com.lynk.system.common.ValidateUtil;
import com.lynk.system.tool.SysErrorCodeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * @author Lynk on 16/12/1.
 */
public class SystemException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemException.class);
    
    private String errorCode;
    private Object[] args;
    private Exception oriException;

    public SystemException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
        printLog();
    }

    public SystemException(String errorCode, Exception oriException) {
        super(errorCode);
        this.errorCode = errorCode;
        this.oriException = oriException;
        printLog();
    }

    public SystemException(String errorCode, Object argument) {
        super(errorCode);
        this.errorCode = errorCode;
        args = new Object[1];
        args[0] = argument;
    }

    public SystemException(String errorCode, Object argument1, Object argument2) {
        super(errorCode);
        this.errorCode = errorCode;
        args = new Object[2];
        args[0] = argument1;
        args[1] = argument2;
    }

    public SystemException(String errorCode, Object... argument) {
        super(errorCode);
        this.errorCode = errorCode;
        args = argument;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        String message = SysErrorCodeManager.getInstance().getErrorMessage(errorCode);
        if (ValidateUtil.isEmpty(message)) {
            message = "";
        } else {
            message = MessageFormat.format(message, args);
        }
        return message;
    }

    @Override
    public String toString() {
        return "[" + errorCode + "]" + getMessage() + getOriException();
    }

    private void printLog() {
        LOGGER.error(this.toString());
    }

    private String getOriException() {
        if (oriException == null) {
            return "";
        } else {
            return "|||original exception ==> " + oriException.getMessage();
        }
    }
}
