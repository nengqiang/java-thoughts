package com.hnq.study.everyday.quarter202302;

/**
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写 。比如"Aa"不能当做一个回文字符串。
 * <p>
 *
 * 示例 1:
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 示例 2:
 * 输入:s = "a"
 * 输出:1
 * <p>
 * 示例 3：
 * 输入:s = "aaaaaccc"
 * 输出:7
 * <p>
 *
 * 提示:
 * 1 <= s.length <= 2000
 * s只由小写和/或大写英文字母组成
 * 
 * @author henengqiang
 * @date 2023/6/15
 * @see <a href="https://leetcode.cn/problems/longest-palindrome">链接</a>
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("Abcccdd"));
        System.out.println(l.longestPalindrome("abccccdd"));
        System.out.println(l.longestPalindrome("a"));
        System.out.println(l.longestPalindrome("aaaaaccc"));
    }

    public int longestPalindrome(String s) {
        // 1ms
        int[] ch = new int[26 * 2];
        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                ch[c - 'a' + 26]++;
            } else {
                ch[c - 'A']++;
            }
        }
        int len = 0, re = 0;
        for (int i : ch) {
            int r = i % 2;
            re += r;
            len += (i - r);
        }
        return re > 0 ? len + 1 : len;
    }

}
