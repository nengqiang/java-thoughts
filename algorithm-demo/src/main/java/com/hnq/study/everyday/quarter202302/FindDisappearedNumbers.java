package com.hnq.study.everyday.quarter202302;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 * <p>
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * <p>
 *
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 *
 * @author henengqiang
 * @date 2023/6/25
 * @see <a href="https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array">链接</a>
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        FindDisappearedNumbers f = new FindDisappearedNumbers();
        System.out.println(f.findDisappearedNumbers2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(f.findDisappearedNumbers2(new int[]{1, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 4ms
        int len = nums.length;
        int[] t = new int[len];
        for (int i = 0; i < len; i++) {
            t[i]++;
            if (nums[i] - 1 < len) {
                t[nums[i] - 1]--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (t[i] == 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        // 3ms
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

}
