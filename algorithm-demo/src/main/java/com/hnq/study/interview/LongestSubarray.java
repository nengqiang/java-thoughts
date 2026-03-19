package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/3/19
 * @see <a href="https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75">删除一次元素后全为1的最长子数组</a>
 */
public class LongestSubarray {

    public static void main(String[] args) {
        LongestSubarray l = new LongestSubarray();
        int[] nums = {1, 1, 0, 1};
        System.out.println(l.longestSubarray(nums));
        nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(l.longestSubarray(nums));
        nums = new int[]{1, 1, 1};
        System.out.println(l.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        // 3ms
        int zeroCount = 0, len = nums.length;
        int left = 0, right = 0;
        int max = 0;
        while (right < len) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            if (zeroCount > 1) {
                while (nums[left] == 1) {
                    left++;
                }
                left++;
                zeroCount--;
            }
            max = Math.max(max, right - left);
            right++;
        }
        return max;
    }

}
