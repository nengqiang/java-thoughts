package com.hnq.study.everyday.quarter202401;

import java.util.*;

/**
 * 找出不同元素数目差数组
 * <p>
 * 给你一个下标从 0 开始的数组 nums ，数组长度为 n 。
 * <p>
 * nums 的 不同元素数目差 数组可以用一个长度为 n 的数组 diff 表示，
 * 其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。
 * <p>
 * 返回 nums 的 不同元素数目差 数组。
 * <p>
 * 注意 nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组（包含下标 i 和 j 对应元素）。
 * 特别需要说明的是，如果 i > j ，则 nums[i, ..., j] 表示一个空子数组。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4,5]
 * 输出：[-3,-1,1,3,5]
 * 解释：
 * 对于 i = 0，前缀中有 1 个不同的元素，而在后缀中有 4 个不同的元素。因此，diff[0] = 1 - 4 = -3 。
 * 对于 i = 1，前缀中有 2 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[1] = 2 - 3 = -1 。
 * 对于 i = 2，前缀中有 3 个不同的元素，而在后缀中有 2 个不同的元素。因此，diff[2] = 3 - 2 = 1 。
 * 对于 i = 3，前缀中有 4 个不同的元素，而在后缀中有 1 个不同的元素。因此，diff[3] = 4 - 1 = 3 。
 * 对于 i = 4，前缀中有 5 个不同的元素，而在后缀中有 0 个不同的元素。因此，diff[4] = 5 - 0 = 5 。
 * <p>
 *
 * 示例 2：
 * 输入：nums = [3,2,3,4,2]
 * 输出：[-2,-1,0,2,3]
 * 解释：
 * 对于 i = 0，前缀中有 1 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[0] = 1 - 3 = -2 。
 * 对于 i = 1，前缀中有 2 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[1] = 2 - 3 = -1 。
 * 对于 i = 2，前缀中有 2 个不同的元素，而在后缀中有 2 个不同的元素。因此，diff[2] = 2 - 2 = 0 。
 * 对于 i = 3，前缀中有 3 个不同的元素，而在后缀中有 1 个不同的元素。因此，diff[3] = 3 - 1 = 2 。
 * 对于 i = 4，前缀中有 3 个不同的元素，而在后缀中有 0 个不同的元素。因此，diff[4] = 3 - 0 = 3 。
 * <p>
 *
 * 提示：
 * 1 <= n == nums.length <= 50
 * 1 <= nums[i] <= 50
 *
 * @author henengqiang
 * @date 2024/1/31
 * @see <a href="https://leetcode.cn/problems/find-the-distinct-difference-array/?envType=daily-question&envId=2024-01-31">链接</a>
 */
public class DistinctDifferenceArray {

    public static void main(String[] args) {
        DistinctDifferenceArray d = new DistinctDifferenceArray();
        System.out.println(Arrays.toString(d.distinctDifferenceArray2(new int[]{3, 2, 3, 4, 2})));
        System.out.println(Arrays.toString(d.distinctDifferenceArray2(new int[]{1, 2, 3, 4, 5})));
    }

    public int[] distinctDifferenceArray(int[] nums) {
        // 7ms
        int len = nums.length, k = 0;
        int[] ans = new int[len];
        Set<Integer> ahead = new HashSet<>();
        Map<Integer, Integer> behind = new HashMap<>();
        for (int num : nums) {
            behind.merge(num, 1, Integer::sum);
        }
        for (int num : nums) {
            ahead.add(num);
            int n = behind.get(num) - 1;
            if (n > 0) {
                behind.put(num, n);
            } else {
                behind.remove(num);
            }
            ans[k++] = ahead.size() - behind.size();
        }
        return ans;
    }

    /**
     * 既然正向遍历可求不同个数，那么逆向遍历也可求不同元素个数
     */
    public int[] distinctDifferenceArray2(int[] nums) {
        // 5ms
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] sufCnt = new int[n + 1];
        for (int i = n - 1; i > 0; i--) {
            set.add(nums[i]);
            sufCnt[i] = set.size();
        }
        int[] res = new int[n];
        set.clear();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            res[i] = set.size() - sufCnt[i + 1];
        }
        return res;
    }

}
