package com.hnq.study.everyday.quarter202401;

/**
 * 区域和检索 - 数组不可变
 *
 * @author henengqiang
 * @date 2024/3/18
 * @see <a href="https://leetcode.cn/problems/range-sum-query-immutable/?envType=daily-question&envId=2024-03-18">链接</a>
 */
public class NumArray {

    // private static int[] arr;

    private final int[] sums;

    /**
     * 前缀和：这个数=前面所有数的和，
     * 则范围和= sums[j + 1] - sums[i]
     */
    public NumArray(int[] nums) {
        // arr = nums;

        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // 54ms
        // left = Math.max(left, 0);
        // right = Math.min(right, arr.length - 1);
        // int sum = 0;
        // for (int i = left; i <= right; i++) {
        //     sum += arr[i];
        // }
        // return sum;

        // 7ms
        return sums[right + 1] - sums[left];
    }

    public static void main(String[] args) {
        NumArray n = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(n.sumRange(0, 2));
        System.out.println(n.sumRange(2, 5));
        System.out.println(n.sumRange(0, 5));
    }

}
