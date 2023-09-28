package com.hnq.study.everyday.quarter202303;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 最长和谐子序列
 * <p>
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * <p>
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * <p>
 *
 * 示例 3：
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * <p>
 *
 * 提示：
 * 1 <= nums.length <= 2 * 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 * @author henengqiang
 * @date 2023/9/28
 * @see <a href="https://leetcode.cn/problems/longest-harmonious-subsequence/">链接</a>
 */
public class FindLHS {

    public static void main(String[] args) {
        FindLHS f = new FindLHS();
        System.out.println(f.findLHS2(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    /**
     * 枚举
     */
    public int findLHS(int[] nums) {
        // 15ms
        Arrays.sort(nums);
        int begin = 0, res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;
    }

    /**
     * 哈希表
     */
    public int findLHS2(int[] nums) {
        // 17ms
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (Integer key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }
        return res;
    }

}
