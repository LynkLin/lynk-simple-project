package com.lynk.system.common;

/**
 * @author Lynk
 * @since 2018/04/09
 */
public class DBUtil {
    private static final String PERCENT = "%";

    /**
     * db value start with fieldValue
     * @param fieldValue
     * @return % + fieldValue
     */
    public static String startLikeFormat(String fieldValue) {
        return PERCENT + fieldValue;
    }

    /**
     * db value end with fieldValue
     * @param fieldValue
     * @return fieldValue + %
     */
    public static String endLikeFormat(String fieldValue) {
        return fieldValue + PERCENT;
    }

    /**
     * db value contains fieldValue
     * @param fieldValue
     * @return % + fieldValue + %
     */
    public static String middleLikeFormat(String fieldValue) {
        return fieldValue + PERCENT;
    }
}
