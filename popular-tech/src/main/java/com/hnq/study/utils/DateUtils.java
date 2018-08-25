package com.hnq.study.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author henengqiang
 * @date 2018/8/25
 */
public class DateUtils {

    /**
     * Calendar --> String
     * @param calendar  {@link Calendar}
     * @param format    转换的格式，例："yyyy年MM月dd日 HH时mm分ss秒"
     * @return          按照转换格式转换出来的时间字符串
     */
    public static String dateToString(Calendar calendar, String format) {
        Date date = calendar.getTime();
        return dateToString(date, format);
    }

    /**
     * Date --> String
     * @param date      {@link Date}
     * @param format    转换的格式，例："yyyy-MM-dd HH:mm:ss"
     * @return          按照转换格式转换出来的时间字符串
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Date --> String
     * @param dateStr   时间字符串
     * @param format    转换的格式，例："yyyy/MM/dd HH:mm:ss"
     * @return          {@link Date}
     * @throws ParseException
     *                  转换异常抛给调用者处理
     */
    public static Date stringToDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateStr);
    }

}
