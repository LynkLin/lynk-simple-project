package com.lynk.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lynk.system.common.ValidateUtil;
import com.lynk.system.dao.*;
import com.lynk.system.entity.*;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.security.common.PasswordHelper;
import com.lynk.system.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lynk.system.web.request.SysUserAddRequest;
import com.lynk.system.web.request.SysUserGetRequest;
import com.lynk.system.web.request.SysUserUpdateRequest;
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
 * @since 2019-04-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements ISysUserService {
//    @Autowired
//    private ISysUserRoleService sysUserRoleServiceImpl;
//    @Autowired
//    private ISysRoleService sysRoleServiceImpl;
//    @Autowired
//    private ISysRolePermissionService sysRolePermissionServiceImpl;
//    @Autowired
//    private ISysPermissionService sysPermissionServiceImpl;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRolePermissionDao sysRolePermissionDao;
    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public String add(SysUserAddRequest sysUserAddRequest) throws SystemException {
        String name = sysUserAddRequest.getName();
        int existsCount = baseMapper.selectCount(new QueryWrapper<SysUser>().eq(SysUser.NAME, name).eq(SysUser.IS_DELETED, false));
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

        int result = baseMapper.insert(sysUser);
        if (!retBool(result)) {
            throw new SystemException(ErrorCode.SYS004);
        }
        return sysUser.getId();
    }

    @Override
    public void update(SysUserUpdateRequest sysUserUpdateRequest) throws SystemException {
        SysUser sysUserDb = baseMapper.selectById(sysUserUpdateRequest.getId());
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
            int result = baseMapper.updateById(user);
            if (!retBool(result)) {
                throw new SystemException(ErrorCode.SYS005);
            }
        }
    }

    @Override
    public IPage<SysUser> get(SysUserGetRequest sysUserGetRequest) throws SystemException {
        Page<SysUser> page = new Page<>(sysUserGetRequest.getPage(), sysUserGetRequest.getPerPage());

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        String name = sysUserGetRequest.getName();
        if (ValidateUtil.isNotEmpty(name)) {
            wrapper.eq(SysUser.NAME, name);
        }

        String realName = sysUserGetRequest.getRealName();
        if (ValidateUtil.isNotEmpty(realName)) {
            wrapper.eq(SysUser.REAL_NAME, realName);
        }

        Boolean isDeleted = sysUserGetRequest.getDeleted();
        if (isDeleted != null) {
            wrapper.eq(SysUser.IS_DELETED, isDeleted);
        }

        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public SysUser getById(String id) throws SystemException {
        SysUser user =  baseMapper.selectById(id);
        if (user == null) {
            throw new SystemException(ErrorCode.SYS003);
        }
        return user;
    }

    @Override
    public void delete(String id) throws SystemException {
        int result = baseMapper.deleteById(id);
        if (!retBool(result)) {
            throw new SystemException(ErrorCode.SYS006);
        }
    }

    @Override
    public List<SysPermission> getPermissionByUserId(String userId) throws SystemException {
        List<SysUserRole> sysUserRoles = sysUserRoleDao.selectList(new QueryWrapper<SysUserRole>().eq(SysUserRole.USER_ID, userId));

        boolean isAdmin = false;
        List<String> roleIds = new ArrayList<>(16);
        for (SysUserRole sysUserRole: sysUserRoles) {
            SysRole sysRole = sysRoleDao.selectById(sysUserRole.getRoleId());
            if (sysRole.getAdmin()) {
                isAdmin = true;
                break;
            }
            roleIds.add(sysUserRole.getRoleId());
        }

        if (isAdmin) {
            return sysPermissionDao.selectList(new QueryWrapper<SysPermission>().eq(SysPermission.IS_REQUEST, true));
        } else {
            QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<SysPermission>();
            queryWrapper.eq(SysPermission.IS_REQUEST, true);
            if (roleIds.size() > 0) {
                List<SysRolePermission> sysRolePermissions = sysRolePermissionDao.selectList(new QueryWrapper<SysRolePermission>().in(SysRolePermission.ROLE_ID, roleIds));
                List<String> permissionIds = new ArrayList<>(16);
                for (SysRolePermission sysRolePermission: sysRolePermissions) {
                    if (!permissionIds.contains(sysRolePermission.getPermissionId())) {
                        permissionIds.add(sysRolePermission.getPermissionId());
                    }
                }
                if (permissionIds.size() > 0) {
                    queryWrapper.in(SysPermission.ID, permissionIds);
                }
            }
            return sysPermissionDao.selectList(queryWrapper);
        }
    }
}
