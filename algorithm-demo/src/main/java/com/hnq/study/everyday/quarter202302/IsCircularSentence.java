package com.hnq.study.everyday.quarter202302;

/**
 * 句子 是由单个空格分隔的一组单词，且不含前导或尾随空格。
 * <p>
 * 例如，"Hello World"、"HELLO"、"hello world hello world" 都是符合要求的句子。
 * 单词 仅 由大写和小写英文字母组成。且大写和小写字母会视作不同字符。
 * <p>
 * 如果句子满足下述全部条件，则认为它是一个 回环句 ：
 * <p>
 * 单词的最后一个字符和下一个单词的第一个字符相等。
 * 最后一个单词的最后一个字符和第一个单词的第一个字符相等。
 * 例如，"leetcode exercises sound delightful"、"eetcode"、"leetcode eats soul" 都是回环句。
 * 然而，"Leetcode is cool"、"happy Leetcode"、"Leetcode" 和 "I like Leetcode" 都 不 是回环句。
 * <p>
 * 给你一个字符串 sentence ，请你判断它是不是一个回环句。如果是，返回 true ；否则，返回 false 。
 * <p>
 *
 * 示例 1：
 * 输入：sentence = "leetcode exercises sound delightful"
 * 输出：true
 * 解释：句子中的单词是 ["leetcode", "exercises", "sound", "delightful"] 。
 * - leetcode 的最后一个字符和 exercises 的第一个字符相等。
 * - exercises 的最后一个字符和 sound 的第一个字符相等。
 * - sound 的最后一个字符和 delightful 的第一个字符相等。
 * - delightful 的最后一个字符和 leetcode 的第一个字符相等。
 * 这个句子是回环句。
 * <p>
 *
 * 示例 2：
 * 输入：sentence = "eetcode"
 * 输出：true
 * 解释：句子中的单词是 ["eetcode"] 。
 * - eetcode 的最后一个字符和 eetcode 的第一个字符相等。
 * 这个句子是回环句。
 * <p>
 *
 * 示例 3：
 * 输入：sentence = "Leetcode is cool"
 * 输出：false
 * 解释：句子中的单词是 ["Leetcode", "is", "cool"] 。
 * - Leetcode的最后一个字符和 is 的第一个字符 不 相等。
 * 这个句子 不 是回环句。
 * <p>
 *
 * 提示：
 * 1 <= sentence.length <= 500
 * sentence 仅由大小写英文字母和空格组成
 * sentence 中的单词由单个空格进行分隔
 * 不含任何前导或尾随空格
 *
 * @author henengqiang
 * @date 2023/6/30
 * @see <a href="https://leetcode.cn/problems/circular-sentence">链接</a>
 */
public class IsCircularSentence {

    public static void main(String[] args) {
        IsCircularSentence i = new IsCircularSentence();
        System.out.println(i.isCircularSentence2("eetcode"));
        System.out.println(i.isCircularSentence2("leetcode exercises sound delightful"));
        System.out.println(i.isCircularSentence2("leetcode eats soul"));
        System.out.println(i.isCircularSentence2("Leetcode is cool"));
    }

    public boolean isCircularSentence(String sentence) {
        // 6ms
        String[] words = sentence.split("\\s");
        int len = words.length;
        if (len == 1) {
            return words[0].charAt(0) == words[0].charAt(words[0].length() - 1);
        }
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                if (words[i].charAt(words[i].length() - 1) != words[0].charAt(0)) {
                    return false;
                }
            } else {
                if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCircularSentence2(String sentence) {
        // 1ms
        int len = sentence.length();
        if (len == 0) {
            return true;
        }
        if (sentence.charAt(0) != sentence.charAt(len - 1)) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (sentence.charAt(i) == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

}
