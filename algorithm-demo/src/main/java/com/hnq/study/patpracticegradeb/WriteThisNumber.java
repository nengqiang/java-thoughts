package com.hnq.study.patpracticegradeb;

import java.util.Scanner;

/**
 * 读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 *
 * 每个测试输入包含 1 个测试用例，即给出自然数 n 的值。这里保证 n 小于 10^100
 *
 * 在一行内输出 n 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。
 *
 * 输入：1234567890987654321123456789
 * 输出：yi san wu
 *
 * 时间限制: 400 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/21
 */
public class WriteThisNumber {

    private static Scanner sc = new Scanner(System.in);

    private static String[] pingYin = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};

    public static void main(String[] args) {
        String n = sc.nextLine();
        writeThisNumber(n);
    }

    private static void writeThisNumber(String n) {
        String[] temp = n.split("");
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Integer.parseInt(temp[i]);
        }
        System.out.println("debug: sum=" + sum);
        String sumStr = String.valueOf(sum);
        temp = sumStr.split("");
        for (int i = 0; i < sumStr.length(); i++) {
            int x = Integer.parseInt(temp[i]);
            System.out.print(pingYin[x]);
            if (i < sumStr.length() - 1) {
                System.out.print(" ");
            }
        }
    }

}
