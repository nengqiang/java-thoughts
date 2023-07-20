package com.hnq.study.everyday.quarter202303;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 *
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * <p>
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * nums[i]不是0就是1.
 *
 * @author henengqiang
 * @date 2023/7/20
 * @see <a href="https://leetcode.cn/problems/max-consecutive-ones">链接</a>
 */
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        FindMaxConsecutiveOnes f = new FindMaxConsecutiveOnes();
        System.out.println(f.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(f.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        // 1ms
        int max = 0, cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        return cnt > 0 ? Math.max(max, cnt) : max;
    }

}
