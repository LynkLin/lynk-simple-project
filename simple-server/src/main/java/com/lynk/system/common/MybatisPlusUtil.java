package com.lynk.system.common;

/**
 * @author Lynk
 * @since 2017/11/17
 */
public class MybatisPlusUtil {
    /**
     * 拼接mybatis plus的ORDRE BY字符串
     * @param columns
     * @return
     */
    public static String makeOrderByColumns(String ... columns) {
        StringBuilder columnNames = new StringBuilder("");
        if (columns.length == 0) {
            return columnNames.toString();
        }
        for (String column: columns) {
            columnNames.append(column).append(",");
        }

        return columnNames.toString().substring(0, columnNames.length() - 1);
    }
}
