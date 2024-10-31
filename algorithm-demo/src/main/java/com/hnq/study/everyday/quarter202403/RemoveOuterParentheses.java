package com.hnq.study.everyday.quarter202403;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author henengqiang
 * @date 2024/10/31
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        RemoveOuterParentheses r = new RemoveOuterParentheses();
        System.out.println(r.removeOuterParentheses("(()())(())"));
        System.out.println(r.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(r.removeOuterParentheses("()()"));
    }

    /**
     * 栈
     */
    public String removeOuterParentheses(String s) {
        // 9ms
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return res.toString();
    }

    /**
     * 记数
     */
    public String removeOuterParentheses2(String s) {
        // 4ms
        int lev = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                lev--;
            }
            if (lev > 0) {
                res.append(c);
            }
            if (c == '(') {
                lev++;
            }
        }
        return res.toString();
    }

}
