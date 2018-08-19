package com.lynk.system.exception.error;

import java.lang.annotation.*;

/**
 * 定义错误码类
 * @author Lynk
 * @since 2017/10/21
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ErrorDefinition {
}
