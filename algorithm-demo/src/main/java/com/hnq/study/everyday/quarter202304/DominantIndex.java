package com.hnq.study.everyday.quarter202304;

/**
 * 至少是其他数字两倍的最大数
 * <p>
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。
 * 如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 至少是数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * <p>
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * <p>
 *
 * 提示：
 * 2 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 *
 * @author henengqiang
 * @date 2023/12/25
 * @see <a href="https://leetcode.cn/problems/largest-number-at-least-twice-of-others/">链接</a>
 */
public class DominantIndex {

    public static void main(String[] args) {
        DominantIndex d = new DominantIndex();
        System.out.println(d.dominantIndex(new int[]{1, 0}));
        System.out.println(d.dominantIndex(new int[]{0, 0, 0, 1}));
        System.out.println(d.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(d.dominantIndex(new int[]{1, 2, 3, 4}));
    }

    public int dominantIndex(int[] nums) {
        // 0ms
        int sMax = -1, max = -1, idx = 0;
        for (int i = 0, limit = nums.length; i < limit; i++) {
            if (nums[i] > max) {
                sMax = max;
                max = nums[i];
                idx = i;
            }
            if (nums[i] < max && nums[i] > sMax) {
                sMax = nums[i];
            }
        }
        if (max >= sMax * 2) {
            return idx;
        }
        return -1;
    }

}
