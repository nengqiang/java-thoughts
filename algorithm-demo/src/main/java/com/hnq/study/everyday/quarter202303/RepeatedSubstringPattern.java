package com.hnq.study.everyday.quarter202303;

import java.util.Arrays;

/**
 * 给定一个非空的字符串s，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 *
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * <p>
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * <p>
 *
 * 提示：
 * 1 <= s.length <= 10^4
 * s由小写英文字母组成
 *
 * @author henengqiang
 * @date 2023/7/3
 * @see <a href="https://leetcode.cn/problems/repeated-substring-pattern">链接</a>
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        RepeatedSubstringPattern r = new RepeatedSubstringPattern();
        System.out.println(r.repeatedSubstringPattern3("a"));
        System.out.println(r.repeatedSubstringPattern3("aba"));
        System.out.println(r.repeatedSubstringPattern3("abab"));
        System.out.println(r.repeatedSubstringPattern3("abcabcabc"));
    }

    /**
     * 枚举
     */
    public boolean repeatedSubstringPattern(String s) {
        // 10ms
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 字符串匹配
     */
    public boolean repeatedSubstringPattern2(String s) {
        // 100ms
        return (s + s).indexOf(s, 1) != s.length();
    }

    /**
     * 优化的KMP
     */
    public boolean repeatedSubstringPattern3(String s) {
        return kmp(s);
    }

    public boolean kmp(String pattern) {
        // 9ms
        int n = pattern.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        return fail[n - 1] != -1 && n % (n - fail[n - 1] - 1) == 0;
    }

}
