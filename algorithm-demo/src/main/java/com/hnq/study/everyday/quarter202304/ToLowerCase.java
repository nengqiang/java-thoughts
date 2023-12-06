package com.hnq.study.everyday.quarter202304;

/**
 * 转换成小写字母
 * <p>
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 * <p>
 *
 * 示例 1：
 * 输入：s = "Hello"
 * 输出："hello"
 * <p>
 *
 * 示例 2：
 * 输入：s = "here"
 * 输出："here"
 * <p>
 *
 * 示例 3：
 * 输入：s = "LOVELY"
 * 输出："lovely"
 * <p>
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 由 ASCII 字符集中的可打印字符组成
 *
 * @author henengqiang
 * @date 2023/12/6
 * @see <a href="https://leetcode.cn/problems/to-lower-case/">链接</a>
 */
public class ToLowerCase {

    public static void main(String[] args) {
        ToLowerCase t = new ToLowerCase();
        System.out.println(t.toLowerCase2("Hello"));
        System.out.println(t.toLowerCase2("here"));
        System.out.println(t.toLowerCase2("LOVELY"));
    }

    public String toLowerCase(String s) {
        // 0ms
        char[] sArr = s.toCharArray();
        char[] res = new char[sArr.length];
        int k = 0;
        for (char c : sArr) {
            if (c >= 'A' && c <= 'Z') {
                res[k++] = (char)(c + 32);
            } else {
                res[k++] = c;
            }
        }
        return new String(res);
    }

    public String toLowerCase2(String s) {
        // 0ms
        StringBuilder sb = new StringBuilder();
        for (int i = 0, limit = s.length(); i < limit; i++) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

}
