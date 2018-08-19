package com.lynk.system.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Lynk
 * @since 2017/10/27
 */
@ApiModel(description = "info for login")
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = -6335976161587254454L;

    @ApiModelProperty(required = true)
    private String userName;
    @ApiModelProperty(required = true)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
