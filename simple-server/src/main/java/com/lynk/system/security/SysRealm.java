package com.lynk.system.security;

import com.lynk.system.cache.SysRedisHandle;
import com.lynk.system.common.ValidateUtil;
import com.lynk.system.entity.*;
import com.lynk.system.exception.SystemException;
import com.lynk.system.security.cache.CacheSysUser;
import com.lynk.system.security.common.JwtBuilder;
import com.lynk.system.security.common.SecurityConstant;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Lynk
 * @since 2017/10/22
 */
public class SysRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysRealm.class);

    @Autowired
    private SysRedisHandle sysRedisHandle;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtShiroToken;
    }

    /**
     * 登录时认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException JwtToken
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        if (ValidateUtil.isEmpty(token)) {
            throw new AuthenticationException();
        }

        //校验TOKEN格式
        boolean validResult = JwtBuilder.builder().validateToken(token);
        if (!validResult) {
            throw new AuthenticationException();
        }

        //校验缓存
        String cacheId;
        try {
            cacheId = JwtBuilder.builder().getCacheId(token);
        } catch (SystemException e) {
            throw new AuthenticationException();
        }

        if (ValidateUtil.isEmpty(cacheId)) {
            throw new AuthenticationException();
        }

        if (!sysRedisHandle.exists(cacheId)) {
            throw new AuthenticationException();
        }

        return new SimpleAuthenticationInfo(token, token, getName());
    }

    /**
     * 权限认证, permission中验证URL
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String cacheId = JwtBuilder.builder().getCacheId(principalCollection.toString());
        CacheSysUser sysUser = (CacheSysUser) sysRedisHandle.get(cacheId);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (sysUser != null) {
            List<SysPermission> sysPermissions = sysUser.getSysPermissions();
            if (sysPermissions != null) {
                for (SysPermission sysPermission: sysPermissions) {
                    if (!sysPermission.getRequest()) {
                        continue;
                    }
                    String permissionStr = sysPermission.getUrl() + SecurityConstant.PERMISSION_SPLIT + sysPermission.getMethod();
                    simpleAuthorizationInfo.addStringPermission(permissionStr);
                }
            }
        }
        return simpleAuthorizationInfo;
    }
}
