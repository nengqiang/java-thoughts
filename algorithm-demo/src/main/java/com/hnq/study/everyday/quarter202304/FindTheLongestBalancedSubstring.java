package com.hnq.study.everyday.quarter202304;

/**
 * 最长平衡子字符串
 * <p>
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * <p>
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。
 * 请注意，空子字符串也视作平衡子字符串。
 * <p>
 * 返回  s 中最长的平衡子字符串长度。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 * <p>
 *
 * 示例 1：
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * <p>
 *
 * 示例 2：
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * <p>
 *
 * 示例 3：
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 * <p>
 *
 * 提示：
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '1'
 *
 * @author henengqiang
 * @date 2023/11/8
 * @see <a href="https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/?envType=daily-question&envId=2023-11-08">链接</a>
 */
public class FindTheLongestBalancedSubstring {

    public static void main(String[] args) {
        FindTheLongestBalancedSubstring f = new FindTheLongestBalancedSubstring();
        System.out.println(f.findTheLongestBalancedSubstring("0000011110001110"));
        System.out.println(f.findTheLongestBalancedSubstring("00110001110"));
        System.out.println(f.findTheLongestBalancedSubstring("00001111000111"));
        System.out.println(f.findTheLongestBalancedSubstring("01000111"));
        System.out.println(f.findTheLongestBalancedSubstring("00111"));
        System.out.println(f.findTheLongestBalancedSubstring("111"));
    }

    public int findTheLongestBalancedSubstring(String s) {
        // 1ms
        int k0 = 0, k1 = 0, max = 0, len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (k0 > 0) {
                    int l = Math.min(k0, k1);
                    max = Math.max(max, l);
                    k0 = 0;
                    k1 = 1;
                } else {
                    k1++;
                }
            } else {
                k0++;
            }
        }
        if (k0 > 0) {
            int l = Math.min(k0, k1);
            max = Math.max(max, l);
        }

        return max * 2;
    }

}
