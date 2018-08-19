package com.lynk.system.exception.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义错误码注解
 * @author Lynk
 * @since 2017/10/21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ErrorCodeDefinition {
    /**
     * 错误码描述
     * @return
     */
    String description() default "";

    /**
     * 错误码描述英文
     * @return
     */
    String descriptionEn() default "";
}
