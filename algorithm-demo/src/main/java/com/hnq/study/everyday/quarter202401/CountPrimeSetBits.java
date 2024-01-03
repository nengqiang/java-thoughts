package com.hnq.study.everyday.quarter202401;

/**
 * 二进制表示中质数个计算置位
 * <p>
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 * <p>
 * 计算置位位数 就是二进制表示中 1 的个数。
 * <p>
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 * <p>
 *
 * 示例 1：
 * 输入：left = 6, right = 10
 * 输出：4
 * 解释：
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 共计 4 个计算置位为质数的数字。
 * <p>
 *
 * 示例 2：
 * 输入：left = 10, right = 15
 * 输出：5
 * 解释：
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 * <p>
 *
 * 提示：
 * 1 <= left <= right <= 10^6
 * 0 <= right - left <= 10^4
 *
 * @author henengqiang
 * @date 2024/1/3
 * @see <a href="https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/">链接</a>
 */
public class CountPrimeSetBits {

    public static void main(String[] args) {
        CountPrimeSetBits c = new CountPrimeSetBits();
        System.out.println(c.countPrimeSetBits2(6, 10));
        System.out.println(c.countPrimeSetBits2(10, 15));
    }

    /**
     * 数学+位运算
     */
    public int countPrimeSetBits(int left, int right) {
        // 7ms
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断质数优化
     */
    public int countPrimeSetBits2(int left, int right) {
        // 2ms
       int ans = 0;
        for (int i = left; i <= right; i++) {
            if (((1 << Integer.bitCount(i)) & 665772) != 0) {
                ans++;
            }
        }
        return ans;
    }

}
