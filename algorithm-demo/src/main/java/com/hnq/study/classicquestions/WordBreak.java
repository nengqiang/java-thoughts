package com.hnq.study.classicquestions;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
 * one or more dictionary words.
 *
 * For example, given s = "leetcode", dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * @author henengqiang
 * @date 2018/12/17
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> stringSet = new LinkedHashSet<>();
        stringSet.add("leet");
        stringSet.add("code");
        System.out.println("\"" + s + "\""
                + " can be segmented into a space-separated sequence of one or more dictionary words of "
                + "\"" + stringSet + "\"?");
        boolean flag = wordBreak1(s, stringSet);
        System.out.println("By method1: " + flag);
        flag = wordBreak2(s, stringSet);
        System.out.println("By method2: " + flag);
        flag = wordBreak3(s, stringSet);
        System.out.println("By method3: " + flag);
    }

    /**
     * 1.Naive Approach
     * This problem can be solve by using a naive approach, which is trivial. A discussion can always start from that
     * through.
     *
     * Time is O(n^2) and exceeds the time limit.
     *
     * @param s     given string
     * @param dict  given string dictionary
     * @return      true if given string can be segmented into a space-separated sequence
     */
    private static boolean wordBreak1(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    private static boolean wordBreakHelper(String s, Set<String> dict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (String str : dict) {
            int len = str.length();
            int end = start + len;

            // end index should be <= string length
            if (end > s.length()) {
                continue;
            }
            if (s.substring(start, start + len).equals(str)) {
                if (wordBreakHelper(s, dict, start + len)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 2.Dynamic Programming
     * The key to solve this problem by using dynamic programming approach:
     *  Define an array t[] such that t[i] == true => 0-(i-1) can be segmented using dictionary
     *  Initial state t[0] == true
     *
     * Time is O(string length * dict size).
     *
     * @param s     given string
     * @param dict  given string dictionary
     * @return      true if given string can be segmented into a space-separated sequence
     */
    private static boolean wordBreak2(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        // set first to be true. Because we need initial state
        t[0] = true;

        for (int i = 0; i < s.length(); i++) {
            // should continue from match position
            if (!t[i]) {
                continue;
            }

            for (String str : dict) {
                int len = str.length();
                int end = i + len;
                if (end > s.length()) {
                    continue;
                }
                if (t[end]) {
                    continue;
                }
                if (s.substring(i, end).equals(str)) {
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }

    /**
     * 3.Java Solution3 - Simple and Efficient
     * In Solution 2, if the size of the dictionary is very large, the time is bad. Instead we can solve the
     * problem in O(n^2) time (n is the length of the string).
     *
     * @param s     given string
     * @param dict  given string dictionary
     * @return      true if given string can be segmented into a space-separated sequence
     */
    private static boolean wordBreak3(String s, Set<String> dict) {
        int[] pos = new int[s.length() + 1];

        Arrays.fill(pos, -1);

        pos[0] = 0;

        for (int i = 0; i < s.length(); i++) {
            if (pos[i] != -1) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (dict.contains(sub)) {
                        pos[j] = i;
                    }
                }
            }
        }

        return pos[s.length()] != -1;
    }

    /*
     * 4.The More Interesting Problem
     * The dynamic solution can tell us whether the string can be broken to words, but can not tell us what words
     * the string is broken. So how to get those words?
     *
     * Check out Word Break Ⅱ.
     */

}
