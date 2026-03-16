package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/3/16
 * @see <a href="https://leetcode.cn/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75">子数组最大平均数Ⅰ</a>
 */
public class FindMaxAverage {

    public static void main(String[] args) {
        FindMaxAverage f = new FindMaxAverage();
        System.out.println(f.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(f.findMaxAverage(new int[]{5}, 1));
        System.out.println(f.findMaxAverage(new int[]{-1}, 1));
    }

    public double findMaxAverage(int[] nums, int k) {
        // 3ms
        int tmp = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if (i >= k - 1) {
                max = Math.max(max, tmp);
                tmp -= nums[i - k + 1];
            }
        }
        return (double) max / k;
    }

}
