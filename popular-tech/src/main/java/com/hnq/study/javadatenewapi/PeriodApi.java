package com.hnq.study.javadatenewapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * 关于时间差的计算，主要涉及到两个类：
 *  Period：处理两个日期之间的差值
 *  Duration：处理两个时间之间的差值
 *
 * 年月日的日期间差值的计算使用 Period 类足以，而时分秒毫秒的时间的差值计算则需要使用 Duration 类。
 *
 * @author henengqiang
 * @date 2018/8/24
 * @since JDK8
 */
public class PeriodApi {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017, 7, 20);
        calculatePeriod(localDate, LocalDate.now());

        LocalTime localTime = LocalTime.of(20, 30);
        calculateDuration(localTime, LocalTime.now());
    }

    /**
     * 计算两个日期之间的差值并打印
     * @param localDate1    日期1
     * @param localDate2    日期2
     */
    private static void calculatePeriod(LocalDate localDate1, LocalDate localDate2) {
        Period period = Period.between(localDate1, localDate2);
        System.out.println("Period between " + localDate1 + " and " + localDate2 + " is:");
        System.out.println(period.getYears() + "year(s) " + period.getMonths() + "month(s) " + period.getDays() + "day(s)");
    }

    /**
     * 计算两个时间之间的差值并打印
     * @param localTime1    时间1
     * @param localTime2    时间2
     */
    private static void calculateDuration(LocalTime localTime1, LocalTime localTime2) {
        Duration duration = Duration.between(localTime1, localTime2);
        System.out.println("Duration between " + localTime1 + " and " + localTime2 + " is:");
        System.out.println(duration.toMinutes() + "minute(s)");
    }

}
