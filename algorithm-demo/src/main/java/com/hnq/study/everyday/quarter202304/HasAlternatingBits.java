package com.hnq.study.everyday.quarter202304;

/**
 * 交替位二进制数
 * <p>
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * <p>
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * <p>
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * <p>
 *
 * 示例 3：
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * <p>
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2023/11/20
 * @see <a href="https://leetcode.cn/problems/binary-number-with-alternating-bits/">链接</a>
 */
public class HasAlternatingBits {

    public static void main(String[] args) {
        HasAlternatingBits h = new HasAlternatingBits();
        System.out.println(h.hasAlternatingBits(5));
        System.out.println(h.hasAlternatingBits(7));
        System.out.println(h.hasAlternatingBits(11));
    }

    public boolean hasAlternatingBits(int n) {
        // 0ms
        String s = Integer.toBinaryString(n);
        for (int i = 1, limit = s.length(); i < limit; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 模拟
     */
    public boolean hasAlternatingBits2(int n) {
        // 0ms
        int prev = 2;
        while (n != 0) {
            int cur = n % 2;
            if (cur == prev) {
                return false;
            }
            prev = cur;
            n /= 2;
        }
        return true;
    }

    /**
     * 位运算
     */
    public boolean hasAlternatingBits3(int n) {
        // 0ms
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }

}
