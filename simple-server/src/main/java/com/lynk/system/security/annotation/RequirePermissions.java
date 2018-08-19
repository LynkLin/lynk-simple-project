package com.lynk.system.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see org.apache.shiro.authz.annotation.RequiresPermissions
 * @author Lynk
 * @since 2018/01/13
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequirePermissions {
    /**
     * The permission string which will be passed to {@link org.apache.shiro.subject.Subject#isPermitted(String)}
     * to determine if the user is allowed to invoke the code protected by this annotation.
     * rule: url:method, like: /system/task:POST
     */
    String[] value() default "";

    /**
     * permission id
     * @return
     */
    String id();

    /**
     * permission name
     * @return
     */
    String name();
}
