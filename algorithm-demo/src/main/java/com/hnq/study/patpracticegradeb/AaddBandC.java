package com.hnq.study.patpracticegradeb;

import java.util.Scanner;

/**
 * A+B 和 C
 *
 * 给定区间 [−2^31,2^31] 内的 3 个整数 A、B 和 C，请判断 A+B 是否大于 C。
 *
 * 输入：
 *  输入第 1 行给出正整数 T (≤10)，是测试用例的个数。随后给出 T 组测试用例，每组占一行，顺序给出 A、B 和 C。整数间以空格分隔。
 *  4
 * 1 2 3
 * 2 3 4
 * 2147483647 0 2147483646
 * 0 -2147483648 -2147483647
 *
 * 输出：
 *  对每组测试用例，在一行中输出 Case #X: true 如果 A+B>C，否则输出 Case #X: false，其中 X 是测试用例的编号（从 1 开始）。
 *  Case #1: false
 *  Case #2: true
 *  Case #3: true
 *  Case #4: false
 *
 * @author henengqiang
 * @date 2019/08/28
 */
public class AaddBandC {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        logic();
    }

    private static void logic() {
        int n = sc.nextInt();
        sc.nextLine();
        boolean[] results = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(" ");
            results[i] = compare(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        }
        for (int i = 0; i < results.length; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    /**
     * // TODO: 2019-08-28 henengqiang 部分正确？
     */
    private static boolean compare(int a, int b, int c) {
        return a + b > c;
    }

}
