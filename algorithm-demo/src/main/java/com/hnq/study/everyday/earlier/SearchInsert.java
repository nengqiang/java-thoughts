package com.hnq.study.everyday.earlier;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author henengqiang
 * @date 2021/7/7
 * @see <a href="https://leetcode-cn.com/problems/search-insert-position">链接</a>
 */
public class SearchInsert {

    public static void main(String[] args) {
        System.out.println(searchInsert2(new int[]{}, 0));
        System.out.println(searchInsert2(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert2(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert2(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert2(new int[]{1, 3, 5, 6}, 0));
    }

    private static int searchInsert(int[] nums, int target) {
        // 0ms
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        int pos = 0;
        for (int num : nums) {
            if (target > num) {
                pos++;
            } else if (target < num) {
                return pos;
            } else {
                return pos;
            }
        }
        return pos;
    }

    private static int searchInsert2(int[] nums, int target) {
        // 有序数组 二分法
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return low;
    }

}
