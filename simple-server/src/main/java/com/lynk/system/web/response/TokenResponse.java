package com.lynk.system.web.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @authory: Lynk
 * @date: 2018/06/09
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
