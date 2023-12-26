package com.hnq.study.everyday.quarter202304;

/**
 * 最短补全词
 * <p>
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出 words 中的 最短补全词 。
 * <p>
 * 补全词 是一个包含 licensePlate 中所有字母的单词。忽略 licensePlate 中的 数字和空格 。
 * 不区分大小写。如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * <p>
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。
 * 可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 * <p>
 * 请返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。
 * 当有多个单词都符合最短补全词的匹配条件时取 words 中 第一个 出现的那个。
 * <p>
 *
 * 示例 1：
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 * 因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。
 * <p>
 *
 * 示例 2：
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 解释：licensePlate 只包含字母 "s" 。所有的单词都包含字母 "s" ，
 * 其中 "pest"、"stew"、和 "show" 三者最短。答案是 "pest" ，因为它是三个单词中在 words 里最靠前的那个。
 * <p>
 *
 * 提示：
 * 1 <= licensePlate.length <= 7
 * licensePlate 由数字、大小写字母或空格 ' ' 组成
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 15
 * words[i] 由小写英文字母组成
 *
 * @author henengqiang
 * @date 2023/12/26
 * @see <a href="https://leetcode.cn/problems/shortest-completing-word/">链接</a>
 */
public class ShortestCompletingWord {

    public static void main(String[] args) {
        ShortestCompletingWord s = new ShortestCompletingWord();
        System.out.println(s.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(s.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 3ms
        int[] cnt = new int[26];
        for (int i = 0, limit = licensePlate.length(); i < limit; i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                ++cnt[Character.toLowerCase(c) - 'a'];
            }
        }
        int idx = -1;
        for (int i = 0; i < words.length; i++) {
            int[] cnt2 = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                ++cnt2[c - 'a'];
            }
            boolean ok = true;
            for (int j = 0; j < 26; j++) {
                if (cnt2[j] < cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok && (idx < 0 || words[i].length() < words[idx].length())) {
                idx = i;
            }
        }
        return words[idx];
    }

}
