package com.lynk.system.tool;

import com.lynk.system.exception.annotation.ErrorCodeDefinition;
import com.lynk.system.exception.annotation.ErrorDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lynk2016/12/30.
 */
public class SysErrorCodeManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysErrorCodeManager.class);

    private static SysErrorCodeManager sysErrorCodeManager;

    private static Map<String, String> errorMap = new HashMap<>();

    public static SysErrorCodeManager getInstance() {
        if (sysErrorCodeManager == null) {
            sysErrorCodeManager = new SysErrorCodeManager();
        }
        return sysErrorCodeManager;
    }

    private SysErrorCodeManager() {
    }

    public void init() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("start init system error code");
        }

        Map<String, Object> errorBeans = AppManager.getBeansWithAnnotation(ErrorDefinition.class);
        for (Object errorBean: errorBeans.values()) {
            Class clazz = errorBean.getClass();

            int count = 0;
            Field[] fields = clazz.getDeclaredFields();
            for(Field field: fields) {
                ErrorCodeDefinition errorCodeDefinition = field.getAnnotation(ErrorCodeDefinition.class);
                String code;
                try {
                    code = field.get(clazz).toString();
                } catch (IllegalAccessException e) {
                    code = "";
                }
                String description = errorCodeDefinition.description();

                errorMap.put(code, description);
                count++;
            }
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("load {} error definitions from class", count, clazz.getSimpleName());
            }

        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("init system error code finish");
        }
    }

    public String getErrorMessage(String errorCode) {
        String errorMessage = errorMap.get( errorCode);
        return errorMessage == null? errorCode: errorMessage;
    }
}
