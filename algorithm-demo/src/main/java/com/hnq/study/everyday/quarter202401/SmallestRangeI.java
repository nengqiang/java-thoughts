package com.hnq.study.everyday.quarter202401;

/**
 * 最小差值 I
 *
 * @author henengqiang
 * @date 2024/3/8
 * @see <a href="https://leetcode.cn/problems/smallest-range-i/">链接</a>
 */
public class SmallestRangeI {

    public static void main(String[] args) {
        SmallestRangeI s = new SmallestRangeI();
        int[] n1 = {1};
        System.out.println(s.smallestRangeI(n1, 0));
        int[] n2 = {0, 10};
        System.out.println(s.smallestRangeI(n2, 2));
        int[] n3 = {1, 3, 6};
        System.out.println(s.smallestRangeI(n3, 3));
    }

    public int smallestRangeI(int[] nums, int k) {
        // 3ms
        if (nums.length == 0) {
            return 0;
        }
        int max = -1, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min >= 2 * k ? max - k - (min + k) : 0;
    }

}
