package com.hnq.study.everyday.quarter202304;

/**
 * 种花问题
 * <p>
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * <p>
 *
 * 示例 1：
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 *
 * 提示：
 * 1 <= flowerbed.length <= 2 * 10^4
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 *
 * @author henengqiang
 * @date 2023/10/11
 * @see <a href="https://leetcode.cn/problems/can-place-flowers/">链接</a>
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        CanPlaceFlowers c = new CanPlaceFlowers();
        System.out.println(c.canPlaceFlowers2(new int[]{0, 1 ,0}, 1));
        System.out.println(c.canPlaceFlowers2(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(c.canPlaceFlowers2(new int[]{1, 0, 0, 0, 1}, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 1ms
        if (n <= 0) {
            return true;
        }
        int l = flowerbed.length;
        if (l == 1) {
            return flowerbed[0] == 0 && n == 1;
        }
        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && flowerbed[i + 1] == 0
                        || i == l - 1 && flowerbed[i - 1] == 0) {
                    n--;
                    if (n <= 0) {
                        return true;
                    }
                    flowerbed[i] = 1;
                } else if (i > 0 && i < l - 1) {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        n--;
                        if (n <= 0) {
                            return true;
                        }
                        flowerbed[i] = 1;
                    }
                }
            } else if (i < l - 1) {
                i++;
            }
        }
        return false;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        // 1ms
        int count = 0, m = flowerbed.length, prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                   count+= (i - prev - 2) / 2;
                }
                if (count >= n) {
                    return true;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }

}
