package com.hnq.study.javadatenewapi;

import java.time.LocalTime;

/**
 *  类似于 LocalDate，LocalTime 专注于时间的处理，它提供小时，分钟，秒，毫微秒的各种处理，
 * 我们依然可以通过类似的方式创建一个 LocalTime 实例。
 *
 *  public static LocalTime now()：根据系统当前时刻获取其中的时间部分内容
 *  public static LocalTime of(int hour, int minute)：显式传入小时和分钟来构建一个实例对象
 *  public static LocalTime of(int hour, int minute, int second)：通过传入时分秒构造实例
 *  public static LocalTime of(int hour, int minute, int second, int nanoOfSecond)：传入时分秒和毫微秒构建一个实例
 *  public static LocalTime ofSecondOfDay(long secondOfDay)：传入一个长整型数值代表当前日已经过去的秒数
 *  public static LocalTime ofNanoOfDay(long nanoOfDay)：传入一个长整型代表当前日已经过去的毫微秒数
 *
 * LocalTime 中也同样封装了很多好用的工具方法，例如：
 *  public int getHour()
 *  public int getMinute()
 *  public int getSecond()
 *  public int getNano()
 *  public LocalTime withHour(int hour):修改当前LocalTime实例中的hour属性并重新返回一个新的实例
 *  public LocalTime withMinute(int minute)
 *  public LocalTime withSecond(int second)
 *
 *  LocalTime 默认使用系统默认时区处理时间
 *
 *  LocalDateTime 类则是集成了 LocalDate 和 LocalTime，它既能表示日期，又能表述时间信息，方法都类似，只是有一部分涉及时区的转换内容
 *
 * @author henengqiang
 * @date 2018/8/25
 * @since JDK8
 */
public class LocalTimeApi {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTime1 = LocalTime.of(23, 59);
        System.out.println(localTime1);

        LocalTime localTime2 = LocalTime.ofSecondOfDay(10);
        System.out.println(localTime2);

    }

}
