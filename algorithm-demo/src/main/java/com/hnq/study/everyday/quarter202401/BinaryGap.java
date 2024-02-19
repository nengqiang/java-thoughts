package com.hnq.study.everyday.quarter202401;

/**
 * 二进制间距
 * <p>
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 * <p>
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。
 * 两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 * <p>
 *
 * 示例 1：
 * 输入：n = 22
 * 输出：2
 * 解释：22 的二进制是 "10110" 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * <p>
 *
 * 示例 2：
 * 输入：n = 8
 * 输出：0
 * 解释：8 的二进制是 "1000" 。
 * 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
 * <p>
 *
 * 示例 3：
 * 输入：n = 5
 * 输出：2
 * 解释：5 的二进制是 "101" 。
 * <p>
 *
 * 提示：
 * 1 <= n <= 10^9
 *
 * @author henengqiang
 * @date 2024/2/19
 * @see <a href="https://leetcode.cn/problems/binary-gap/">链接</a>
 */
public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap b = new BinaryGap();
        System.out.println(b.binaryGap(22));
        System.out.println(b.binaryGap(8));
        System.out.println(b.binaryGap(5));
    }

    public int binaryGap(int n) {
        // 0ms
        String s = Integer.toBinaryString(n);
        int len = 0, p = -1;
        for (int i = 0, k = s.length(); i < k; i++) {
            if (s.charAt(i) == '1') {
                if (p >= 0) {
                    len = Math.max(len, i - p);
                }
                p = i;
            }
        }
        return len;
    }

    /**
     * 右移+位运算
     */
    public int binaryGap2(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }

}
