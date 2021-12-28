package com.hnq.study.everyday.earlier;

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * @author henengqiang
 * @date 2021/07/28
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock">链接</a>
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] b = new int[]{7,6,4,3,1};
        System.out.println(maxProfit2(b));
        int[] a = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit2(a));
        int[] c = new int[]{1,2};
        System.out.println(maxProfit2(c));
        int[] d = new int[]{1};
        System.out.println(maxProfit2(d));
    }

    private static int maxProfit(int[] prices) {
        // 超时
        if (prices.length == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i <= prices.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(prices[i] - prices[j], max);
            }
        }
        return max;
    }

    /**
     * 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
     *
     * 记录【今天之前买入的最小值】
     * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
     * 比较【每天的最大获利】，取最大值即可
     */
    private static int maxProfit2(int[] prices) {
        // 2ms
        int minP = Integer.MAX_VALUE;
        int maxF = 0;
        for (int price : prices) {
            minP = Math.min(minP, price);
            maxF = Math.max(maxF, price - minP);
        }
        return maxF;
    }

}


























