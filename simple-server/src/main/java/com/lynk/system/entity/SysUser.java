package com.lynk.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lynk.system.entity.base.SystemBaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lynk
 * @since 2017-11-16
 */
@TableName("SYS_USER")
public class SysUser extends SystemBaseEntity<SysUser> {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty("用户名")
	private String name;
	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private String password;
	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private String salt;
	@ApiModelProperty("姓名")
	@TableField("REAL_NAME")
	private String realName;
	@ApiModelProperty("是否删除")
	@TableField("IS_DELETED")
	private Boolean deleted;


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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public static final String NAME = "name";

	public static final String PASSWORD = "password";

	public static final String SALT = "salt";

	public static final String REAL_NAME = "real_name";

	public static final String IS_DELETED = "is_deleted";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysUser{" +
				", name=" + name +
				", password=" + password +
				", salt=" + salt +
				", realName=" + realName +
				", deleted=" + deleted +
				"}";
	}
}
