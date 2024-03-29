package com.hnq.study.everyday.quarter202401;

/**
 * 元素和最小的山形三元组 I
 *
 * @author henengqiang
 * @date 2024/3/29
 * @see <a href="https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i/?envType=daily-question&envId=2024-03-29">链接</a>
 */
public class MinimumSum {

    public static void main(String[] args) {
        MinimumSum m = new MinimumSum();
        System.out.println(m.minimumSum(new int[]{8, 6, 1, 5, 3}));
    }

    /**
     * 数组
     */
    public int minimumSum(int[] nums) {
        int n = nums.length, res = 1000, mn = 1000;
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = mn = Math.min(nums[i - 1], mn);
        }

        int right = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (left[i] < nums[i] && nums[i] > right) {
                res = Math.min(res, left[i] + nums[i] + right);
            }
            right = Math.min(right, nums[i]);
        }
        return res < 1000 ? res : -1;
    }

}
