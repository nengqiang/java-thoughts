package com.hnq.study.everyday.month2202;

import java.util.Arrays;

/**
 * 给定两个数组nums1和nums2 ，返回 它们的交集。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * @author henengqiang
 * @date 2022/02/17
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays">链接</a>
 */
public class Intersection {

    public static void main(String[] args) {
        int[] a2 = new int[]{4, 9, 5};
        int[] b2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(a2, b2)));

        int[] a1 = new int[]{1, 2, 2, 1};
        int[] b1 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersection(a1, b1)));

    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        // 0ms
        // 空间换时间
        int resLength = nums2.length;
        int[] resTmp = new int[resLength];
        int[] tmp = new int[1001];
        int j = 0;
        int subTimes = 0;
        for (int i : nums1) {
            tmp[i] = 1;
        }
        for (int i : nums2) {
            if (tmp[i] == 1) {
                tmp[i] = 0;
                resTmp[j++] = i;
                continue;
            }
            if (tmp[i] == 0) {
                subTimes++;
            }
        }
        if (subTimes > 0) {
            int[] res = new int[resLength - subTimes];
            int k = 0;
            for (int i : resTmp) {
                if (i != 0) {
                    res[k++] = i;
                }
            }
            return res;
        }
        return resTmp;
    }

}
