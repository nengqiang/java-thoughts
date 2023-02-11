package com.hnq.study.everyday.month202302;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * <p>
 *
 * 示例 1:
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于2 是一位数，所以返回 2。
 * <p>
 *
 * 示例 2:
 * 输入: num = 0
 * 输出: 0
 * <p>
 *
 * 提示：
 * 0 <= num <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2023/2/11
 * @see <a href="https://leetcode.cn/problems/add-digits">链接</a>
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits2(38));
        System.out.println(addDigits2(0));
    }

    private static int addDigits(int num) {
        // 0ms 39.2MB
        int p = 10;
        int h = num / p;
        int t = num % p;
        if (h < p && h + t < p) {
            return h + t;
        }
        int r = addDigits(h);
        if (r + t < p) {
            return r + t;
        }
        return addDigits(r + t);
    }

    private static int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

}