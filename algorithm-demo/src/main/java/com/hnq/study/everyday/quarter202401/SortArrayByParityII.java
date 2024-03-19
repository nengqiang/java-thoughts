package com.hnq.study.everyday.quarter202401;

import java.util.Arrays;

/**
 * 按奇偶排序数组 II
 *
 * @author henengqiang
 * @date 2024/3/19
 * @see <a href="https://leetcode.cn/problems/sort-array-by-parity-ii/">链接</a>
 */
public class SortArrayByParityII {

    public static void main(String[] args) {
        SortArrayByParityII s =  new SortArrayByParityII();
        System.out.println(Arrays.toString(s.sortArrayByParityII2(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(s.sortArrayByParityII2(new int[]{3, 2})));
    }

    /**
     * 两次遍历
     */
    public int[] sortArrayByParityII(int[] nums) {
        // 2ms
        int[] tmp = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                tmp[i] = num;
                i += 2;
            }
        }
        i = 1;
        for (int num : nums) {
            if (num % 2 == 1) {
                tmp[i] = num;
                i += 2;
            }
        }
        return tmp;
    }

    /**
     * 双指针：i为奇指针；j为偶指针
     */
    public int[] sortArrayByParityII2(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }


}
