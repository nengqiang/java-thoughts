package com.hnq.study.everyday.quarter202301;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得n == 2^x ，则认为 n 是 2 的幂次方。
 * <p>
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 * <p>
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：2^4 = 16
 * <p>
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：n = 5
 * 输出：false
 * <p>
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2023/3/24
 * @see <a href="https://leetcode.cn/problems/power-of-two">链接</a>
 */
public class IsPowerOfTwo {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + isPowerOfTwo(i));
        }
    }

    private static boolean isPowerOfTwo(int n) {
        // 0ms
        return n > 0 && (n & (n - 1)) == 0;
    }

}
