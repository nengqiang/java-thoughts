package com.hnq.study.everyday.quarter202303;

/**
 * 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
 * <p>
 * 给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
 * <p>
 * 袋子最初包含：
 * <p>
 * numOnes 件标记为 1 的物品。
 * numZeroes 件标记为 0 的物品。
 * numNegOnes 件标记为 -1 的物品。
 * 现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
 * <p>
 *
 * 示例 1：
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
 * 输出：2
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 2 件标记为 1 的物品，得到的数字之和为 2 。
 * 可以证明 2 是所有可行方案中的最大值。
 * <p>
 *
 * 示例 2：
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4
 * 输出：3
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 3 件标记为 1 的物品，1 件标记为 0 的物品，得到的数字之和为 3 。
 * 可以证明 3 是所有可行方案中的最大值。
 * <p>
 *
 * 提示：
 * 0 <= numOnes, numZeros, numNegOnes <= 50
 * 0 <= k <= numOnes + numZeros + numNegOnes
 *
 * @author henengqiang
 * @date 2023/7/5
 * @see <a href="https://leetcode.cn/problems/k-items-with-the-maximum-sum">链接</a>
 */
public class KItemsWithMaximumSum {

    public static void main(String[] args) {
        KItemsWithMaximumSum k = new KItemsWithMaximumSum();
        System.out.println(k.kItemsWithMaximumSum(3, 3, 0, 2));
        System.out.println(k.kItemsWithMaximumSum(3, 2, 0, 4));
    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        // 1ms
        if (k <= numOnes) {
            return k;
        }
        if (k <= numOnes + numZeros) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }

}
