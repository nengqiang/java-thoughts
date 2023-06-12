package com.hnq.study.everyday.quarter202302;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 * <p>
 *
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 *
 * 提示：
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 *
 * @author henengqiang
 * @date 2023/6/12
 * @see <a href="https://leetcode.cn/problems/is-subsequence">链接</a>
 */
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence i = new IsSubsequence();
        System.out.println(i.isSubsequence2("b", "b"));
        System.out.println(i.isSubsequence2("b", "c"));
        System.out.println(i.isSubsequence2("", "ahbgdc"));
        System.out.println(i.isSubsequence2("abc", "ahbgdc"));
        System.out.println(i.isSubsequence2("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        // 0ms
        if (s.length() == 0) {
            return true;
        }
        int k = 0, len = s.length();
        char p = s.charAt(k);
        for (char c : t.toCharArray()) {
            if (p == c) {
                if (k == len - 1) {
                    return true;
                }
                p = s.charAt(++k);
            }
        }
        return false;
    }

    /**
     * 快慢指针
     */
    public boolean isSubsequence2(String s, String t) {
        // 1ms
        int slow = 0, fast = 0, l1 = s.length(), l2 = t.length();
        while (slow < l1 && fast < l2) {
            if (s.charAt(slow) == t.charAt(fast)) {
                slow++;
            }
            fast++;
        }
        return slow == l1;
    }

}
