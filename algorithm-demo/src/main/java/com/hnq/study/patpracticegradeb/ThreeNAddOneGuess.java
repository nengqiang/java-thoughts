package com.hnq.study.patpracticegradeb;

import java.util.Scanner;

/**
 * 卡拉兹(Callatz)猜想：
 *
 * 对任何一个正整数 n，如果它是偶数，那么把它砍掉一半；如果它是奇数，那么把 (3n+1) 砍掉一半。这样一直反复砍下去，最后一定在某一步得到 n=1。
 * 卡拉兹在 1950 年的世界数学家大会上公布了这个猜想，传说当时耶鲁大学师生齐动员，拼命想证明这个貌似很傻很天真的命题，结果闹得学生们无心学业，
 * 一心只证 (3n+1)，以至于有人说这是一个阴谋，卡拉兹是在蓄意延缓美国数学界教学与科研的进展……
 *
 * 我们今天的题目不是证明卡拉兹猜想，而是对给定的任一不超过 1000 的正整数 n，简单地数一下，需要多少步（砍几下）才能得到 n=1？
 *
 * 时间限制: 400 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/21
 */
public class ThreeNAddOneGuess {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        System.out.println(countSteps(n));
    }

    private static int countSteps(int n) {
        if (n <= 1) {
            return 0;
        }
        int steps = 0;
        while (n > 1) {
            if (!isEven(n)) {
                n = (3 * n + 1) / 2;
                steps++;
            }
            if (isEven(n)) {
                n = n / 2;
                steps++;
            }
        }
        return steps;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

}
