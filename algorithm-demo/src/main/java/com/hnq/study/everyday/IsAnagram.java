package com.hnq.study.everyday;

import java.util.*;

/**
 * 给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 提示:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t仅包含小写字母
 * 
 *
 * 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author henengqiang
 * @date 2021/11/06
 * @see <a href="https://leetcode-cn.com/problems/valid-anagram">链接</a>
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram2("aacc", "aaca"));
        System.out.println(isAnagram2("a", "ab"));
        System.out.println(isAnagram2("rat", "car"));
        System.out.println(isAnagram2("anagram", "nagaram"));
    }

    private static boolean isAnagram(String s, String t) {
        // 423ms
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        List<Character> list = new ArrayList<>(s.length());
        int l1 = s.length();
        for (int i = 0; i < l1; i++) {
            list.add(s.charAt(i));
        }
        int l2 = t.length();
        for (int i = 0; i < l2; i++) {
            int idx = list.indexOf(t.charAt(i));
            if (idx > -1) {
                list.remove(idx);
            }
        }
        return list.size() <= 0;
    }

    private static boolean isAnagram2(String s, String t) {
        // 3ms
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

}
