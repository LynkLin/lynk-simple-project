package com.lynk.system.security.cache;

import com.lynk.system.entity.SysPermission;
import com.lynk.system.entity.SysUser;

import java.util.List;

/**
 * @author Lynk
 * @since 2018/01/10
 */
public class CacheSysUser extends SysUser {
    private List<SysPermission> sysPermissions;

    public List<SysPermission> getSysPermissions() {
        return sysPermissions;
    }

    public void setSysPermissions(List<SysPermission> sysPermissions) {
        this.sysPermissions = sysPermissions;
    }
}
