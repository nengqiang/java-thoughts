package com.hnq.study.everyday.quarter202402;

/**
 * 正整数和负整数的最大计数
 *
 * @author henengqiang
 * @date 2024/4/9
 * @see <a href="https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/?envType=daily-question&envId=2024-04-09">链接</a>
 */
public class MaximumCount {

    public static void main(String[] args) {
        MaximumCount m = new MaximumCount();
        System.out.println(m.maximumCount(new int[]{-2,-1,-1,1,2,3}));
        System.out.println(m.maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
        System.out.println(m.maximumCount(new int[]{5,20,66,1314}));
    }

    public int maximumCount(int[] nums) {
        // 0ms
        int cn1 = 0, cn2 = 0;
        for (int num : nums) {
            if (num > 0) {
                cn1++;
            } else if (num < 0) {
                cn2++;
            }
        }
        return Math.max(cn1, cn2);
    }

    /**
     * 二分查找
     */
    public int maximumCount2(int[] nums) {
        int pos1 = lowerBound(nums, 0);
        int pos2 = lowerBound(nums, 1);
        return Math.max(pos1, nums.length - pos2);
    }

    public int lowerBound(int[] nums, int val) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= val) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
