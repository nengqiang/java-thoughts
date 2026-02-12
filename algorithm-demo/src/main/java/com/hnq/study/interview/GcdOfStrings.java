package com.hnq.study.interview;

/**
 * 字符串的最大公因子
 *
 * @author henengqiang
 * @date 2026/2/12
 * @see <a href="https://leetcode.cn/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75">字符串的最大公因子</a>
 */
public class GcdOfStrings {

    public static void main(String[] args) {
        GcdOfStrings g = new GcdOfStrings();
        System.out.println(g.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(g.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(g.gcdOfStrings("LEET", "CODE"));
        System.out.println(g.gcdOfStrings("AAAAAB", "AAA"));
    }

    public String gcdOfStrings(String str1, String str2) {
        // 0ms
        int len1 = str1.length(), len2 = str2.length();
        String l = len1 >= len2 ? str1 : str2;
        String s = len1 >= len2 ? str2 : str1;
        if (s.length() == 0) {
            return l;
        }
        if (!l.startsWith(s)) {
            return "";
        }
        return gcdOfStrings(s, l.substring(s.length()));
    }

}
