package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/2/26
 * @see <a href="https://leetcode.cn/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75">种花问题</a>
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        CanPlaceFlowers c = new CanPlaceFlowers();
        System.out.println(c.canPlaceFlowers(new int[]{0, 1, 0}, 1));
        System.out.println(c.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(c.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 1ms
        if (n == 0) {
            return true;
        }
        int len = flowerbed.length;
        if (len == 1) {
            return flowerbed[0] == 0 && n <= 1;
        }
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                } else if (i == len - 1 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                } else if (i > 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }

}
