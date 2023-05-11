package com.hnq.study.everyday.quarter202302;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 无重复元素 的有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 *
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 *
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 *
 * 提示：
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 *
 * @author henengqiang
 * @date 2023/5/11
 * @see <a href="https://leetcode.cn/problems/summary-ranges">链接</a>
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] c = new int[]{};
        System.out.println(summaryRanges(c));
        int[] a = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(a));
        int[] b = new int[]{0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(b));
    }

    private static List<String> summaryRanges(int[] nums) {
        // 6ms
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length, i = 0, start = 0, end;
        while (i <= len) {
            if (i >= len - 1) {
                end = i;
                res.add(end == start ? String.valueOf(nums[start]) : nums[start] + "->" + nums[end]);
                return res;
            }
            if (nums[i + 1] - nums[i] == 1) {
                i++;
                continue;
            }
            end = i;
            res.add(end == start ? String.valueOf(nums[start]) : nums[start] + "->" + nums[end]);
            i++;
            start = i;
        }
        return res;
    }

    private static List<String> summaryRanges2(int[] nums) {
        // 0ms
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            if (!(i + 1 < nums.length && nums[i] == nums[i + 1] - 1)) {
                if (sb.length() > 0) {
                    sb.append("->");
                }
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (sb.length() == 0) {
                    sb.append(nums[i]);
                }
            }
        }
        return ans;
    }

}
