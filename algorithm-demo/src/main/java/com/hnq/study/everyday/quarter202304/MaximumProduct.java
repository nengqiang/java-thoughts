package com.hnq.study.everyday.quarter202304;

import java.util.Arrays;

/**
 * 三个数的最大乘积
 * <p>
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：6
 * <p>
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * <p>
 *
 * 示例 3：
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 * <p>
 *
 * 提示：
 * 3 <= nums.length <= 10^4
 * -1000 <= nums[i] <= 1000
 *
 * @author henengqiang
 * @date 2023/10/16
 * @see <a href="https://leetcode.cn/problems/maximum-product-of-three-numbers/">链接</a>
 */
public class MaximumProduct {

    public static void main(String[] args) {
        MaximumProduct m = new MaximumProduct();
        System.out.println(m.maximumProduct2(new int[]{2, 3, 4, 1}));
        System.out.println(m.maximumProduct2(new int[]{-100, -98, -1, 2, 3, 4}));
    }

    public int maximumProduct(int[] nums) {
        // 11ms
        int len = nums.length;
        if (len > 3) {
            Arrays.sort(nums);
        }
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }

    /**
     * 线性扫描
     * 求出数组中最大的三个数以及最小的两个数，因此我们可以不用排序，用线性扫描直接得出这五个数。
     */
    public int maximumProduct2(int[] nums) {
        // 2ms
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

}
