package com.hnq.study.everyday.quarter202303;

/**
 * 检测大写字母
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 *
 *
 * 示例 1：
 * 输入：word = "USA"
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：word = "FlaG"
 * 输出：false
 * <p>
 *
 * 提示：
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 *
 * @author henengqiang
 * @date 2023/8/28
 * @see <a href="https://leetcode.cn/problems/detect-capital/">链接</a>
 */
public class DetectCapitalUse {

    public static void main(String[] args) {
        DetectCapitalUse d = new DetectCapitalUse();
        System.out.println(d.detectCapitalUse2("CHINA"));
        System.out.println(d.detectCapitalUse2("FlagG"));
        System.out.println(d.detectCapitalUse2("leetcode"));
        System.out.println(d.detectCapitalUse2("A"));
        System.out.println(d.detectCapitalUse2("a"));
        System.out.println(d.detectCapitalUse2("aA"));
        System.out.println(d.detectCapitalUse2("Aa"));
    }

    public boolean detectCapitalUse(String word) {
        // 0ms
        int len = word.length(), sum = 0;
        boolean firstUpper = false;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sum += 1;
                if (i == 0) {
                    firstUpper = true;
                }
            }
        }
        return sum == len || sum == 0 || (firstUpper && sum == 1);
    }

    public boolean detectCapitalUse2(String word) {
        // 1ms
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }

}
