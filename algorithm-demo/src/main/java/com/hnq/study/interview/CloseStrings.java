package com.hnq.study.interview;

import java.util.Arrays;

/**
 * @author henengqiang
 * @since 2026/3/26
 * @see <a href="https://leetcode.cn/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75">确定两个字符串是否接近</a>
 */
public class CloseStrings {

    public static void main(String[] args) {
        CloseStrings c = new CloseStrings();
        System.out.println(c.closeStrings("abc", "bca"));
        System.out.println(c.closeStrings("a", "aa"));
        System.out.println(c.closeStrings("cabbba", "abbccc"));
        System.out.println(c.closeStrings("cabbba", "aabbss"));
        System.out.println(c.closeStrings("abbzzca", "babzzcz"));
        System.out.println(c.closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));
    }

    /**
     * 1. 两字符串的长度相同
     * 2. 两字符串的字符种类相同，
     * 例如，对于某个字符，要么都有，要么都没有。
     * 符合：word1=abbccc，word2=caabbb，都有 a、b、c
     *
     * 不符合：word1=abbccc，word2=abbccd，word1 只有3类字符a、b、c，无论如何转换
     * 不出有4类字符的 word2
     *
     * 3. 字符频次相同。跟具体是什么字符无关，只要频次相同即可。
     */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count1 = new int[26], count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0 && count2[i] == 0 || count1[i] == 0 && count2[i] > 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }

}
