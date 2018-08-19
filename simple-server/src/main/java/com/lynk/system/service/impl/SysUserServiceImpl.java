package com.lynk.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.lynk.system.entity.*;
import com.lynk.system.dao.SysUserDao;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.security.common.PasswordHelper;
import com.lynk.system.service.*;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lynk.system.web.request.SysUserAddRequest;
import com.lynk.system.web.request.SysUserGetRequest;
import com.lynk.system.web.request.SysUserUpdateRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lynk
 * @since 2017-08-12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements ISysUserService {
    @Autowired
    private ISysUserRoleService sysUserRoleServiceImpl;
    @Autowired
    private ISysRoleService sysRoleServiceImpl;
    @Autowired
    private ISysRolePermissionService sysRolePermissionServiceImpl;
    @Autowired
    private ISysPermissionService sysPermissionServiceImpl;

    @Override
    public String add(SysUserAddRequest sysUserAddRequest) throws SystemException {
        String name = sysUserAddRequest.getName();
        int existsCount = selectCount(new EntityWrapper<SysUser>().eq(SysUser.NAME, name).eq(SysUser.IS_DELETED, false));
        if (existsCount != 0) {
            throw new SystemException(ErrorCode.SYS007, name);
        }

        SysUser sysUser = new SysUser();
        sysUser.setName(name);
        sysUser.setRealName(sysUserAddRequest.getRealName());
        sysUser.setDeleted(true);

        //密码加密
        String salt = PasswordHelper.createRandomSalt();
        String password = sysUserAddRequest.getPassword();
        password = PasswordHelper.encryptPassword(name, password, salt);
        sysUser.setPassword(password);
        sysUser.setSalt(salt);

        boolean result = insert(sysUser);
        if (!result) {
            throw new SystemException(ErrorCode.SYS004);
        }
        return sysUser.getId();
    }

    @Override
    public void update(SysUserUpdateRequest sysUserUpdateRequest) throws SystemException {
        SysUser sysUserDb = selectById(sysUserUpdateRequest.getId());
        //是否需要执行update
        boolean updateFlag = false;

        SysUser user = new SysUser();
        user.setId(sysUserUpdateRequest.getId());

        String realName = sysUserUpdateRequest.getRealName();
        if (realName != null && !realName.equals(sysUserDb.getRealName())) {
            user.setRealName(realName);
            updateFlag = true;
        }

        String password = sysUserUpdateRequest.getPassword();
        if (password != null) {
            //密码加密
            String salt = PasswordHelper.createRandomSalt();
            password = PasswordHelper.encryptPassword(sysUserDb.getName(), password, salt);
            user.setPassword(password);
            user.setSalt(salt);
            updateFlag = true;
        }

        Boolean isDeleted = sysUserUpdateRequest.getDeleted();
        if (isDeleted != null && !isDeleted.equals(sysUserDb.getDeleted())) {
            user.setDeleted(isDeleted);
            updateFlag = true;
        }

        if (updateFlag) {
            boolean result = updateById(user);
            if (!result) {
                throw new SystemException(ErrorCode.SYS005);
            }
        }
    }

    @Override
    public Page<SysUser> get(SysUserGetRequest sysUserGetRequest) throws SystemException {
        Page<SysUser> page = new Page<>(sysUserGetRequest.getPage(), sysUserGetRequest.getPerPage());

        EntityWrapper<SysUser> wrapper = new EntityWrapper<>();

        String name = sysUserGetRequest.getName();
        if (StringUtils.isNotEmpty(name)) {
            wrapper.eq(SysUser.NAME, name);
        }

        String realName = sysUserGetRequest.getRealName();
        if (StringUtils.isNotEmpty(realName)) {
            wrapper.eq(SysUser.REAL_NAME, realName);
        }

        Boolean isDeleted = sysUserGetRequest.getDeleted();
        if (isDeleted != null) {
            wrapper.eq(SysUser.IS_DELETED, isDeleted);
        }

        return selectPage(page, wrapper);
    }

    @Override
    public SysUser getById(String id) throws SystemException {
        SysUser user = selectById(id);
        if (user == null) {
            throw new SystemException(ErrorCode.SYS003);
        }
        return user;
    }

    @Override
    public void delete(String id) throws SystemException {
        boolean result = deleteById(id);
        if (!result) {
            throw new SystemException(ErrorCode.SYS006);
        }
    }

    @Override
    public List<SysPermission> getPermissionByUserId(String userId) throws SystemException {
        List<SysUserRole> sysUserRoles = sysUserRoleServiceImpl.selectList(new EntityWrapper<SysUserRole>().eq(SysUserRole.USER_ID, userId));

        boolean isAdmin = false;
        List<String> roleIds = new ArrayList<>(16);
        for (SysUserRole sysUserRole: sysUserRoles) {
            SysRole sysRole = sysRoleServiceImpl.selectById(sysUserRole.getRoleId());
            if (sysRole.getAdmin()) {
                isAdmin = true;
                break;
            }
            roleIds.add(sysUserRole.getRoleId());
        }

        if (isAdmin) {
            return sysPermissionServiceImpl.selectList(new EntityWrapper<SysPermission>().eq(SysPermission.IS_REQUEST, true));
        } else {
            List<SysRolePermission> sysRolePermissions = sysRolePermissionServiceImpl.selectList(new EntityWrapper<SysRolePermission>().in(SysRolePermission.ROLE_ID, roleIds));

            List<String> permissionIds = new ArrayList<>(16);
            for (SysRolePermission sysRolePermission: sysRolePermissions) {
                if (!permissionIds.contains(sysRolePermission.getPermissionId())) {
                    permissionIds.add(sysRolePermission.getPermissionId());
                }
            }
            return sysPermissionServiceImpl.selectList(new EntityWrapper<SysPermission>().in(SysPermission.ID, permissionIds).eq(SysPermission.IS_REQUEST, true));
        }
    }
}
