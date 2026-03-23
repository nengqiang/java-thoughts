package com.hnq.study.interview;

/**
 * @author henengqiang
 * @see <a href="https://leetcode.cn/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75">寻找数组的中心下标</a>
 * @since 2026/3/23
 */
public class PivotIndex {

    public static void main(String[] args) {
        PivotIndex p = new PivotIndex();
        System.out.println(p.pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
        System.out.println(p.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(p.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(p.pivotIndex(new int[]{2, 1, -1}));
        System.out.println(p.pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
    }

    public int pivotIndex(int[] nums) {
        // 1ms
        int len = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        for (int i = 0; i < len; i++) {
            if (left == sum - left - nums[i]) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

}
