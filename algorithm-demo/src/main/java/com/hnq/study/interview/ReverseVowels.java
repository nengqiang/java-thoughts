package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/2/27
 * @see <a href="https://leetcode.cn/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75">反转字符串中的元音字母</a>
 */
public class ReverseVowels {

    public static void main(String[] args) {
        ReverseVowels r = new ReverseVowels();
        System.out.println(r.reverseVowels("IceCreAm"));
        System.out.println(r.reverseVowels("hello"));
        System.out.println(r.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        // 5ms
        String vowels = "aeiouAEIOU";
        int len = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < right && !vowels.contains(chars[left] + "")) {
                left++;
            }
            while (left < right && !vowels.contains(chars[right] + "")) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

}
