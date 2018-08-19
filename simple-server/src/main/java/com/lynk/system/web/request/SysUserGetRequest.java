package com.lynk.system.web.request;

import com.lynk.system.web.base.AbstractPageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Lynk
 * @since 2017/10/29
 */
@ApiModel(description = "查找用户")
public class SysUserGetRequest extends AbstractPageRequest implements Serializable {
    private static final long serialVersionUID = -8675632874195544211L;

    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
