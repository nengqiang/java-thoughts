package com.hnq.study.everyday;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author henengqiang
 * @date 2021/06/29
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses">链接</a>
 */
public class ValidBrackets {

    public static void main(String[] args) {
        String a = "()";
        System.out.println("a=" + isValid(a));
        String b = "()[]{}";
        System.out.println("b=" + isValid(b));
        String c = "(]";
        System.out.println("c=" + isValid(c));
        String d = "([)]";
        System.out.println("d=" + isValid(d));
        String e = "{[]}";
        System.out.println("e=" + isValid(e));
        String f = "{";
        System.out.println("f=" + isValid(f));
        String g = "}";
        System.out.println("g=" + isValid(g));
    }

    private static boolean isValid(String s) {
        // 2ms
        if (s == null || s.length() <= 0) {
            return false;
        }
        Stack<Character> ss = new Stack<>();
        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (c == '(') {
                ss.push(')');
            } else if (c == '{') {
                ss.push('}');
            } else if (c == '[') {
                ss.push(']');
            } else if (ss.empty() || c != ss.pop()) {
                return false;
            }
            i++;
        }
        return ss.empty();
    }

}



























