package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/3/18
 * @see <a href="https://leetcode.cn/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75">最大连续1的个数 III</a>
 */
public class LongestOnes {

    public static void main(String[] args) {
        LongestOnes l = new LongestOnes();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(l.longestOnes(nums, k));

        nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        k = 3;
        System.out.println(l.longestOnes(nums, k));

        nums = new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1, 1};
        k = 2;
        System.out.println(l.longestOnes(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        // 3ms
        int left = 0, right = 0;
        int max = 0;
        int zeroCount = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

}
