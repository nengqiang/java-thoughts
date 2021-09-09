package com.hnq.study.everyday;

/**
 * 判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 * 示例 1：
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 *
 * 提示：
 * 1 <= n <= 231 - 1
 *
 * @author henengqiang
 * @date 2021/09/08
 * @see <a href="https://leetcode-cn.com/problems/happy-number">链接</a>
 */
public class IsHappy {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

    private static final int[] UNHAPPY = new int[] {2, 4, 16, 37, 58, 89, 145, 42, 20};

    private static boolean isHappy(int n) {
        // 0ms
        for (int i : UNHAPPY) {
            if (n == i) {
                return false;
            }
        }
        int x = 0;
        while (n >= 10) {
            int remain = n % 10;
            x += remain * remain;
            n /= 10;
        }
        x += n * n;
        return x == 1 || isHappy(x);
    }

}
