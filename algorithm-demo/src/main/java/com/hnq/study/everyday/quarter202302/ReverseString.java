package com.hnq.study.everyday.quarter202302;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s[i] 都是 ASCII 码表中的可打印字符
 *
 * @author henengqiang
 * @date 2023/6/1
 * @see <a href="https://leetcode.cn/problems/reverse-string">链接</a>
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString2(s1);
        System.out.println(s1);
        char[] s2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString2(s2);
        System.out.println(s2);
    }

    private static void reverseString(char[] s) {
        // 0ms
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            int j = len - i - 1;
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    private static void reverseString2(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            // 构造 a ^ b 的结果，并放在 a 中
            s[l] ^= s[r];
            // 将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[r] ^= s[l];
            // a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            s[l] ^= s[r];
            l++;
            r--;
        }
    }

}
