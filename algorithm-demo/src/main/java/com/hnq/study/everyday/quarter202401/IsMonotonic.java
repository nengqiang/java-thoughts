package com.hnq.study.everyday.quarter202401;

/**
 * 单调数列
 * <p>
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 * <p>
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。
 * 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
 * <p>
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [1,2,2,3]
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：nums = [6,5,4,4]
 * 输出：true
 * <p>
 *
 * 示例 3：
 * 输入：nums = [1,3,2]
 * 输出：false
 * <p>
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * -105 <= nums[i] <= 10^5
 *
 * @author henengqiang
 * @date 2024/3/4
 * @see <a href="https://leetcode.cn/problems/monotonic-array/description/">链接</a>
 */
public class IsMonotonic {

    public static void main(String[] args) {
        IsMonotonic i = new IsMonotonic();
        System.out.println(i.isMonotonic2(new int[]{1, 2, 2, 3}));
        System.out.println(i.isMonotonic2(new int[]{6, 5, 4, 4}));
        System.out.println(i.isMonotonic2(new int[]{1, 3, 2}));
    }

    public boolean isMonotonic(int[] nums) {
        // 1ms
        int pre = 0, dre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dre == 0) {
                if (nums[i] > nums[pre]) {
                    dre = 1;
                } else if (nums[i] < nums[pre]) {
                    dre = -1;
                }
            } else if (dre == 1) {
                if (nums[i] < nums[pre]) {
                    return false;
                }
            } else {
                if (nums[i] > nums[pre]) {
                    return false;
                }
            }
            pre = i;
        }
        return true;
    }

    /**
     * 遍历数组 nums，若既遇到了 nums[i]>nums[i+1] 又遇到了 nums[i′]<nums[i′+1]，
     * 则说明 nums 既不是单调递增的，也不是单调递减的。
     */
    public boolean isMonotonic2(int[] nums) {
        boolean inc = true, dec = true;
        for (int i = 0, k = nums.length; i < k - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                inc = false;
            }
            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }

}
