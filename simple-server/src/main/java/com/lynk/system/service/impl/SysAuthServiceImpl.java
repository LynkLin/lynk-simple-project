package com.lynk.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lynk.system.cache.SysRedisHandle;
import com.lynk.system.common.ValidateUtil;
import com.lynk.system.dao.SysUserDao;
import com.lynk.system.entity.*;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.security.cache.CacheSysUser;
import com.lynk.system.security.cache.CacheSysUserFactory;
import com.lynk.system.security.common.JwtBuilder;
import com.lynk.system.security.common.PasswordHelper;
import com.lynk.system.security.common.SecurityConstant;
import com.lynk.system.service.*;
import com.lynk.system.web.request.LoginRequest;
import com.lynk.system.web.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lynk
 * @since 2017-12-07
 */
@Service
public class SysAuthServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements ISysAuthService {
    @Autowired
    private ISysUserService sysUserServiceImpl;

    @Autowired
    private SysRedisHandle sysRedisHandle;

    @Override
    public TokenResponse create(LoginRequest loginRequest) throws SystemException {
        List<SysUser> sysUsers = baseMapper.selectList(new QueryWrapper<SysUser>().eq(SysUser.NAME, loginRequest.getUserName()).eq(SysUser.IS_DELETED, false));
        if (sysUsers == null || sysUsers.size() == 0) {
            throw new SystemException(ErrorCode.SYS001);
        }

        SysUser sysUser = sysUsers.get(0);
        boolean verifyResult = PasswordHelper.verify(loginRequest.getPassword(), sysUser);
        if (!verifyResult) {
            throw new SystemException(ErrorCode.SYS001);
        }

        //缓存ID
        String cacheId = getCacheId(sysUser.getId());

        //写入缓存
        sysRedisHandle.set(cacheId, createCacheSysUser(sysUser), SecurityConstant.JWT_LIVE_HOUR, TimeUnit.HOURS);
        String token = JwtBuilder.builder().createToken(cacheId);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setUserId(sysUser.getId());
        tokenResponse.setToken(token);

        return tokenResponse;
    }

    @Override
    public String refresh(String token) throws SystemException {
        boolean validResult = JwtBuilder.builder().validateToken(token);
        if (!validResult) {
            throw new SystemException(ErrorCode.SYS002);
        }

        String cacheId = checkCacheUser(token);

        CacheSysUser cacheSysUser = (CacheSysUser) sysRedisHandle.get(cacheId);
        SysUser sysUser = baseMapper.selectById(cacheSysUser.getId());
        cacheSysUser = createCacheSysUser(sysUser);

        sysRedisHandle.set(cacheId, cacheSysUser, SecurityConstant.JWT_LIVE_HOUR, TimeUnit.HOURS);

        return JwtBuilder.builder().refreshToken(cacheId, token);
    }

    @Override
    public void delete(String token) throws SystemException {
        String cacheId = checkCacheUser(token);
        sysRedisHandle.remove(cacheId);
    }

    /**
     * check token and user in token is in cache
     * @param token jwt token
     * @return cacheId
     * @throws SystemException user not login
     */
    private String checkCacheUser(String token) throws SystemException {
        //校验缓存
        String cacheId;
        try {
            cacheId = JwtBuilder.builder().getCacheId(token);
        } catch (SystemException e) {
            throw new SystemException(ErrorCode.SYS002);
        }

        if (ValidateUtil.isEmpty(cacheId)) {
            throw new SystemException(ErrorCode.SYS002);
        }

        if (!sysRedisHandle.exists(cacheId)) {
            throw new SystemException(ErrorCode.SYS002);
        }
        return cacheId;
    }

    /**
     * generator CacheSysUser for redis
     * @param sysUser user bean
     * @return cache user bean
     */
    private CacheSysUser createCacheSysUser(SysUser sysUser) throws SystemException {
        List<SysPermission> sysPermissions = sysUserServiceImpl.getPermissionByUserId(sysUser.getId());
        return CacheSysUserFactory.create(sysUser, sysPermissions);
    }

    /**
     * redis cache id by user id
     * @param userId user id
     * @return cache id
     */
    private String getCacheId(String userId) {
        return "CACHE_USER_" + userId;
    }
}
