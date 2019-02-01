package com.hnq.study.classicquestions;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Stack;

import static com.hnq.study.utils.Constants.*;

/**
 * Given a string contain just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * @author henengqiang
 * @date 2019/02/01
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
        str = "([{}])";
        System.out.println(isValid(str));
        str = "([)]{}";
        System.out.println(isValid(str));
    }

    /*
     * Analysis
     * A typical problem which can be solved by using a stack data structure.
     */

    /**
     * Solution
     *
     * @param str   Given string contain just the characters '(', ')', '{', '}', '[' and ']'
     * @return      the input string is valid or not
     */
    private static boolean isValid(String str) {
        Map<Character, Character> map = Maps.newHashMap();
        map.put(LEFT_PARENTHESIS, RIGHT_PARENTHESIS);
        map.put(LEFT_BRACKET, RIGHT_BRACKET);
        map.put(LEFT_BRACE, RIGHT_BRACE);

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
