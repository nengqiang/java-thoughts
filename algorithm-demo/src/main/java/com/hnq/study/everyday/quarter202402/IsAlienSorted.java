package com.hnq.study.everyday.quarter202402;

/**
 * 验证外星语词典
 *
 * @author henengqiang
 * @date 2024/4/7
 * @see <a href="https://leetcode.cn/problems/verifying-an-alien-dictionary/description/">链接</a>
 */
public class IsAlienSorted {

    public static void main(String[] args) {
        IsAlienSorted i = new IsAlienSorted();
        String[] s1 = {"hello", "leetcode"};
        System.out.println(i.isAlienSorted(s1, "hlabcdefgijkmnopqrstuvwxyz"));

        String[] s2 = {"word", "world", "row"};
        System.out.println(i.isAlienSorted(s2, "worldabcefghijkmnpqstuvxyz"));

        String[] s3 = {"apple", "app"};
        System.out.println(i.isAlienSorted(s3, "abcdefghijklmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        // 0ms
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean valid = false;
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int prev = index[words[i - 1].charAt(j) - 'a'];
                int curr = index[words[i].charAt(j) - 'a'];
                if (prev < curr) {
                    valid = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!valid) {
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }

}
