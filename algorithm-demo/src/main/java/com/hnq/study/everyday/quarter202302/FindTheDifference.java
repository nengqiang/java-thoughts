package com.hnq.study.everyday.quarter202302;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t中被添加的字母。
 * <p>
 *
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 *
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * @author henengqiang
 * @date 2023/6/9
 * @see <a href="https://leetcode.cn/problems/find-the-difference">链接</a>
 */
public class FindTheDifference {

    public static void main(String[] args) {
        FindTheDifference f = new FindTheDifference();
        System.out.println(f.findTheDifference3("abcd", "abcde"));
        System.out.println(f.findTheDifference3("", "y"));
    }

    /**
     * 记数
     */
    public char findTheDifference(String s, String t) {
        // 1ms
        char[] a = new char[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (a[c - 'a'] == 0) {
                return c;
            }
            a[c - 'a']--;
        }
        return 0;
    }

    /**
     * 求和
     */
    public char findTheDifference2(String s, String t) {
        // 2ms
        int at = 0;
        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
            if (i < s.length()) {
                at -= s.charAt(i);
            }
        }
        return (char) at;
    }

    /**
     * 位运算
     */
    public char findTheDifference3(String s, String t) {
        // 2ms
        int ret = 0;
        for (int i = 0; i < t.length(); i++) {
            ret ^= t.charAt(i);
            if (i < s.length()) {
                ret ^= s.charAt(i);
            }
        }
        return (char) ret;
    }

}
