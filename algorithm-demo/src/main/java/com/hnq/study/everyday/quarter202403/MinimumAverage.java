package com.hnq.study.everyday.quarter202403;

import java.util.Arrays;

/**
 * @author henengqiang
 * @date 2024/10/16
 */
public class MinimumAverage {

    public static void main(String[] args) {
        MinimumAverage m = new MinimumAverage();
        System.out.println(m.minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
        System.out.println(m.minimumAverage(new int[]{1, 9, 8, 3, 10, 5}));
        System.out.println(m.minimumAverage(new int[]{1, 2, 3, 7, 8, 9}));
    }

    public double minimumAverage(int[] nums) {
        // 2ms
        // double[] average = new double[nums.length / 2];
        // Arrays.sort(nums);
        // int j = 0;
        // for (int i = 0; i < nums.length / 2; i++) {
        //     average[j++] = (nums[i] + nums[nums.length - i - 1]) / 2d;
        // }
        // Arrays.sort(average);
        // return average[0];

        // 1ms
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            min = Math.min(nums[i] + nums[nums.length - i - 1], min);
        }
        return min / 2d;
    }

}
