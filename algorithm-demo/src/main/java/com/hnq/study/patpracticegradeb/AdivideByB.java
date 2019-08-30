package com.hnq.study.patpracticegradeb;

import com.google.common.base.Stopwatch;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 本题要求计算 A/B，其中 A 是不超过 1000 位的正整数，B 是 1 位正整数。你需要输出商数 Q 和余数 R，使得 A=B×Q+R 成立。
 *
 * 输入：
 *  123456789050987654321 7
 *
 * 输出：
 *  17636684150141093474 3
 *
 * 时间限制: 100 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/30
 */
public class AdivideByB {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Stopwatch watch = Stopwatch.createStarted();
        logic();
        watch.stop();
        System.out.println("--------------");
        System.out.println(watch.toString());
    }

    /**
     * // TODO: 2019-08-30 henengqiang 可能需要自己实现运算方法
     */
    private static void logic() {
        String[] input = sc.nextLine().split(" ");
        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);

        String quotient = a.divide(b).toString();
        int remainder = a.remainder(b).intValue();
        System.out.print(quotient + " " + remainder);
    }

}
