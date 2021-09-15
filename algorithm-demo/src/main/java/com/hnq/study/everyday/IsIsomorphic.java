package com.hnq.study.everyday;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定两个字符串s和t，判断它们是否是同构的。
 *
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 *
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * 
 * 提示：
 *
 * 可以假设 s 和 t 长度相同。
 *
 * @author henengqiang
 * @date 2021/09/15
 * @see <a href="https://leetcode-cn.com/problems/isomorphic-strings">链接</a>
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(isIsomorphic2("badc", "baba"));
        System.out.println(isIsomorphic2("egg", "add"));
        System.out.println(isIsomorphic2("foo", "bar"));
        System.out.println(isIsomorphic2("paper", "title"));
    }

    private static boolean isIsomorphic(String s, String t) {
        // 34ms
        if (s.length() == 0) {
            return true;
        }
        int len = s.length();
        Map<Character, Character> mapping = new HashMap<>(len * 4 / 3);
        for (int i = 0; i < len; i++) {
            if (mapping.containsKey(s.charAt(i))) {
                if (t.charAt(i) != mapping.get(s.charAt(i))) {
                    return false;
                }
            } else if (mapping.containsValue(t.charAt(i))) {
                return false;
            } else {
                mapping.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    private static boolean isIsomorphic2(String s, String t) {
        // 20ms
        if (s.length() == 0) {
            return true;
        }
        int len = s.length();
        Map<Object, Integer> mapping = new HashMap<>(len * 4 / 3);
        for (int i = 0; i < len; i++) {
            if (!Objects.equals(mapping.put(s.charAt(i), i), mapping.put(t.charAt(i) + "", i))) {
                return false;
            }
        }
        return true;
    }

}
