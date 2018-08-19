package com.lynk.system.tool;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author Lynk on 2017/2/15.
 */
public class AppManager implements ApplicationContextAware {
    private static ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    public static Object getBean(String name) {
        return appContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return appContext.getBean(name, requiredType);
    }

    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
        return appContext.getBeansWithAnnotation(annotationType);
    }
}
