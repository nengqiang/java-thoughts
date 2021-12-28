package com.hnq.study.everyday.earlier;

import java.util.stream.IntStream;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author henengqiang
 * @date 2021/6/19
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome2(-121));
        System.out.println(isPalindrome2(10));
        System.out.println(isPalindrome2(-101));
    }

    private static boolean isPalindrome(int x) {
        // 21ms
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        char[] sc = s.toCharArray();
        return IntStream.range(0, sc.length / 2).allMatch(i -> sc[i] == sc[sc.length - 1 - i]);
    }

    private static boolean isPalindrome2(int x) {
        // 10 ms
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
