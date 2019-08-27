package com.hnq.study.patpracticegradeb;

import java.util.Scanner;

/**
 * 让我们用字母 B 来表示“百”、字母 S 表示“十”，用 12...n 来表示不为零的个位数字 n（<10），换个格式来输出任一个不超过 3 位的正整数。
 * 例如  234 应该被输出为 BBSSS1234，因为它有 2 个“百”、3 个“十”、以及个位的 4。
 *
 * 输入：
 *  每个测试输入包含 1 个测试用例，给出正整数 n（<1000）。
 *  234
 *
 * 输出：
 *  每个测试用例的输出占一行，用规定的格式输出 n。
 *  BBSSS1234
 *
 * 时间限制: 400 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/26
 */
public class AnotherFormatOutputInteger {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num = sc.nextInt();
        outputInteger(num);
    }

    private static void outputInteger(int num) {
        String[] nums = String.valueOf(num).split("");
        switch (nums.length) {
            case 1:
                int x = Integer.parseInt(nums[0]);
                printSingleDigit(x);
                break;
            case 2:
                int y = Integer.parseInt(nums[0]);
                x = Integer.parseInt(nums[1]);
                printTen(y, "S");
                printSingleDigit(x);
                break;
            case 3:
                int z = Integer.parseInt(nums[0]);
                y = Integer.parseInt(nums[1]);
                x = Integer.parseInt(nums[2]);
                printTen(z, "B");
                printTen(y, "S");
                printSingleDigit(x);
                break;
                default : break;
        }
    }

    private static void printTen(int y, String s) {
        for (int i = 0; i < y; i++) {
            System.out.print(s);
        }
    }

    private static void printSingleDigit(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print((i + 1));
        }
    }

}
