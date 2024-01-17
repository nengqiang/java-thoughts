package com.hnq.study.everyday.quarter202401;

import java.util.HashSet;
import java.util.Set;

/**
 * 最大字符串配对数目
 * <p>
 * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
 * <p>
 * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
 * <p>
 * 字符串 words[i] 等于 words[j] 的反转字符串。
 * 0 <= i < j < words.length
 * 请你返回数组 words 中的 最大 匹配数目。
 * <p>
 * 注意，每个字符串最多匹配一次。
 * <p>
 *
 * 示例 1：
 * 输入：words = ["cd","ac","dc","ca","zz"]
 * 输出：2
 * 解释：在此示例中，我们可以通过以下方式匹配 2 对字符串：
 * - 我们将第 0 个字符串与第 2 个字符串匹配，因为 word[0] 的反转字符串是 "dc" 并且等于 words[2]。
 * - 我们将第 1 个字符串与第 3 个字符串匹配，因为 word[1] 的反转字符串是 "ca" 并且等于 words[3]。
 * 可以证明最多匹配数目是 2 。
 * <p>
 *
 * 示例 2：
 * 输入：words = ["ab","ba","cc"]
 * 输出：1
 * 解释：在此示例中，我们可以通过以下方式匹配 1 对字符串：
 * - 我们将第 0 个字符串与第 1 个字符串匹配，因为 words[1] 的反转字符串 "ab" 与 words[0] 相等。
 * 可以证明最多匹配数目是 1 。
 * <p>
 *
 * 示例 3：
 * 输入：words = ["aa","ab"]
 * 输出：0
 * 解释：这个例子中，无法匹配任何字符串。
 * <p>
 *
 * 提示：
 * 1 <= words.length <= 50
 * words[i].length == 2
 * words 包含的字符串互不相同。
 * words[i] 只包含小写英文字母。
 *
 * @author henengqiang
 * @date 2024/1/17
 * @see <a href="https://leetcode.cn/problems/find-maximum-number-of-string-pairs/?envType=daily-question&envId=2024-01-17">链接</a>
 */
public class MaximumNumberOfStringPairs {

    public static void main(String[] args) {
        MaximumNumberOfStringPairs m = new MaximumNumberOfStringPairs();
        System.out.println(m.maximumNumberOfStringPairs2(new String[]{"cd","ac","dc","ca","zz"}));
        System.out.println(m.maximumNumberOfStringPairs2(new String[]{"ab", "ba", "cc"}));
        System.out.println(m.maximumNumberOfStringPairs2(new String[]{"aa","ab"}));
    }

    public int maximumNumberOfStringPairs(String[] words) {
        // 2ms
        int count = 0, len = words.length;
        for (int i = 0; i < len; i++) {
            if ("".equals(words[i])) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (!"".equals(words[j])
                        && words[i].charAt(0) == words[j].charAt(1)
                        && words[i].charAt(1) == words[j].charAt(0)) {
                    words[i] = "";
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 哈希表
     */
    public int maximumNumberOfStringPairs2(String[] words) {
        // 2ms
        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        for (String word : words) {
            if (seen.contains(word.charAt(1) * 100 + word.charAt(0))) {
                ans++;
            }
            seen.add(word.charAt(0) * 100 + word.charAt(1));
        }
        return ans;
    }



}
