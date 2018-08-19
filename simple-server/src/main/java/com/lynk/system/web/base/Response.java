package com.lynk.system.web.base;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Lynk
 * Date: 2017/9/24
 * Time: 22:33
 */
public class Response<T> implements Serializable {
    /**
     * 成功
     */
    public static final String SUCCESS = "0";
    /**
     * 失败
     */
    public static final String FAILURE = "1";

    @ApiModelProperty( value = "(0-success, 1-failure)")
    private String status;
    private String errorCode;
    @ApiModelProperty( value = "error message")
    private String error;
    private String message;
    private T data;

    protected Response() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
