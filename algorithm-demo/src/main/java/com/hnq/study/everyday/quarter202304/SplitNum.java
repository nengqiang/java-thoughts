package com.hnq.study.everyday.quarter202304;

import java.util.Arrays;

/**
 * 最小和分割
 * <p>
 * 给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
 * <p>
 * num1 和 num2 直接连起来，得到 num 各数位的一个排列。
 * 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
 * num1 和 num2 可以包含前导 0 。
 * 请你返回 num1 和 num2 可以得到的和的 最小 值。
 * <p>
 *
 * 注意：
 * num 保证没有前导 0 。
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 * <p>
 *
 * 示例 1：
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * <p>
 *
 * 示例 2：
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 * <p>
 *
 * 提示：
 * 10 <= num <= 10^9
 *
 * @author henengqiang
 * @date 2023/10/9
 * @see <a href="https://leetcode.cn/problems/split-with-minimum-sum/?envType=daily-question&envId=2023-10-09">链接</a>
 */
public class SplitNum {

    public static void main(String[] args) {
        SplitNum s = new SplitNum();
        System.out.println(s.splitNum2(4325));
        System.out.println(s.splitNum2(687));
        System.out.println(s.splitNum2(345612));
    }

    public int splitNum(int num) {
        // 1ms
        int[] x = new int[String.valueOf(num).length()];
        int i = 0;
        while (num > 0) {
            x[i++] = num % 10;
            num /= 10;
        }
        Arrays.sort(x);
        int a = 0, b = 0, flag = 1;
        for (int k : x) {
            if (flag == 1) {
                a = a * 10 + k;
                flag = 2;
            } else {
                b = b * 10 + k;
                flag = 1;
            }
        }
        return a + b;
    }

    /**
     * 贪心
     */
    public int splitNum2(int num) {
        // 1ms
        char[] st = Integer.toString(num).toCharArray();
        Arrays.sort(st);
        int n1 = 0, n2 = 0;
        for (int i = 0; i < st.length; i++) {
            if (i % 2 == 0) {
                n1 = n1 * 10 + (st[i] - '0');
            } else {
                n2 = n2 * 10 + (st[i] - '0');
            }
        }
        return n1 + n2;
    }

}
