package com.hnq.study.everyday.quarter202302;

/**
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * <p>
 * 不能使用任何内置的库函数，如 sqrt 。
 * <p>
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * <p>
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 * <p>
 *
 * 提示：
 * 1 <= num <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2023/6/2
 * @see <a href="https://leetcode.cn/problems/valid-perfect-square">链接</a>
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare3(1));
        System.out.println(isPerfectSquare3(2));
        System.out.println(isPerfectSquare3(3));
        System.out.println(isPerfectSquare3(4));
        System.out.println(isPerfectSquare3(5));
        System.out.println(isPerfectSquare3(6));
        System.out.println(isPerfectSquare3(7));
        System.out.println(isPerfectSquare3(8));
        System.out.println(isPerfectSquare3(9));
        System.out.println(isPerfectSquare3(10));
        System.out.println(isPerfectSquare3(11));
        System.out.println(isPerfectSquare3(12));
        System.out.println(isPerfectSquare3(13));
        System.out.println(isPerfectSquare3(14));
        System.out.println(isPerfectSquare3(15));
        System.out.println(isPerfectSquare3(16));
    }

    private static boolean isPerfectSquare(int num) {
        // 900ms
        int k = num <= 10 ? num : num / 3;
        for (int i = 1; i <= k; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
     * 由于平方数num=1+3+5+7+...+(2n-1)，故num依次减去这些数结果必然为0，否则就是非完全平方数
     */
    private static boolean isPerfectSquare2(int num) {
        // 0ms
        int k = 1;
        while (num > 0) {
            num -= (2 * k++ - 1);
        }
        return num == 0;
    }

    /**
     * 二分查找
     */
    private static boolean isPerfectSquare3(int num) {
        // 0ms
        int l = 1, r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int t = num / mid;
            if (t == mid) {
                if (num % mid == 0) {
                    return true;
                }
                l = mid + 1;
            } else if (t < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

}
