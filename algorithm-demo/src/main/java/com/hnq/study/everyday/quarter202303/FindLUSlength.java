package com.hnq.study.everyday.quarter202303;

/**
 * 最长特殊序列 Ⅰ
 * <p>
 * 给你两个字符串 a 和 b，请返回 这两个字符串中 最长的特殊序列  的长度。如果不存在，则返回 -1 。
 * <p>
 * 「最长特殊序列」 定义如下：该序列为 某字符串独有的最长子序列（即不能是其他字符串的子序列） 。
 * <p>
 * 字符串 s 的子序列是在从 s 中删除任意数量的字符后可以获得的字符串。
 * <p>
 * 例如，"abc" 是 "aebdc" 的子序列，因为删除 "aebdc" 中斜体加粗的字符可以得到 "abc" 。
 * "aebdc" 的子序列还包括 "aebdc" 、 "aeb" 和 "" (空字符串)。
 * <p>
 *
 * 示例 1：
 * 输入: a = "aba", b = "cdc"
 * 输出: 3
 * 解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
 * <p>
 *
 * 示例 2：
 * 输入：a = "aaa", b = "bbb"
 * 输出：3
 * 解释: 最长特殊序列是 "aaa" 和 "bbb" 。
 * <p>
 *
 * 示例 3：
 * 输入：a = "aaa", b = "aaa"
 * 输出：-1
 * 解释: 字符串 a 的每个子序列也是字符串 b 的每个子序列。同样，字符串 b 的每个子序列也是字符串 a 的子序列。
 * <p>
 *
 * 提示：
 * 1 <= a.length, b.length <= 100
 * a 和 b 由小写英文字母组成
 *
 * @author henengqiang
 * @date 2023/8/29
 * @see <a href="https://leetcode.cn/problems/longest-uncommon-subsequence-i/">链接</a>
 */
public class FindLUSlength {

    public static void main(String[] args) {
        FindLUSlength f = new FindLUSlength();
        System.out.println(f.findLUSlength("aba", "cdc"));
        System.out.println(f.findLUSlength("aaa", "bbb"));
        System.out.println(f.findLUSlength("aaa", "aaa"));
        System.out.println(f.findLUSlength("a", "a"));
        System.out.println(f.findLUSlength("a", "b"));
        System.out.println(f.findLUSlength("abcde", "b"));
    }

    public int findLUSlength(String a, String b) {
        // 0ms
        if (a.length() != b.length()) {
            return Math.max(a.length(), b.length());
        }
        if (a.equals(b)) {
            return -1;
        }
        return a.length();
    }

    public int findLUSlength2(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }

}
