package com.hnq.study.everyday.quarter202304;

/**
 * 二分查找
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 *
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * @author henengqiang
 * @date 2023/11/30
 * @see <a href="https://leetcode.cn/problems/binary-search/">链接</a>
 */
public class Search {

    public static void main(String[] args) {
        Search s = new Search();
        System.out.println(s.search2(new int[]{5}, 5));
        System.out.println(s.search2(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(s.search2(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    public int search(int[] nums, int target, int p, int q) {
        // 0ms
        if (p >= q) {
            return -1;
        }
        int mid = (q - p) / 2 + p;
        if (target == nums[mid]) {
            return mid;
        }
        if (target < nums[mid]) {
            q = q == mid ? q - 1 : mid;
        } else {
            p = p == mid ? p + 1 : mid;
        }
        return search(nums, target, p, q);
    }

    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
