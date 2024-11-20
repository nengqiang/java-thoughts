package com.hnq.study.everyday.quarter202403;

import java.util.Stack;

/**
 * @author henengqiang
 * @date 2024/11/20
 * @see <a href="https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/">链接</a>
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        System.out.println(r.removeDuplicates2("abbaca"));
    }

    public String removeDuplicates(String s) {
        // 103ms
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == c) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    /**
     * String自己做栈
     */
    public String removeDuplicates2(String s) {
        // 10ms
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(ch);
                top++;
            }
        }
        return stack.toString();
    }

}
