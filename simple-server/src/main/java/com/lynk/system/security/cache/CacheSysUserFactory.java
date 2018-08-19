package com.lynk.system.security.cache;

import com.lynk.system.entity.SysPermission;
import com.lynk.system.entity.SysUser;

import java.util.List;

/**
 * @author Lynk
 * @since 2018/01/10
 */
public class CacheSysUserFactory {
    public static CacheSysUser create(SysUser sysUser, List<SysPermission> sysPermissions) {
        CacheSysUser cacheSysUser = new CacheSysUser();
        cacheSysUser.setId(sysUser.getId());
        cacheSysUser.setName(sysUser.getName());
        cacheSysUser.setRealName(sysUser.getRealName());
        cacheSysUser.setDeleted(sysUser.getDeleted());
        cacheSysUser.setSysPermissions(sysPermissions);
        return cacheSysUser;
    }
}
