package com.hnq.study.everyday.quarter202304;

import java.util.Arrays;

/**
 * 寻找数组的中心下标
 * <p>
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。
 * 这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 *
 * 示例 2：
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * <p>
 *
 * 示例 3：
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 * <p>
 *
 * 提示：
 * 1 <= nums.length <= 10^4
 * -1000 <= nums[i] <= 1000
 * <p>
 *
 * @author henengqiang
 * @date 2023/12/15
 * @see <a href="https://leetcode.cn/problems/find-pivot-index/">链接</a>
 */
public class PivotIndex {

    public static void main(String[] args) {
        PivotIndex p = new PivotIndex();
        System.out.println(p.pivotIndex2(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(p.pivotIndex2(new int[]{1, 2, 3}));
        System.out.println(p.pivotIndex2(new int[]{2, 1, -1}));
    }

    public int pivotIndex(int[] nums) {
        // 1ms
        int sum = 0, pre = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            int t = sum - nums[i] - pre;
            if (pre == t) {
                return i;
            } else {
                pre += nums[i];
            }
        }
        return -1;
    }

    /**
     * 前缀和
     */
    public int pivotIndex2(int[] nums) {
        // 3ms
        int total = Arrays.stream(nums).sum(), sum = 0;
        for (int i = 0, limit = nums.length; i < limit; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

}
