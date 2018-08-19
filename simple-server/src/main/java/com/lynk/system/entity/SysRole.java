package com.lynk.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.lynk.system.entity.base.SystemBaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lynk
 * @since 2017-11-16
 */
@TableName("SYS_ROLE")
public class SysRole extends SystemBaseEntity<SysRole> {

    private static final long serialVersionUID = 1L;

	private String name;
	@TableField("IS_ADMIN")
	private Boolean admin;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public static final String NAME = "name";

	public static final String IS_ADMIN = "is_admin";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysRole{" +
			", name=" + name +
			", admin=" + admin +
			"}";
	}
}
