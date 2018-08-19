package com.lynk.system.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.lynk.system.entity.SysPermission;
import com.lynk.system.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;
import com.lynk.system.exception.SystemException;
import com.lynk.system.web.request.SysUserAddRequest;
import com.lynk.system.web.request.SysUserGetRequest;
import com.lynk.system.web.request.SysUserUpdateRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lynk
 * @since 2017-08-12
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 新增用户
     * @param sysUserAddRequest
     * @return
     * @throws SystemException
     */
    String add(SysUserAddRequest sysUserAddRequest) throws SystemException;

    /**
     * 更新用户信息
     * @param sysUserUpdateRequest
     * @return
     * @throws SystemException
     */
    void update(SysUserUpdateRequest sysUserUpdateRequest) throws SystemException;

    /**
     * 查找用户
     * @param sysUserGetRequest
     * @return
     * @throws SystemException
     */
    Page<SysUser> get(SysUserGetRequest sysUserGetRequest) throws SystemException;

    /**
     * 获取单个用户
     * @param id
     * @return
     * @throws SystemException
     */
    SysUser getById(String id) throws SystemException;

    /**
     * 删除用户
     * @param id
     * @throws SystemException
     */
    void delete(String id) throws SystemException;

    /**
     * 获取用户权限列表
     * @param userId
     * @return
     * @throws SystemException
     */
    List<SysPermission> getPermissionByUserId(String userId) throws SystemException;
}
