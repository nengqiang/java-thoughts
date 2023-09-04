package com.hnq.study.everyday.quarter202303;

/**
 * 转字符串中的单词 III
 * <p>
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1：
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 *
 * 示例 2:
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * <p>
 *
 * 提示：
 * 1 <= s.length <= 5 * 10^4
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 *
 * @author henengqiang
 * @date 2023/9/4
 * @see <a href="https://leetcode.cn/problems/reverse-words-in-a-string-iii/">链接</a>
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        System.out.println(r.reverseWords4("Let's take LeetCode contest"));
        System.out.println(r.reverseWords4("God Ding"));
    }

    public String reverseWords(String s) {
        // 16ms
        StringBuilder word = new StringBuilder(), sentence = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word.insert(0, c);
            }
            if (c == ' ' || i >= len - 1) {
                sentence.append(word);
                word.setLength(0);
            }
            if (c == ' ') {
                sentence.append(" ");
            }
        }
        return sentence.toString();
    }

    public String reverseWords2(String s) {
        // 7ms
        String[] str = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : str) {
            int len = word.length();
            for (int i = len - 1; i >= 0; i--) {
                res.append(word.charAt(i));
            }
            res.append(" ");
        }
        return res.substring(0, res.length() - 1);
    }

    /**
     * 开辟一个新字符串。然后从头到尾遍历原字符串，直到找到空格为止，此时找到了一个单词，并能得到单词的起止位置。
     * 随后，根据单词的起止位置，可以将该单词逆序放到新字符串当中。如此循环多次，直到遍历完原字符串，就能得到翻转后的结果。
     */
    public String reverseWords3(String s) {
        // 6ms
        StringBuilder ret = new StringBuilder();
        int length = s.length(), i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(" ");
            }
        }
        return ret.toString();
    }

    /**
     * 局部原地反转
     */
    public String reverseWords4(String s) {
        // 3ms
        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0, right = 0;
        while (right <= n) {
            if (right == n || arr[right] == ' ') {
                reverseString(arr, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        return new String(arr);
    }

    public void reverseString(char[] s, int left, int right) {
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }


}
