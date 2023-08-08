package com.hnq.study.everyday.quarter202303;

import java.util.*;

/**
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
 * 如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * <p>
 *
 * 示例 1：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * <p>
 *
 * 示例 2：
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 *
 * <p>
 * 提示：
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 10^4
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 * <p>
 *
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 * @author henengqiang
 * @date 2023/8/8
 * @see <a href="https://leetcode.cn/problems/next-greater-element-i/">链接</a>
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        NextGreaterElement n = new NextGreaterElement();
        System.out.println(Arrays.toString(n.nextGreaterElement2(new int[]{2, 1, 3}, new int[]{2, 3, 1})));
        System.out.println(Arrays.toString(n.nextGreaterElement2(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(n.nextGreaterElement2(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 2ms
        Map<Integer, Integer> n2 = new HashMap<>();
        int len = nums2.length;
        for (int i = 0; i < len; i++) {
            n2.put(nums2[i], i);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            int idx = n2.get(n), max = -1;
            for (int j = idx + 1; j < len; j++) {
                if (nums2[j] > n) {
                    max = nums2[j];
                    break;
                }
            }
            ans[i] = max;
        }
        return ans;
    }

    /**
     * 单调栈+哈希表
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        // 3ms
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

}
