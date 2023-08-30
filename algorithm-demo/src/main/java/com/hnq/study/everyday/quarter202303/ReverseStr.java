package com.hnq.study.everyday.quarter202303;

/**
 * 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 *
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 *
 * @author henengqiang
 * @date 2023/8/30
 * @see <a href="https://leetcode.cn/problems/reverse-string-ii/">链接</a>
 */
public class ReverseStr {

    public static void main(String[] args) {
        ReverseStr r = new ReverseStr();
        System.out.println(r.reverseStr2("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
        System.out.println(r.reverseStr2("abcd", 2));
        System.out.println(r.reverseStr2("abcdefg", 2));
        System.out.println(r.reverseStr2("abcdef", 100));
    }

    public String reverseStr(String s, int k) {
        // 1ms
        int len = s.length();
        if (k <= 1 || s.length() <= 1) {
            return s;
        }
        if (len <= k) {
            return reverse(s);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; (i == 0 ? 1 : i) * k < len; i += 2) {
            int s1End = (i + 1) * k, s2End = (i + 2) * k;
            if (s1End >= len) {
                ans.append(reverse(s.substring(i * k)));
            } else {
                ans.append(reverse(s.substring(i * k, s1End)));
            }
            if (s2End >= len) {
                if (s1End <= len) {
                    ans.append(s.substring(s1End));
                }
            } else {
                ans.append(s, s1End, s2End);
            }
        }
        return ans.toString();
    }

    public String reverse(String s) {
        int len = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char tmp = c[i];
            c[i] = c[len - 1 - i];
            c[len - 1 - i] = tmp;
        }
        return String.valueOf(c);
    }

    public String reverseStr2(String s, int k) {
        // 0ms
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse2(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse2(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

}
