package com.hnq.study.everyday.quarter202401;

import java.util.Stack;

/**
 * 删除子串后的字符串最小长度
 * <p>
 * 给你一个仅由 大写 英文字符组成的字符串 s 。
 * <p>
 * 你可以对此字符串执行一些操作，在每一步操作中，你可以从 s 中删除 任一个 "AB" 或 "CD" 子字符串。
 * <p>
 * 通过执行操作，删除所有 "AB" 和 "CD" 子串，返回可获得的最终字符串的 最小 可能长度。
 * <p>
 * 注意，删除子串后，重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串。
 * <p>
 *
 *
 * 示例 1：
 * 输入：s = "ABFCACDB"
 * 输出：2
 * 解释：你可以执行下述操作：
 * - 从 "ABFCACDB" 中删除子串 "AB"，得到 s = "FCACDB" 。
 * - 从 "FCACDB" 中删除子串 "CD"，得到 s = "FCAB" 。
 * - 从 "FCAB" 中删除子串 "AB"，得到 s = "FC" 。
 * 最终字符串的长度为 2 。
 * 可以证明 2 是可获得的最小长度。
 * <p>
 *
 * 示例 2：
 * 输入：s = "ACBBD"
 * 输出：5
 * 解释：无法执行操作，字符串长度不变。
 * <p>
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 仅由大写英文字母组成
 *
 * @author henengqiang
 * @date 2024/1/10
 * @see <a href="https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/?envType=daily-question&envId=2024-01-10">链接</a>
 */
public class MinLength {

    public static void main(String[] args) {
        MinLength m = new MinLength();
        System.out.println(m.minLength2("ABFCACDB"));
        System.out.println(m.minLength2("ACBBD"));
    }

    public int minLength(String s) {
        // 26ms
        s = s.replaceAll("AB", "").replaceAll("CD", "");
        if (s.contains("AB") || s.contains("CD")) {
            return minLength(s);
        }
        return s.length();
    }

    /**
     * 凡是和匹配相关的（括号匹配、字母匹配等等），基本上都是用栈
     */
    public int minLength2(String s) {
        // 8ms
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 要判断下栈的大小，不然直接peek()会报错。匹配上了的话，直接弹出栈顶字母
            if (s.charAt(i) == 'B' && stack.size() > 0 && stack.peek() == 'A'
                || s.charAt(i) == 'D' && stack.size() > 0 && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size();
    }

}
