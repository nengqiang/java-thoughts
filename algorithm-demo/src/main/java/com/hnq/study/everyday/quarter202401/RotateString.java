package com.hnq.study.everyday.quarter202401;

/**
 * 旋转字符串
 * <p>
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * <p>
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * <p>
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * <p>
 *
 * 示例 1:
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * <p>
 *
 * 示例 2:
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 * <p>
 *
 * 提示:
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 *
 * @author henengqiang
 * @date 2024/1/8
 * @see <a href="https://leetcode.cn/problems/rotate-string/">链接</a>
 */
public class RotateString {

    public static void main(String[] args) {
        RotateString r = new RotateString();
        System.out.println(r.rotateString("abcde", "cdeab"));
        System.out.println(r.rotateString("abcde", "abced"));
    }

    public boolean rotateString(String s, String goal) {
        // 0ms
        int len = s.length();
        if (len != goal.length()) {
            return false;
        }
        int p = 0;
        while (p < len) {
            for (int i = 0; i < len; i++) {
                int k = i + p >= len ? i + p - len : i + p;
                if (s.charAt(k) != goal.charAt(i)) {
                    break;
                }
                if (i >= len - 1) {
                    return true;
                }
            }
            p++;
        }
        return false;
    }

    /**
     * 字符串 s+s 包含了所有 s 可以通过旋转操作得到的字符串，
     * 只需要检查 goal 是否为 s+s 的子字符串即可。
     */
    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

}
