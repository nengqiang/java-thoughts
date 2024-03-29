package com.hnq.study.everyday.quarter202303;

/**
 * 从两个数字数组里生成最小数字
 * <p>
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，
 * 请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 * <p>
 *
 * 示例 1：
 * 输入：nums1 = [4,1,3], nums2 = [5,7]
 * 输出：15
 * 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
 * <p>
 *
 * 示例 2：
 * 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出：3
 * 解释：数字 3 的数位 3 在两个数组中都出现了。
 * <p>
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 9
 * 1 <= nums1[i], nums2[i] <= 9
 * 每个数组中，元素 互不相同 。
 *
 * @author henengqiang
 * @date 2023/9/5
 * @see <a href="https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/?envType=daily-question&envId=2023-09-05">链接</a>
 */
public class MinNumber {

    public static void main(String[] args) {
        MinNumber m = new MinNumber();
        System.out.println(m.minNumber(new int[]{3, 5, 2, 6}, new int[]{3, 1, 7}));
        System.out.println(m.minNumber(new int[]{4, 1, 3}, new int[]{5, 7}));
    }

    public int minNumber(int[] nums1, int[] nums2) {
        // 0ms
        int min1 = 99, min2 = 99, en = 99;
        for (int j : nums1) {
            min1 = Math.min(min1, j);
            for (int k : nums2) {
                if (j == k) {
                    en = Math.min(j, en);
                }
                min2 = Math.min(min2, k);
            }
        }
        if (en < 99) {
            return en;
        }
        return min1 < min2 ? min1 * 10 + min2 : min2 * 10 + min1;
    }

}
