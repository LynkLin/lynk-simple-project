package com.lynk.system.common;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Lynk on 2016-10-31.
 */
public class DateUtil {
    /**
     * current date/time
     * @param pattern
     * @return
     */
    public static String getNow(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(LocalDateTime.now());
    }

    /**
     * current date
     * @return yyyyMMdd
     */
    public static String getCurrentDate8() {
        return getNow("yyyyMMdd");
    }

    /**
     * current time
     * @return HHmmss
     */
    public static String getCurrentTime6() {
        return getNow("HHmmss");
    }

    /**
     * current date & time
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDateTime19() {
        return getNow("yyyy-MM-dd HH:mm:ss");
    }



    /**
     * current date & time
     * @return yyMMddHHmmss
     */
    public static String getCurrentDateTime12() {
        return getNow("yyMMddHHmmss");
    }

    /**
     * 格式转换
     * @param dateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 格式转换
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
