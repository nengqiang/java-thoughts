package com.hnq.study.everyday.quarter202401;

import java.util.*;

/**
 * 两句话中的不常见单词
 * <p>
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * <p>
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * <p>
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 * <p>
 *
 * 示例 1：
 * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
 * 输出：["sweet","sour"]
 * <p>
 *
 * 示例 2：
 * 输入：s1 = "apple apple", s2 = "banana"
 * 输出：["banana"]
 * <p>
 *
 * 提示：
 * 1 <= s1.length, s2.length <= 200
 * s1 和 s2 由小写英文字母和空格组成
 * s1 和 s2 都不含前导或尾随空格
 * s1 和 s2 中的所有单词间均由单个空格分隔
 * <p>
 *
 * @author henengqiang
 * @date 2024/2/23
 * @see <a href="https://leetcode.cn/problems/uncommon-words-from-two-sentences/">链接</a>
 */
public class UncommonFromSentences {

    public static void main(String[] args) {
        UncommonFromSentences u = new UncommonFromSentences();
        System.out.println(Arrays.toString(u.uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(u.uncommonFromSentences("apple apple", "banana")));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        // 5ms
        Map<String, Integer> map = new HashMap<>();
        String[] str1 = s1.split("\\s");
        String[] str2 = s2.split("\\s");
        for (String s : str1) {
            map.merge(s, 1, Integer::sum);
        }
        for (String s : str2) {
            map.merge(s, 1, Integer::sum);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            if (en.getValue() == 1) {
                list.add(en.getKey());
            }
        }
        return list.toArray(new String[]{});
    }

}
