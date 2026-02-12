package com.hnq.study.interview;

/**
 * 交替合并字符串
 *
 * @author henengqiang
 * @date 2026/2/12
 * @see <a href="https://leetcode.cn/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75">交替合并字符串</a>
 */
public class MergeAlternately {

    public static void main(String[] args) {
        MergeAlternately m = new MergeAlternately();
        System.out.println(m.mergeAlternately2("abc", "pqr"));
        System.out.println(m.mergeAlternately2("ab", "pqrs"));
        System.out.println(m.mergeAlternately2("abcd", "pq"));
    }

    public String mergeAlternately(String word1, String word2) {
        // 1ms
        int len1 = word1.length(), len2 = word2.length();
        int maxLength = Math.max(len1, len2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            if (i < len1) {
                sb.append(word1.charAt(i));
            }
            if (i < len2) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 双指针
     */
    public String mergeAlternately2(String word1, String word2) {
        // 0ms
        int len1 = word1.length(), len2 = word2.length();
        // 长度确定的可以用数组，否则一般用StringBuilder
        char[] res = new char[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (i < len1 || j < len2) {
            if (i < len1) {
                res[k++] = word1.charAt(i);
                i++;
            }
            if (j < len2) {
                res[k++] = word2.charAt(j);
                j++;
            }
        }
        return new String(res);
    }

}
