package com.hnq.study.everyday;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author henengqiang
 * @date 2021/06/28
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix">链接</a>
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] a = new String[] {"flower","flow","flight"};
        System.out.println("res=" + longestCommonPrefix(a));
        String[] b = new String[] {"dog","racecar","car"};
        System.out.println("res=" + longestCommonPrefix(b));
        String[] c = new String[] {"aa", "ab"};
        System.out.println("res=" + longestCommonPrefix(c));
        String[] d = new String[] {"aa", "a"};
        System.out.println("res=" + longestCommonPrefix(d));
    }

    private static String longestCommonPrefix(String[] strs) {
        // 2ms
        if (strs == null || strs.length <= 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int len = strs[0].length();
        int num = strs.length;
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < len) {
            char c = strs[0].charAt(i);
            int j = 1;
            while (j < num) {
                if (i < strs[j].length() && strs[j].charAt(i) == c) {
                    if (j >= num - 1) {
                        res.append(c);
                    }
                } else {
                    return res.toString();
                }
                j++;
            }
            i++;
        }
        return res.toString();
    }

    private static String longestCommonPrefix2(String[] strs) {
        // 0ms
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

}




























