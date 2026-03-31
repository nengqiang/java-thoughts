package com.hnq.study.interview;

import java.util.Stack;

/**
 * @author henengqiang
 * @since 2026/3/31
 * @see <a href="https://leetcode.cn/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75">删除字符串中的所有星号</a>
 */
public class RemoveStars {

    public static void main(String[] args) {
        RemoveStars r = new RemoveStars();
        System.out.println(r.removeStars2("leet**cod*e"));
        System.out.println(r.removeStars2("erase*****"));
        System.out.println(r.removeStars2("leet**code"));
        System.out.println(r.removeStars2("abb*c*"));
        System.out.println(r.removeStars2("*"));
        System.out.println(r.removeStars2(""));
        System.out.println(r.removeStars2("*a*b*c*d*e*f*g*h*i*j*k*l*m*n*o*p*q*r*s*t*u*v*w*x*y*z*"));
    }

    public String removeStars(String s) {
        // 162ms
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 用字符串来模拟栈快些
     */
    public String removeStars2(String s) {
        // 36ms
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (sb.length() == 0) {
                    continue;
                }
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
