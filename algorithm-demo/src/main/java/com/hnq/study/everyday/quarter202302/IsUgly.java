package com.hnq.study.everyday.quarter202302;

/**
 * 丑数 就是只包含质因数2、3 和 5的正整数。
 * <p>
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 *
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * <p>
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * <p>
 *
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数7 。
 * <p>
 *
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2023/5/15
 * @see <a href="https://leetcode.cn/problems/ugly-number">链接</a>
 */
public class IsUgly {

    public static void main(String[] args) {
        System.out.println(isUgly2(6));
        System.out.println(isUgly2(1));
        System.out.println(isUgly2(14));
    }

    private static boolean isUgly(int n) {
        // 0ms
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 0) {
            n /= 2;
        } else if (n % 3 == 0) {
            n /= 3;
        } else if (n % 5 == 0) {
            n /= 5;
        } else {
            return false;
        }
        return isUgly(n);
    }

    private static boolean isUgly2(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 2 == 0) {
            n >>= 1;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

}
