package com.hnq.study.interview;

import java.util.Stack;

/**
 * @author henengqiang
 * @since 2026/4/2
 * @see <a href="https://leetcode.cn/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75">字符串解码</a>
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString("100[leetcode]"));
        System.out.println(d.decodeString("3[a]2[bc]"));
        System.out.println(d.decodeString("3[a2[c]]"));
        System.out.println(d.decodeString("2[abc]3[cd]ef"));
        System.out.println(d.decodeString("abc3[cd]xyz"));
    }

    public String decodeString(String s) {
        // 3ms
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                StringBuilder tmp = new StringBuilder();
                char c = stack.pop();
                while (c != '[') {
                    tmp.append(c);
                    c = stack.pop();
                }
                tmp.reverse();
                c = stack.pop();
                StringBuilder x = new StringBuilder();
                while (c >= '0' && c <= '9') {
                    x.append(c);
                    if (!stack.isEmpty()) {
                        c = stack.pop();
                    } else {
                        c = ' ';
                    }
                }
                if (c != ' ') {
                    stack.push(c);
                }
                int num = Integer.parseInt(x.reverse().toString());
                String st = tmp.toString();
                tmp = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    tmp.append(st);
                }
                for (int k = 0; k < tmp.length(); k++) {
                    stack.push(tmp.charAt(k));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

}
