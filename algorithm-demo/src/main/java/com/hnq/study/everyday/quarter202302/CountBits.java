package com.hnq.study.everyday.quarter202302;

import java.util.Arrays;

/**
 * 给你一个整数 n ，对于0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 *
 * 提示：
 * 0 <= n <= 10^5
 * <p>
 *
 * 进阶：
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的__builtin_popcount ）
 * <p>
 * 
 * @author henengqiang
 * @date 2023/5/24
 * @see <a href="https://leetcode.cn/problems/counting-bits">链接</a>
 */
public class CountBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits2(2)));
        System.out.println(Arrays.toString(countBits2(5)));
    }

    private static int[] countBits(int n) {
        // 12ms
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            for (int j = 0; j < s.length(); j++) {
                if ('1' == s.charAt(j)) {
                    ++ans[i];
                }
            }
        }
        return ans;
    }

    private static int[] countBits2(int n) {
        // 1ms
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    /**
     * Brian Kernighan 算法：
     * 对于任意整数 x，令 x = x & ( x − 1 )，该运算将 x 的二进制表示的最后一个 1 变成 0。
     * 因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     */
    private static int[] countBits01(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private static int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    /**
     * 动态规划——最高有效位：
     * 当计算 i 的「一比特数」时，如果存在 0 ≤ j < i， j 的「一比特数」已知，且 i 和 j 相比，
     * i 的二进制表示只多了一个 1，则可以快速得到 i 的「一比特数」。
     */
    private static int[] countBits02(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 0; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    /**
     * 动态规划——最低有效位：
     */
    private static int[] countBits03(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    /**
     * 动态规划——最低设置位：
     */
    private static int[] countBits04(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i < n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

}
