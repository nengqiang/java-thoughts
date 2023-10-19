package com.hnq.study.everyday.quarter202304;

/**
 * 子数组最大平均数 I
 * <p>
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10^-5 的答案都将被视为正确答案。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 *
 * 示例 2：
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 *
 * 提示：
 * n == nums.length
 * 1 <= k <= n <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * @author henengqiang
 * @date 2023/10/19
 * @see <a href="https://leetcode.cn/problems/maximum-average-subarray-i/">链接</a>
 */
public class FindMaxAverage {

    public static void main(String[] args) {
        FindMaxAverage f = new FindMaxAverage();
        System.out.println(f.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    /**
     * 滑动窗口: sum(i) = sum(i - 1) - nums[i - k] + nums[i]
     */
    public double findMaxAverage(int[] nums, int k) {
        // 2ms
        int sum = 0, n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

}
