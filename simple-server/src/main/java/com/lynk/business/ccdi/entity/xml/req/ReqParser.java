package com.lynk.business.ccdi.entity.xml.req;

import com.lynk.system.common.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXB;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.List;

@Component
public class ReqParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReqParser.class);

    public <T> T parseReqFile(String filePath, Class<T> clz) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        T t = JAXB.unmarshal(file, clz);
        parseFileClass(t);
        return t;
    }

    private <T> void parseFileClass(T t) {
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            String value = null;
            try {
                Object fieldObj = field.get(t);
                if (fieldObj != null) {
                    if (fieldObj instanceof List) {
                        List fieldObjs = (List) fieldObj;
                        for (Object fieldTmp: fieldObjs) {
                            parseFileClass(fieldTmp);
                        }
                    } else if (fieldObj instanceof String) {
                        value = fieldObj.toString();
                    } else {
                        parseFileClass(fieldObj);
                    }
                }
            } catch (IllegalAccessException e) {
                value = "";
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error("get {}.{} value error", clazz.getName(), field.getName());
                }
            }
            if (ValidateUtil.isNotEmpty(value)) {
                byte[] valueBytes = Base64.getDecoder().decode(value);
                String newValue = new String(valueBytes);
                try {
                    field.set(t, newValue);
                } catch (IllegalAccessException e) {
                    if (LOGGER.isErrorEnabled()) {
                        LOGGER.error("set {}.{} value {} error", clazz.getName(), field.getName(), newValue);
                    }
                }
            }
        }
    }
}
