package com.lynk.system.web.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Lynk @ 2019/04/22
 */
public class TokenResponse {
    @ApiModelProperty(value = "user id")
    private String userId;
    @ApiModelProperty(value = "token")
    private String token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
