package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/2/28
 * @see <a href="https://leetcode.cn/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75">反转字符串中的单词</a>
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        System.out.println(r.reverseWords("  hello word "));
        System.out.println(r.reverseWords("the sky is blue"));
        System.out.println(r.reverseWords("a good  example "));
    }

    public String reverseWords(String s) {
        // 8ms
        String[] strArr = s.trim().split("\\s+");
        int left = 0, right = strArr.length - 1;
        while (left < right) {
            String tmp = strArr[left];
            strArr[left] = strArr[right];
            strArr[right] = tmp;
            left++;
            right--;
        }
        return String.join(" ", strArr);
    }

    // 思路二：1.去掉多余空格 2.反转整个字符串 3.反转每个单词

    // 思路三：双端队列

}
