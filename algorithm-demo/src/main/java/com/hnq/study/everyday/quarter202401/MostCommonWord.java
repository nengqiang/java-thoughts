package com.hnq.study.everyday.quarter202401;

import java.util.*;

/**
 * 最常见的单词
 * <p>
 * 给你一个字符串 paragraph 和一个表示禁用词的字符串数组 banned ，
 * 返回出现频率最高的非禁用词。题目数据 保证 至少存在一个非禁用词，且答案 唯一 。
 * <p>
 * paragraph 中的单词 不区分大小写 ，答案应以 小写 形式返回。
 * <p>
 *
 * 示例 1：
 * 输入：paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * 输出："ball"
 * 解释：
 * "hit" 出现了 3 次，但它是禁用词。
 * "ball" 出现了两次（没有其他单词出现这么多次），因此它是段落中出现频率最高的非禁用词。
 * 请注意，段落中的单词不区分大小写，
 * 标点符号会被忽略（即使它们紧挨着单词，如 "ball,"），
 * 并且尽管 "hit" 出现的次数更多，但它不能作为答案，因为它是禁用词。
 * <p>
 *
 * 示例 2：
 * 输入：paragraph = "a.", banned = []
 * 输出："a"
 * <p>
 *
 * 提示：
 * 1 <= paragraph.length <= 1000
 * paragraph 由英文字母、空格 ' '、和以下符号组成："!?',;."
 * 0 <= banned.length <= 100
 * 1 <= banned[i].length <= 10
 * banned[i] 仅由小写英文字母组成
 *
 * @author henengqiang
 * @date 2024/1/22
 * @see <a href="https://leetcode.cn/problems/most-common-word/">链接</a>
 */
public class MostCommonWord {

    public static void main(String[] args) {
        MostCommonWord m = new MostCommonWord();
        System.out.println(m.mostCommonWord2("Bob. hIt, baLl", new String[]{"bob", "hit"}));
        System.out.println(m.mostCommonWord2("a.", new String[]{}));
        System.out.println(m.mostCommonWord2("Bob", new String[]{}));

        String s1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] b1 = new String[]{"hit"};
        System.out.println(m.mostCommonWord2(s1, b1));

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        // 11ms
        int len = paragraph.length(), pre = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = paragraph.charAt(i);
            if (c == ' ' || c == '!' || c == '?' || c == '\'' || c == ',' || c == ';' || c == '.' || i >= len - 1) {
                StringBuilder sb = new StringBuilder();
                while (pre < i) {
                    int c1 = paragraph.charAt(pre);
                    if (c1 == ' ' || c1 == '!' || c1 == '?' || c1 == '\'' || c1 == ',' || c1 == ';' || c1 == '.') {
                        pre++;
                    } else {
                        break;
                    }
                }
                for (int j = pre; j < i; j++) {
                    sb.append(paragraph.charAt(j));
                }
                char c2 = paragraph.charAt(i);
                if (i >= len - 1 && c2 != ' ' && c2 != '!' && c2 != '?' && c2 != '\'' && c2 != ',' && c2 != ';' && c2 != '.') {
                    sb.append(paragraph.charAt(i));
                }
                map.merge(sb.toString().toLowerCase(), 1, Integer::sum);
                pre = i + 1;
            }
        }
        for (String s : banned) {
            map.remove(s);
        }
        map.remove("");
        int max = 0;
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            max = Math.max(max, en.getValue());
        }
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            if (en.getValue() == max) {
                return en.getKey();
            }
        }
        return "";
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        // 7ms
        Set<String> bannedSet = new HashSet<>();
        Collections.addAll(bannedSet, banned);
        int maxFrequency = 0;
        Map<String, Integer> frequencies = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        int length = paragraph.length();
        for (int i = 0; i <= length; i++) {
            if (i < length && Character.isLetter(paragraph.charAt(i))) {
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if (sb.length() > 0) {
                String word = sb.toString();
                if (!bannedSet.contains(word)) {
                    int frequency = frequencies.getOrDefault(word, 0) + 1;
                    frequencies.put(word, frequency);
                    maxFrequency = Math.max(maxFrequency, frequency);
                }
                sb.setLength(0);
            }
        }
        String mostCommon = "";
        Set<Map.Entry<String, Integer>> entries = frequencies.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            if (frequency == maxFrequency) {
                mostCommon = word;
                break;
            }
        }
        return mostCommon;
    }

}
