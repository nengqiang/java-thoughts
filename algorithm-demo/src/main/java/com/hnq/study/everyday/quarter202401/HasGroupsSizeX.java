package com.hnq.study.everyday.quarter202401;

/**
 * 卡牌分组
 *
 * @author henengqiang
 * @date 2024/3/14
 * @see <a href="https://leetcode.cn/problems/x-of-a-kind-in-a-deck-of-cards/">链接</a>
 */
public class HasGroupsSizeX {

    public static void main(String[] args) {
        HasGroupsSizeX h = new HasGroupsSizeX();
        System.out.println(h.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(h.hasGroupsSizeX(new int[]{1,1,2,2,2,2}));
        System.out.println(h.hasGroupsSizeX(new int[]{1, 2, 3}));
        System.out.println(h.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
    }

    /**
     * 求最大公约数是否>=2
     */
    public boolean hasGroupsSizeX(int[] deck) {
        // 2ms
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }

        int g = -1;
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                if (g == -1) {
                    g = count[i];
                } else {
                    g = gcd(g, count[i]);
                }
            }
        }
       return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

}
