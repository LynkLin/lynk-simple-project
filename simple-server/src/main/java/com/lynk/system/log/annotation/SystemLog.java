package com.lynk.system.log.annotation;

import java.lang.annotation.*;

/**
 * @author Lynk
 * @since 2018/01/11
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLog {
    String description()  default "";
}
