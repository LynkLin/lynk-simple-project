package com.lynk.system.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.lynk.system.entity.SysPermission;
import com.lynk.system.entity.SysUser;
import com.lynk.system.exception.SystemException;
import com.lynk.system.log.annotation.SystemLog;
import com.lynk.system.security.annotation.RequirePermissions;
import com.lynk.system.service.ISysUserService;
import com.lynk.system.web.request.SysUserAddRequest;
import com.lynk.system.web.request.SysUserGetRequest;
import com.lynk.system.web.request.SysUserUpdateRequest;
import com.lynk.system.web.base.PageResponse;
import com.lynk.system.web.base.Response;
import com.lynk.system.web.base.ResponseFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lynk
 * @since 2017-09-18
 */
@RestController
@Api(value = "system user", description = "user manage")
@RequestMapping("v1/system/user")
@RequirePermissions(id = "USER_GROUP", name = "User Group")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserServiceImpl;

    @ApiOperation("create user")
    @PostMapping(value="/")
    @SystemLog(description = "create user")
    @RequirePermissions(id = "NEW_USER", value = "/system/user:POST", name = "create user")
    public Response add(SysUserAddRequest sysUserAddRequest) {
        try {
            String id = sysUserServiceImpl.add(sysUserAddRequest);
            SysUser user = sysUserServiceImpl.getById(id);
            return ResponseFactory.createSuccessResponse(user);
        } catch (SystemException e) {
            return ResponseFactory.createFailResponse(e);
        }
    }

    @ApiOperation("modify user")
    @PutMapping(value="/")
    @SystemLog(description = "modify user")
    @RequirePermissions(id = "MOD_USER", value = "/system/user:PUT", name = "modify user")
    public Response update(SysUserUpdateRequest sysUserUpdateRequest) {
        try {
            sysUserServiceImpl.update(sysUserUpdateRequest);
            SysUser user = sysUserServiceImpl.getById(sysUserUpdateRequest.getId());
            return ResponseFactory.createSuccessResponse(user);
        } catch (SystemException e) {
            return ResponseFactory.createFailResponse(e);
        }
    }

    @ApiOperation("search users")
    @GetMapping(value="/")
    @SystemLog(description = "search users")
    @RequirePermissions(id = "GET_USERS", value = "/system/user:GET", name = "search users")
    public PageResponse get(SysUserGetRequest sysUserGetRequest) {
        try {
            Page<SysUser> page = sysUserServiceImpl.get(sysUserGetRequest);
            return ResponseFactory.createPageResponse(page);
        } catch (SystemException e) {
            return ResponseFactory.createFailPageResponse(e);
        }
    }

    @ApiOperation("get user info by id")
    @GetMapping("/{id}")
    @SystemLog(description = "get user info by id")
    @RequirePermissions(id = "GET_USER", value = "/system/user/{id}:GET", name = "get user info by id")
    public Response get(@PathVariable String id) {
        try {
            SysUser user = sysUserServiceImpl.getById(id);
            return ResponseFactory.createSuccessResponse(user);
        } catch (SystemException e) {
            return ResponseFactory.createFailPageResponse(e);
        }
    }

    @ApiOperation("get user permissions by id")
    @GetMapping("/{id}/permissions")
    @SystemLog(description = "get user permissions by id")
    @RequirePermissions(id = "GET_USER_PERMISSIONS", value = "/system/user/{id}/permissions:GET", name = "get user permissions by id")
    public Response getUserPermission(@PathVariable String id) {
        try {
            List<SysPermission> sysPermissions = sysUserServiceImpl.getPermissionByUserId(id);
            return ResponseFactory.createSuccessResponse(sysPermissions);
        } catch (SystemException e) {
            return ResponseFactory.createFailPageResponse(e);
        }
    }
}
