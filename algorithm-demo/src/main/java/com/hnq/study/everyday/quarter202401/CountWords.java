package com.hnq.study.everyday.quarter202401;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计出现过一次的公共字符串
 * <p>
 * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 * <p>
 *
 * 示例 1：
 * 输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
 * 输出：2
 * 解释：
 * - "leetcode" 在两个数组中都恰好出现一次，计入答案。
 * - "amazing" 在两个数组中都恰好出现一次，计入答案。
 * - "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
 * - "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
 * 所以，有 2 个字符串在两个数组中都恰好出现了一次。
 * <p>
 *
 * 示例 2：
 * 输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
 * 输出：0
 * 解释：没有字符串在两个数组中都恰好出现一次。
 * <p>
 *
 * 示例 3：
 * 输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
 * 输出：1
 * 解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
 * <p>
 *
 * 提示：
 * 1 <= words1.length, words2.length <= 1000
 * 1 <= words1[i].length, words2[j].length <= 30
 * words1[i] 和 words2[j] 都只包含小写英文字母。
 *
 * @author henengqiang
 * @date 2024/1/12
 * @see <a href="https://leetcode.cn/problems/count-common-words-with-one-occurrence/?envType=daily-question&envId=2024-01-12">链接</a>
 */
public class CountWords {

    public static void main(String[] args) {
        CountWords c = new CountWords();
        System.out.println(c.countWords(new String[]{"leetcode","is","amazing","as","is"}, new String[]{"amazing","leetcode","is"}));
        System.out.println(c.countWords(new String[]{"b","bb","bbb"}, new String[]{"a","aa","aaa"}));
        System.out.println(c.countWords(new String[]{"a","ab"}, new String[]{"a","a","a","ab"}));
    }

    public int countWords(String[] words1, String[] words2) {
        // 6ms
        Map<String, Integer> map = new HashMap<>();
        for (String s : words1) {
            map.merge(s, 1, Integer::sum);
        }
        for (String s : words2) {
            if (map.containsKey(s) && map.get(s) <= 1) {
                map.merge(s, -1, Integer::sum);
            }
        }
        int count = 0;
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            if (en.getValue() == 0) {
                count++;
            }
        }
        return count;
    }

}
