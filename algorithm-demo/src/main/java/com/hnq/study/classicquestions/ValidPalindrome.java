package com.hnq.study.classicquestions;

import java.util.Stack;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * @author henengqiang
 * @date 2019/04/01
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String str = "Red rum, sir, is murder";
        System.out.println("\"" + str + "\" is valid palindrome by method1?: " + isValidPalindrome1(str));
        System.out.println("\"" + str + "\" is valid palindrome by method2?: " + isValidPalindrome2(str));
    }

    /*
     * Thoughts
     *
     * From start and end loop though the string, i.e., char array. If it is not alpha or number, increase
     * pointers. Compare the alpha and numeric characters.
     *
     * tips: there only the simple solutions.
     */

    /**
     * Solution 1 - Using Stack
     * @param s Given string
     * @return  The given string is a valid palindrome or not
     */
    private static boolean isValidPalindrome1(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int len = s.length();
        if (len < 2) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        int index = 0;
        while (index < len / 2) {
            stack.push(s.charAt(index));
            index++;
        }

        if (len % 2 == 1) {
            index++;
        }

        while (index < len) {
            if (stack.empty()) {
                return false;
            }
            char temp = stack.pop();
            if (s.charAt(index) != temp) {
                return false;
            } else {
                index++;
            }
        }
        return true;
    }

    /**
     * Solution 2 - Using Two Pointers
     * @param s Given string
     * @return  The given string is a valid palindrome or not
     */
    private static boolean isValidPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


}
