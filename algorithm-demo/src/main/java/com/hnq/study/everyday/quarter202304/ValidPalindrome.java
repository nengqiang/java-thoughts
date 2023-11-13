package com.hnq.study.everyday.quarter202304;

/**
 * 验证回文串 II
 * <p>
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * <p>
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * <p>
 *
 * 示例 1：
 * 输入：s = "aba"
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * <p>
 *
 * 示例 3：
 * 输入：s = "abc"
 * 输出：false
 * <p>
 *
 * 提示：
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 *
 * @author henengqiang
 * @date 2023/11/10
 * @see <a href="https://leetcode.cn/problems/valid-palindrome-ii/">链接</a>
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.validPalindrome("abc"));
        System.out.println(v.validPalindrome("ebcbbececabbacecbbcbe"));
        System.out.println(v.validPalindrome("a"));
        System.out.println(v.validPalindrome("aa"));
        System.out.println(v.validPalindrome("aba"));
        System.out.println(v.validPalindrome("abca"));
        System.out.println(v.validPalindrome("abcddcbae"));
        System.out.println(v.validPalindrome("abdeedbaa"));
        System.out.println(v.validPalindrome("acc"));
        System.out.println(v.validPalindrome("achcb"));
        System.out.println(v.validPalindrome("abbdeedbaa"));
    }

    /**
     * 贪心算法
     */
    public boolean validPalindrome(String s) {
        // 5ms
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i+ (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) {
                return false;
            }
        }
        return true;
    }

}
