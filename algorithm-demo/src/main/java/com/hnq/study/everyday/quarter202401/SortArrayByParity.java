package com.hnq.study.everyday.quarter202401;

import java.util.Arrays;

/**
 * 按奇偶排序数组
 *
 * @author henengqiang
 * @date 2024/3/7
 * @see <a href="https://leetcode.cn/problems/sort-array-by-parity/">链接</a>
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity s = new SortArrayByParity();
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{2, 4, 3, 1})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{1, 1, 2, 3, 4})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{0})));
    }

    public int[] sortArrayByParity(int[] nums) {
        // 0ms
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (i > p) {
                    int tmp = nums[p];
                    nums[p] = nums[i];
                    nums[i] = tmp;
                }
                p++;
            }
        }
        return nums;
    }

}
