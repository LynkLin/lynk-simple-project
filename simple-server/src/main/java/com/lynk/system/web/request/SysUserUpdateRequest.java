package com.lynk.system.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Lynk
 * @since 2017/10/29
 */
@ApiModel(description = "用户信息，不修改则送null或不送值（非空字符串）")
public class SysUserUpdateRequest implements Serializable {
    private static final long serialVersionUID = -4771857660073970469L;
    @ApiModelProperty(value = "ID", required = true)
    private String id;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
