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
@TableName("SYS_USER_ROLE")
public class SysUserRole extends SystemBaseEntity<SysUserRole> {

    private static final long serialVersionUID = 1L;

	@TableField("USER_ID")
	private String userId;
	@TableField("ROLE_ID")
	private String roleId;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public static final String USER_ID = "user_id";

	public static final String ROLE_ID = "role_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysUserRole{" +
			", userId=" + userId +
			", roleId=" + roleId +
			"}";
	}
}
