package com.hnq.study.classicquestions;

import java.util.Arrays;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order. You may assume no duplicates in the array.
 *
 * Here are few examples.
 *
 * [1, 3, 5, 6], 5 -> 2
 * [1, 3, 5, 6], 2 -> 1
 * [1, 3, 5, 6], 7 -> 4
 * [1, 3, 5, 6], 0 -> 0
 *
 * @author henengqiang
 * @date 2019/02/26
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target1 = 5;
        int target2 = 2;
        int target3 = 7;
        int target4 = 0;
        print(nums, target1, ", target1 = ");
        print(nums, target2, ", target2 = ");
        print(nums, target3, ", target3 = ");
        print(nums, target4, ", target4 = ");
    }

    private static void print(int[] nums, int target, String s) {
        System.out.println("The original array: " + Arrays.toString(nums) + s + target);
        System.out.println("Find index = " + searchInsert1(nums, target) + " by method A.");
        System.out.println("Find index = " + searchInsert2(nums, target) + " by method B.");
    }

    /**
     * Solution
     * This is a binary search problem. The complexity should be O(log(n)).
     *
     * @param nums      Given array
     * @param target    Given target number
     * @return          the index
     */
    private static int searchInsert1(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    private static int searchInsert2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (target > nums[mid]) {
                i = mid + 1;
            } else if (target < nums[mid]) {
                j = mid - 1;
            } else {
                return mid;
            }
        }

        return i;
    }
}
