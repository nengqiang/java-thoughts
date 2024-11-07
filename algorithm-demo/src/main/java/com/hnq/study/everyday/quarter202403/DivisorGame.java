package com.hnq.study.everyday.quarter202403;

/**
 * @author henengqiang
 * @date 2024/11/6
 * @see <a href="https://leetcode.cn/problems/divisor-game/">链接</a>
 */
public class DivisorGame {

    public static void main(String[] args) {
        DivisorGame d = new DivisorGame();
        System.out.println(d.divisorGame2(2));
        System.out.println(d.divisorGame2(3));
    }

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public boolean divisorGame2(int n) {
        // 3ms
        boolean[] f = new boolean[n + 5];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }

            }
        }
        return f[n];
    }

}
