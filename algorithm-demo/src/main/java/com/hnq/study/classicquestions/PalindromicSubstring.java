package com.hnq.study.classicquestions;


import org.apache.commons.lang.StringUtils;

/**
 * Finding the longest palindromic substring is a classic problem of coding interview.
 * This post summarizes 3 different solutions for this problem.
 *
 * @author henengqiang
 * @date 2018/12/14
 */
public class PalindromicSubstring {

    public static void main(String[] args) {
        String s = "abcdefedcbaabcdefgfedcbaabcdefghihgedcba";
        System.out.println("Original String: " + s);
        String palindrome1 = longestPalindrome1(s);
        System.out.println("Longest palindromic substring of s by method 1: " + palindrome1);
        String palindrome2 = longestPalindrome2(s);
        System.out.println("Longest palindromic substring of s by method 2: " + palindrome2);
    }

    /**
     * 1. Dynamic Programming
     * Let s be the input string, i and j are two indices of the string. Define a 2-dimension array "table"
     * and let table[i][j] denote whether a substring from i to j is palindrome.
     *
     * Changing condition:
     * table[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j) => table[i][j] == 1
     *
     * Time O(n^2) Space O(n^2)
     *
     * @param s input string
     * @return  the longest palindromic substring of input string
     */
    private static String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        String longest = null;
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longest;
    }

    /*
     * For example, if the input string is "dabcba", the final matrix would be the following:
     * 1 0 0 0 0 0
     * 0 1 0 0 0 1
     * 0 0 1 0 1 0
     * 0 0 0 1 0 0
     * 0 0 0 0 1 0
     * 0 0 0 0 0 1
     *
     * From the table, we can clearly see that the longest string in cell table [1][5]
     */

    /**
     * 2. A Simple Algorithm
     * We can scan to both sides for each character. Time O(n^2), Space O(1)
     *
     * @param s input string
     * @return  the longest palindromic substring of input string
     */
    private static String longestPalindrome2(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String temp = helper(s, i, i);
            if (temp.length() > longest.length()) {
                longest = temp;
            }

            // get longest palindrome with center of i, i + 1
            temp = helper(s, i, i + 1);
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }
        return longest;
    }

    /**
     * Given a center, either one letter or two letter.
     * Find longest palindrome
     *
     * @param s     given string
     * @param begin index of begin
     * @param end   index of end
     * @return      longest palindrome
     */
    private static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    /*
     * 3. Manacher's Algorithm
     *
     * Manacher's algorithm is much more complicated to figure out, even though it will bing benefit of time complexity
     * of O(n). Since it is not typical, there is no need to waste time on that.
     */

}
