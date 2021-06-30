package com.hnq.study.everyday;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

/**
 * Question see {@link ./万年历.png}

 * @author henengqiang
 * @date 2021/6/8
 */
public class PerpetualCalendar {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter command(mycalendar P1 P2 P3):");
        String[] commands;
        boolean illegalCommands = true;
        do {
            String input = SC.nextLine();
            commands = input.split("\\s+");
            // 0个或多个不包含mycalendar的非法命令
            if (!input.startsWith("mycalendar") || !"mycalendar".equals(commands[0])) {
                System.out.println("请输入正确命令(mycalendar P1 P2 P3):");
                continue;
            }
            // 一个命令
            if (commands.length <= 1) {
                System.out.println("command format: mycalendar P1 P2 P3");
                System.out.println("P1：计算某年某月月历，yyyymm，如200310");
                System.out.println("P2：连续输出多少个月的月历，1-12之间的自然数，默认值为12");
                System.out.println("P3：月历星期开始是“周日”还是“周一”，只有两种选择，sun/mon，默认值为mon");
                System.out.println("enter command(mycalendar P1 P2 P3):");
                continue;
            }
            // 两个命令
            if (!NumberUtils.isDigits(commands[1]) || commands.length > 4) {
                System.out.println("请输入正确命令(mycalendar P1 P2 P3):");
                continue;
            }
            if (commands[1].length() != 6 || Integer.parseInt(commands[1].substring(4)) > 12) {
                System.out.println("请输入正确命令(mycalendar P1 P2 P3):");
                continue;
            }
            // 三个命令
            if (commands.length == 3) {
                if (NumberUtils.isDigits(commands[2])) {
                    int months = Integer.parseInt(commands[2]);
                    if (months < 1 || months > 12) {
                        System.out.println("请输入正确命令(mycalendar P1 P2 P3):");
                        continue;
                    }
                }
                if (!("sun".equals(commands[2]) || "mon".equals(commands[2]))) {
                    System.out.println("请输入正确命令(mycalendar P1 P2 P3):");
                    continue;
                }
            }
            // 四个命令
            if (commands.length == 4) {
                int months = Integer.parseInt(commands[2]);
                if (months < 1 || months > 12) {
                    System.out.println("请输入正确命令(mycalendar P1 P2 P3):");
                    continue;
                }
                if (!("sun".equals(commands[3]) || "mon".equals(commands[3]))) {
                    System.out.println("请输入正确命令(mycalendar P1 P2 P3):");
                    continue;
                }
            }
            illegalCommands = false;
        } while (illegalCommands);
        long start = System.currentTimeMillis();
        int year = Integer.parseInt(commands[1].substring(0, 4));
        int month = Integer.parseInt(commands[1].substring(4));
        int months = 12;
        String weekStart = "mon";
        if (commands.length == 3) {
            if (NumberUtils.isDigits(commands[2])) {
                months = Integer.parseInt(commands[2]);
            } else {
                weekStart = commands[2];
            }
        }
        if (commands.length == 4) {
            months = Integer.parseInt(commands[2]);
            weekStart = commands[3];
        }

        printCalendar(year, month, months, weekStart);

        long end = System.currentTimeMillis();
        long cut = end - start;
        System.out.println("执行时长：" + cut + "ms" + "  作者：" + "hanif");
    }

    private static void printCalendar(int year, int month, int months, String weekStart) {
        boolean primeYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        int lines = (int) Math.ceil(months / 3.0);
        for (int i = 0; i < lines; i++) {
            StringBuilder yearHead = new StringBuilder();
            StringBuilder weekHead = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                yearHead.append(year).append("年").append(month++).append("月");
                for (int k = 0; k < 7; k++) {
                    yearHead.append("  ");
                }
                if ("mon".equals(weekStart)) {
                    weekHead.append("一").append("  ")
                            .append("二").append("  ")
                            .append("三").append("  ")
                            .append("四").append("  ")
                            .append("五").append("  ")
                            .append("六").append("  ")
                            .append("日").append("  ");
                } else {
                    weekHead.append("日").append("  ")
                            .append("一").append("  ")
                            .append("二").append("  ")
                            .append("三").append("  ")
                            .append("四").append("  ")
                            .append("五").append("  ")
                            .append("六").append("  ");
                }
            }

            System.out.println(yearHead);
            System.out.println(weekHead);
            System.out.println();
        }
    }

}
