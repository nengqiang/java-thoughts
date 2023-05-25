package com.hnq.study.everyday.quarter202302;

import java.util.Arrays;

/**
 * 给你一个字符串数组 words，每一个字符串长度都相同，令所有字符串的长度都为 n。
 * <p>
 * 每个字符串words[i]可以被转化为一个长度为n - 1的差值整数数组difference[i]，
 * 其中对于0 <= j <= n - 2有difference[i][j] = words[i][j+1] - words[i][j]。
 * 注意两个字母的差值定义为它们在字母表中位置之差，也就是说'a'的位置是0，'b'的位置是1，'z'的位置是25。
 * <p>
 * 比方说，字符串"acb"的差值整数数组是[2 - 0, 1 - 2] = [2, -1]。
 * words中所有字符串 除了一个字符串以外，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * <p>
 * 请你返回words中差值整数数组不同的字符串。
 * <p>
 * 
 * 示例 1：
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * <p>
 * 示例 2：
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 * <p>
 *
 * 提示：
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 * words[i]只含有小写英文字母。
 * 
 * @author henengqiang
 * @date 2023/5/25
 * @see <a href="https://leetcode.cn/problems/odd-string-difference">链接</a>
 */
public class OddString {

    public static void main(String[] args) {
        String[] w3 = new String[] {"mll","edd","jii","tss","fee","dcc","nmm","abb","utt","zyy","xww","tss","wvv","xww","utt"};
        System.out.println(oddString2(w3));

        String[] w1 = new String[]{"adc", "wzy", "abc"};
        System.out.println(oddString2(w1));

        String[] w2 = new String[]{"aaa", "bob", "ccc", "ddd"};
        System.out.println(oddString2(w2));
    }

    private static String oddString(String[] words) {
        // 0ms
        int len = words[0].length();
        int[] diff1 = new int[len - 1];
        for (int i = 1; i < len; i++) {
            diff1[i - 1] = words[0].charAt(i) - words[0].charAt(i - 1);
        }

        int[] diff2 = new int[len - 1];
        for (int i = 1; i < len; i++) {
            diff2[i - 1] = words[1].charAt(i) - words[1].charAt(i - 1);
        }

        for (int i = 2; i < words.length; i++) {
            int[] tmp = new int[len - 1];
            for (int j = 1; j < len; j++) {
                tmp[j - 1] = words[i].charAt(j) - words[i].charAt(j - 1);
                if (diff1[j - 1] != diff2[j - 1] && diff1[j - 1] == tmp[j - 1]) {
                    return words[1];
                }
                if (diff1[j - 1] != diff2[j - 1] && diff2[j - 1] == tmp[j - 1]) {
                    return words[0];
                }
                if (diff1[j - 1] == diff2[j - 1] && diff1[j - 1] != tmp[j - 1]) {
                    return words[i];
                }
            }
        }
        return "";
    }

    /**
     * @see Arrays#equals(long[], long[])
     */
    private static String oddString2(String[] words) {
        // 0ms
        int[] diff0 = get(words[0]);
        int[] diff1 = get(words[1]);
        if (Arrays.equals(diff0, diff1)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(diff0, get(words[i]))) {
                    return words[i];
                }
            }
        }
        return Arrays.equals(diff0, get(words[2])) ? words[1] : words[0];
    }

    private static int[] get(String word) {
        int[] diff = new int[word.length() - 1];
        for (int i = 0; i < word.length() - 1; i++) {
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return diff;
    }

}
