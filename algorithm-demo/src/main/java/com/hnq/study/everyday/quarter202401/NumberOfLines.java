package com.hnq.study.everyday.quarter202401;

import java.util.Arrays;

/**
 * 写字符串需要的行数
 * <p>
 * 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，
 * 如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。
 * 我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位，
 * widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 * <p>
 * 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 * <p>
 *
 * 示例 1:
 * 输入:
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * 输出: [3, 60]
 * 解释:
 * 所有的字符拥有相同的占用单位10。所以书写所有的26个字母，
 * 我们需要2个整行和占用60个单位的一行。
 * <p>
 *
 * 示例 2:
 * 输入:
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * 输出: [2, 4]
 * 解释:
 * 除去字母'a'所有的字符都是相同的单位10，并且字符串 "bbbcccdddaa" 将会覆盖 9 * 10 + 2 * 4 = 98 个单位.
 * 最后一个字母 'a' 将会被写到第二行，因为第一行只剩下2个单位了。
 * 所以，这个答案是2行，第二行有4个单位宽度。
 * <p>
 *
 * 注:
 * 字符串 S 的长度在 [1, 1000] 的范围。
 * S 只包含小写字母。
 * widths 是长度为 26的数组。
 * widths[i] 值的范围在 [2, 10]。
 *
 * @author henengqiang
 * @date 2024/1/16
 * @see <a href="https://leetcode.cn/problems/number-of-lines-to-write-string/">链接</a>
 */
public class NumberOfLines {

    public static void main(String[] args) {
        NumberOfLines n = new NumberOfLines();
        int[] w4 = new int[]{7, 5, 4, 7, 10, 7, 9, 4, 8, 9, 6, 5, 4, 2, 3, 10, 9, 9, 3, 7, 5, 2, 9, 4, 8, 9};
        System.out.println(Arrays.toString(n.numberOfLines2(w4, "zlrovckbgjqofmdzqetflraziyvkvcxzahzuuveypqxmjbwrjvmpdxjuhqyktuwjvmbeswxuznumazgxvitdrzxmqzhaaudztgie")));
        int[] w3 = new int[]{3, 4, 10, 4, 8, 7, 3, 3, 4, 9, 8, 2, 9, 6, 2, 8, 4, 9, 9, 10, 2, 4, 9, 10, 8, 2};
        System.out.println(Arrays.toString(n.numberOfLines2(w3, "mqblbtpvicqhbrejb")));
        int[] w1 = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(Arrays.toString(n.numberOfLines2(w1, "abcdefghijklmnopqrstuvwxyz")));
        int[] w2 = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(Arrays.toString(n.numberOfLines2(w2, "bbbcccdddaaa")));
    }

    public int[] numberOfLines(int[] widths, String s) {
        // 0ms
        int lines = 0, len = s.length(), k = 100;
        for (int i = 0; i < len; i++) {
            int xi = widths[s.charAt(i) - 'a'];
            if (k >= xi) {
                k -= xi;
                if (k == 0) {
                    lines++;
                    k = 100;
                }
            } else {
                lines++;
                k = 100 - xi;
            }
        }
        return k > 0 && k < 100 ? new int[]{lines + 1, 100 - k} : new int[] {lines , 100};
    }

    public static final int MAX_WIDTH = 100;
    public int[] numberOfLines2(int[] widths, String s) {
        int lines = 1, width = 0;
        for (int i = 0, k = s.length(); i < k; i++) {
            int need = widths[s.charAt(i) - 'a'];
            width += need;
            if (width > MAX_WIDTH) {
                lines++;
                width = need;
            }
        }
        return new int[]{lines, width};
    }

}
