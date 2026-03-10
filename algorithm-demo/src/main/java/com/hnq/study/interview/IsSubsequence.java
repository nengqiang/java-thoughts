package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/3/10
 * @see <a href="https://leetcode.cn/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75">判断子序列</a>
 */
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence i = new IsSubsequence();
        System.out.println(i.isSubsequence("b", "abc"));
        System.out.println(i.isSubsequence("abc", "ahbgdc"));
        System.out.println(i.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        // 1ms
        int len1 = s.length(), len2 = t.length();
        if (len1 == 0) {
            return true;
        }
        int left = 0, right = 0;
        while (right < len2) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                if (left == len1) {
                    return true;
                }
            }
            right++;
        }

        return false;
    }

    // 动态规划，dp数组？

}
