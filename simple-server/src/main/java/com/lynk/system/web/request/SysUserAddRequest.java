package com.lynk.system.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Lynk
 * @since 2017/10/29
 */
@ApiModel(description = "user info")
public class SysUserAddRequest implements Serializable {
    private static final long serialVersionUID = -2547607395955697279L;

    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String password;
    @ApiModelProperty(required = true)
    private String realName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
