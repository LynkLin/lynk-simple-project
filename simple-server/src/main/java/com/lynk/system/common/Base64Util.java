package com.lynk.system.common;

import java.util.Base64;

/**
 * @authory: Lynk
 * @date: 2019/04/20
 */
public class Base64Util {

    /**
     * Base64解密
     * @param source
     * @return
     */
    public static String decode(String source) {
        if (ValidateUtil.isEmpty(source)) {
            return "";
        }
        byte[] target = Base64.getDecoder().decode(source);
        return new String(target);
    }
}
