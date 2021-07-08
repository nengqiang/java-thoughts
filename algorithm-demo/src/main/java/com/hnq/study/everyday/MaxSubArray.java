package com.hnq.study.everyday;

/**
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 * 
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * 
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * @author henengqiang
 * @date 2021/7/8
 * @see <a href="https://leetcode-cn.com/problems/maximum-subarray">链接</a>
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray2(new int[]{-2, -1}));
        System.out.println(maxSubArray2(new int[]{-2, 1}));
        System.out.println(maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray2(new int[]{1}));
        System.out.println(maxSubArray2(new int[]{-1}));
    }

    private static int maxSubArray(int[] nums) {
        // 98ms
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0], tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                tmp += nums[j];
                if (max < tmp) {
                    max = tmp;
                }
            }
            tmp = 0;
        }
        return max;
    }

    private static int maxSubArray2(int[] nums) {
        // 0ms
        int sum = 0, max = 0, m = nums[0];
        for (int num : nums) {
            sum += num;
            if (m < num) {
                m = num;
            }
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        if (m < 0) {
            max = m;
        }
        return max;
    }

}
