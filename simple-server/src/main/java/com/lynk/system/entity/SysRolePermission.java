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
 * @since 2017-12-28
 */
@TableName("SYS_ROLE_PERMISSION")
public class SysRolePermission extends SystemBaseEntity<SysRolePermission> {

    private static final long serialVersionUID = 1L;

	@TableField("ROLE_ID")
	private String roleId;
	@TableField("PERMISSION_ID")
	private String permissionId;


	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public static final String ROLE_ID = "role_id";

	public static final String PERMISSION_ID = "permission_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysRolePermission{" +
			", roleId=" + roleId +
			", permissionId=" + permissionId +
			"}";
	}
}
