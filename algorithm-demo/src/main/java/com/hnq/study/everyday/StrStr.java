package com.hnq.study.everyday;

/**
 * 实现strStr()函数。
 *
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 * 说明：
 *
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 * 
 *
 * 提示：
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author henengqiang
 * @date 2021/07/06
 * @see <a href="https://leetcode-cn.com/problems/implement-strstr">链接</a>
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "baa"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("", "ll"));
        System.out.println(strStr("heloolollpll", "ll"));
        System.out.println(strStr("heloolollpll", "lp"));
        System.out.println(strStr("heloolollpll", "eloo"));
        System.out.println(strStr("aaa", "aaaa"));
    }

    private static int strStr(String haystack, String needle) {
        // 3ms
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        if (haystack == null || "".equals(haystack) || needle.length() > haystack.length()) {
            return -1;
        }
        int hLen = haystack.length();
        int nLen = needle.length();
        int i = 0, j = 0, startIdx = -1;
        while (i < hLen) {
            if (j < nLen) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    if (j == 0) {
                        startIdx = i;
                    }
                    j++;
                }
                i++;
                // 不是连续包含时，指针回退
                if (i - startIdx != j) {
                    if (j != 0) {
                        i -= j;
                        j = 0;
                        startIdx = -1;
                    }
                }
                // h 剩下的长度不够包含 n 剩下的长度时，一定不包含，直接返回
                if (hLen - i < nLen - j) {
                    return -1;
                }
            } else {
                break;
            }
        }
        return startIdx;
    }
}
