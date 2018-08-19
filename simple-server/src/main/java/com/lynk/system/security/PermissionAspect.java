package com.lynk.system.security;

import com.lynk.system.common.Constants;
import com.lynk.system.exception.SystemException;
import com.lynk.system.exception.error.ErrorCode;
import com.lynk.system.security.annotation.RequirePermissions;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Lynk
 * @since 2018/01/13
 */
@Aspect
@Component
@Order(Constants.ASPECT_ORDER_PERMISSION)
public class PermissionAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionAspect.class);

    @Pointcut("@annotation(com.lynk.system.security.annotation.RequirePermissions)")
    public  void permissionAspect() {
    }

    @Before("permissionAspect() && @annotation(requirePermissions)")
    public  void doBefore(RequirePermissions requirePermissions) throws SystemException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[权限验证]{}, {}", requirePermissions.name(), requirePermissions.value());
        }
        String[] permissions = requirePermissions.value();
        if (permissions.length == 1) {
            try {
                SecurityUtils.getSubject().checkPermission(permissions[0]);
            } catch (AuthorizationException e) {
                throw new SystemException(ErrorCode.SYS000);
            }
        } else {
            try {
                SecurityUtils.getSubject().checkPermissions(permissions);
            } catch (AuthorizationException e) {
                throw new SystemException(ErrorCode.SYS000);
            }
        }
    }
}
