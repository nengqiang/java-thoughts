package com.hnq.study.everyday.quarter202303;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 美式键盘 中：
 * <p>
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * American keyboard
 * <p>
 *
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * <p>
 *
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 * <p>
 *
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>
 *
 * 提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 *
 * @author henengqiang
 * @date 2023/8/15
 * @see <a href="https://leetcode.cn/problems/keyboard-row/">链接<a/>
 */
public class FindWords {

    public static void main(String[] args) {
        FindWords f = new FindWords();
        System.out.println(Arrays.toString(f.findWords2(new String[]{"omk"})));
        System.out.println(Arrays.toString(f.findWords2(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(f.findWords2(new String[]{"adsdf", "sfd"})));
    }

    public String[] findWords(String[] words) {
        // 0ms
        String a = "qwertyuiopQWERTYUIOP", b = "asdfghjklASDFGHJKL", c = "zxcvbnmZXCVBNM";
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            boolean ca = true, cb = true, cc = true;
            for (char cr : word.toCharArray()) {
                if (ca && a.indexOf(cr) < 0) {
                    ca = false;
                }
                if (cb && b.indexOf(cr) < 0) {
                    cb = false;
                }
                if (cc && c.indexOf(cr) < 0) {
                    cc = false;
                }
            }
            if (ca || cb || cc) {
                if (sb.length() > 0) {
                    sb.append("#");
                }
                sb.append(word);
            }
        }
        return sb.length() > 0 ? sb.toString().split("#") : new String[0];
    }

    /**
     * 转换为行号
     */
    public String[] findWords2(String[] words) {
        List<String> list = new ArrayList<>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
