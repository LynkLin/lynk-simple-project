package com.lynk.system.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lynk on 2017/7/16.
 */
public class MapUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(MapUtil.class);

    private static int DOUBLE = 2;

    public static Map<String, String> makeMap(String key, String value) {
        Map<String, String> map = new HashMap<>(1);
        map.put(key, value);
        return map;
    }

    public static Map<String, String> makeMap(String... args) {
        Map<String, String> map = new HashMap<>(args.length/ DOUBLE);
        for (int i = 0; i < args.length; i = i + DOUBLE) {
            String key = args[i];
            if (i + 1 >= args.length) {
                map.put(key, null);
            } else {
                map.put(key, args[i + 1]);
            }
        }
        return map;
    }
}
