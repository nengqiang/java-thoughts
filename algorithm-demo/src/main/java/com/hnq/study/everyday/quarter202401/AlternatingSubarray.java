package com.hnq.study.everyday.quarter202401;

/**
 * 最长交替子数组
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ：
 * <p>
 * m 大于 1 。
 * s1 = s0 + 1 。
 * 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。
 * 也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
 * 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
 * <p>
 * 子数组是一个数组中一段连续 非空 的元素序列。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [2,3,4,3,4]
 * 输出：4
 * 解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。
 * <p>
 *
 * 示例 2：
 * 输入：nums = [4,5,6]
 * 输出：2
 * 解释：[4,5] 和 [5,6] 是仅有的两个交替子数组。它们长度都为 2 。
 * <p>
 *
 * 提示：
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 10^4
 *
 * @author henengqiang
 * @date 2024/1/23
 * @see <a href="https://leetcode.cn/problems/longest-alternating-subarray/?envType=daily-question&envId=2024-01-23">链接</a>
 */
public class AlternatingSubarray {

    public static void main(String[] args) {
        AlternatingSubarray a = new AlternatingSubarray();
        System.out.println(a.alternatingSubarray2(new int[]{2, 3, 4, 3, 4}));
    }

    /**
     * 双层循环
     */
    public int alternatingSubarray(int[] nums) {
        // 2ms
        int res = -1, n = nums.length;
        for (int firstIndex = 0; firstIndex < n; firstIndex++) {
            for (int i = firstIndex + 1; i < n; i++) {
                int length = i - firstIndex + 1;
                if (nums[i] - nums[firstIndex] == (length - 1) % 2) {
                    res = Math.max(res, length);
                } else {
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 单层循环
     */
    public int alternatingSubarray2(int[] nums) {
        // 1ms
        int res = -1;
        int n = nums.length;
        int firstIndex = 0;
        for (int i = 1; i < n; i++) {
            int length = i - firstIndex + 1;
            if (nums[i] - nums[firstIndex] == (length - 1) % 2) {
                res = Math.max(res, length);
            } else {
                if (nums[i] - nums[i - 1] == 1) {
                    firstIndex = i - 1;
                    res = Math.max(res, 2);
                } else {
                    firstIndex = i;
                }
            }
        }
        return res;
    }

}
