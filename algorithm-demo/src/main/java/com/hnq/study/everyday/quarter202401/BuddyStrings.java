package com.hnq.study.everyday.quarter202401;

import java.util.HashSet;
import java.util.Set;

/**
 * 亲密字符串
 * <p>
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，
 * 就返回 true ；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 *
 * 示例 1：
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * <p>
 *
 * 示例 2：
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * <p>
 *
 * 示例 3：
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * <p>
 *
 * 提示：
 * 1 <= s.length, goal.length <= 2 * 10^4
 * s 和 goal 由小写英文字母组成
 *
 * @author henengqiang
 * @date 2024/2/5
 * @see <a href="https://leetcode.cn/problems/buddy-strings/>链接"
 */
public class BuddyStrings {

    public static void main(String[] args) {
        BuddyStrings b = new BuddyStrings();
        System.out.println(b.buddyStrings2("abcaa", "abcbb"));
        System.out.println(b.buddyStrings2("ab", "ba"));
        System.out.println(b.buddyStrings2("ab", "ab"));
        System.out.println(b.buddyStrings2("aa", "aa"));
        System.out.println(b.buddyStrings2("abcd", "cbad"));
    }

    public boolean buddyStrings(String s, String goal) {
        // 5ms
        if (s.length() != goal.length()) {
            return false;
        }
        int dc = 0;
        int[] idx = new int[3];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (s.charAt(i) != goal.charAt(i)) {
                idx[dc++] = i;
                if (dc > 2) {
                    return false;
                }
            }
        }
        return dc == 2
                && s.charAt(idx[0]) == goal.charAt(idx[1])
                && s.charAt(idx[1]) == goal.charAt(idx[0])
                || (dc == 0 && set.size() <= s.length() - 1);
    }

    /**
     * 模拟
     */
    public boolean buddyStrings2(String s, String goal) {
        // 1ms
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < goal.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return second != -1
                    && s.charAt(first) == goal.charAt(second)
                    && s.charAt(second) == goal.charAt(first);
        }
    }


}
