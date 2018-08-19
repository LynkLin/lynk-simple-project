package com.lynk.system.common;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author Lynk
 * Date: 2017/8/26
 * Time: 02:11
 */
public class ValidateUtil {
    /**
     * 是否为空，null则返回true
     * @param object String，Collection，Map
     * @return
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            return StringUtils.isEmpty((String) object);
        } else if (object instanceof Collection) {
            return ((Collection) object).size() == 0;
        } else if (object instanceof Map) {
            return ((Map) object).size() == 0;
        }
        return true;
    }

    /**
     * 是否不为空，null则返回false
     * @param object
     * @return
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }
}
