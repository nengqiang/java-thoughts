package com.hnq.study.everyday;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 * @author henengqiang
 * @date 2021/07/27
 * @see <a href="https://leetcode-cn.com/problems/valid-palindrome">链接</a>
 */
public class IsPalindromeStr {

    public static void main(String[] args) {
        String d = "Marge, let's \"[went].\" I await {news} telegram.";
        System.out.println(isPalindrome(d));
        String c = "0P";
        System.out.println(isPalindrome(c));
        String a = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(a));
        String b = "race a car";
        System.out.println(isPalindrome(b));
    }

    private static boolean isPalindrome(String s) {
        // 17ms
        s = s.replaceAll("[\\s;':\",./<>\\?|`~!@#$%^&*()_\\+\\-=\\\\\\{}\\[\\]]", "").toLowerCase();
        if (s.length() <= 1) {
            return true;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(s.length() - 1);
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
