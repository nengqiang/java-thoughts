package com.hnq.study.everyday.quarter202302;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 * <p>
 *
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 * <p>
 *
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * 进阶：你能不使用循环或者递归来完成本题吗？
 *
 * @author henengqiang
 * @date 2023/5/26
 * @see <a href="https://leetcode.cn/problems/power-of-four">链接</>
 */
public class IsPowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(1));
    }

    private static boolean isPowerOfFour(int n) {
        // 0ms
        while (n != 0 && n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

}
