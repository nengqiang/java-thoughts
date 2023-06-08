package com.hnq.study.everyday.quarter202302;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串s，找到它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1。
 * <p>
 *
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 * <p>
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 * <p>
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 * <p>
 *
 * 提示:
 * 1 <= s.length <= 10^5
 * s只包含小写字母
 *
 * @author henengqiang
 * @date 2023/6/8
 * @see <a href="https://leetcode.cn/problems/first-unique-character-in-a-string">链接</a>
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        FirstUniqChar f = new FirstUniqChar();
        System.out.println(f.firstUniqChar3("leetcode"));
        System.out.println(f.firstUniqChar3("loveleetcode"));
        System.out.println(f.firstUniqChar3("aabb"));
    }

    public int firstUniqChar(String s) {
        // 25ms
        Map<Character, Integer> m = new HashMap<>(s.length() * 3 / 2);
        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (m.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        // 3ms
        char[] a = new char[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            a[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (a[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        // 23ms
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return i;
            }
        }
        return -1;
    }

}
