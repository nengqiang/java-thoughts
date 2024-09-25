package com.hnq.study.everyday.quarter202403;

import java.util.Arrays;

/**
 * @author henengqiang
 * @date 2024/9/25
 */
public class SortedSquares {

    public static void main(String[] args) {
        SortedSquares s = new SortedSquares();
        System.out.println(Arrays.toString(s.sortedSquares2(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(s.sortedSquares2(new int[]{-7, -3, 2, 3, 11})));
    }

    public int[] sortedSquares(int[] nums) {
        // 5ms
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 双指针
     */
    public int[] sortedSquares2(int[] nums) {
        // 1ms
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

}
