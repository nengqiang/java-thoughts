package com.hnq.study.everyday.quarter202401;

import java.util.HashSet;
import java.util.Set;

/**
 * 唯一摩尔斯密码词
 * <p>
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
 * <p>
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 * 为了方便，所有 26 个英文字母的摩尔斯密码表如下：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * <p>
 * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
 * <p>
 *
 *
 * 示例 1：
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * <p>
 *
 * 示例 2：
 * 输入：words = ["a"]
 * 输出：1
 * <p>
 *
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 12
 * words[i] 由小写英文字母组成
 *
 * @author henengqiang
 * @date 2024/1/15
 * @see <a href="https://leetcode.cn/problems/unique-morse-code-words/">链接</a>
 */
public class UniqueMorseRepresentations {

    public static void main(String[] args) {
        UniqueMorseRepresentations u = new UniqueMorseRepresentations();
        System.out.println(u.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(u.uniqueMorseRepresentations(new String[]{"a"}));
    }

    private static final String[] MSM = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        // 2ms
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0, k = word.length(); i < k; i++) {
                int idx = word.charAt(i) - 'a';
                sb.append(MSM[idx]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

}
