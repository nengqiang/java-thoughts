package com.hnq.study.javadatenewapi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  Java 8 的新式日期时间 API 中，DateTimeFormatter 作为格式化日期时间的主要类，
 * 它与之前的 DateFormat 类最大的不同就在于它是线程安全的，其他的使用上的操作基本类似。
 *
 *  DateTimeFormatter 提供将 format 方法将一个日期时间对象转换成格式化的字符串，
 * 但是反过来的操作却建议使用具体的日期时间类自己的 parse 方法，这样可以省去类型转换的步骤。
 *
 * @author henengqiang
 * @date 2018/8/26
 * @since JDK8
 */
public class DateTimeFormatterApi {

    private static String pattern1 = "yyyy-MM-dd HH:mm:ss";

    private static String pattern2 = "yyyy年MM月dd日 HH时mm分ss秒";

    private static String pattern3 = "yyyy-MM-dd";

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTimeToString(localDateTime, pattern3));
        System.out.println(localDateTimeToString(localDateTime, pattern2));
        System.out.println(stringToLocalDateTime("2018-01-01 01:01:01", pattern1));
    }

    /**
     * LocalDateTime --> String
     * @param localDateTime 时间格式的日期时间
     * @param pattern       转换的格式，例："yyyy-MM-dd HH:mm:ss"
     * @return              String 格式的日期时间
     */
    private static String localDateTimeToString(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(localDateTime);
    }

    /**
     * String --> LocalDateTime
     * @param dateStr   String 格式的时间
     * @param pattern   转换的格式，例："yyyy年MM月dd日 HH时mm分ss秒"
     * @return          时间格式的日期时间
     */
    private static LocalDateTime stringToLocalDateTime(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateStr, formatter);
    }

}
