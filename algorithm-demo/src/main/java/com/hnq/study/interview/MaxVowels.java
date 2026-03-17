package com.hnq.study.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author henengqiang
 * @since 2026/3/17
 * @see <a href="https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75">定长子串中元音的最大数目</a>
 */
public class MaxVowels {

    public static void main(String[] args) {
        MaxVowels m = new MaxVowels();
        System.out.println(m.maxVowels("weallloveyou", 7));
        System.out.println(m.maxVowels("tryhard", 4));
        System.out.println(m.maxVowels("abciiidef", 3));
        System.out.println(m.maxVowels("aeiou", 2));
        System.out.println(m.maxVowels("leetcode", 3));
        System.out.println(m.maxVowels("rhythms", 4));
    }

    public int maxVowels(String s, int k) {
        // 23ms
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int tmp = 0, max = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (vowels.contains(s.charAt(i))) {
                tmp++;
            }
            if (i >= k - 1) {
                max = Math.max(max, tmp);
                if (max >= k) {
                    return k;
                }
                // 移除窗口左边界字符
                if (vowels.contains(s.charAt(i - k + 1))) {
                    tmp--;
                }
            }
        }
        return max;
    }

}
