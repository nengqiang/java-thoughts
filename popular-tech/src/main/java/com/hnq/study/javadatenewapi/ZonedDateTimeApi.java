package com.hnq.study.javadatenewapi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *  无论是我们的 LocalDate，或是 LocalTime，甚至是 LocalDateTime，它们基本是时区无关的，内部并没有存储时区属性，
 * 而基本用的系统默认时区。往往有些场景之下，缺乏一定的灵活性。
 *
 *  ZonedDateTime 可以被理解为 LocalDateTime 的外层封装，它的内部存储了一个 LocalDateTime 的实例，专门用于普通的日期时间处理。
 * 此外，它还定义了 ZoneId 和 ZoneOffset 来描述时区的概念。
 *
 *  ZonedDateTime 和 LocalDateTime 的一个很大的不同点在于，后者内部并没有存储时区，所以对于系统的依赖性很强，
 * 往往换一个时区可能就会导致程序中的日期时间不一致。
 *
 *  而后者则可以通过传入时区的名称，使用 ZoneId 进行匹配存储，也可以通过传入与零时区的偏移量，使用 ZoneOffset 存储时区信息。
 *
 * 构建一个 ZonedDateTime 实例有以下几种方式：
 *  public static ZonedDateTime now()：系统将以默认时区计算并存储日期时间信息
 *  public static ZonedDateTime now(ZoneId zone)：指定时区
 *  public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)：指定日期时间和时区
 *  public static ZonedDateTime of(LocalDateTime localDateTime, ZoneId zone)
 *  public static ZonedDateTime ofInstant(Instant instant, ZoneId zone)：通过时刻和时区构建实例对象
 *
 * @author henengqiang
 * @date 2018/8/24
 * @since JDK8
 */
public class ZonedDateTimeApi {

    public static void main(String[] args) {

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime1);

        Instant instant = Instant.now();
        ZoneId zoneId1 = ZoneId.of("GMT");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.ofInstant(instant, zoneId1);
        System.out.println(zonedDateTime2);

    }

}
