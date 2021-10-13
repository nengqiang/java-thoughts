package com.hnq.study.everyday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，
 * 使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 不超过 k。
 *
 * 示例1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @author henengqiang
 * @date 2021/10/13
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate-ii">链接</a>
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate2(a, 3));
        int[] b = new int[] {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate2(b, 1));
        int[] c = new int[] {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate2(c, 2));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        // 12ms
        Map<Integer, Integer> valToIndex = new HashMap<>(nums.length * 4 / 3);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (valToIndex.containsKey(num)) {
                int d = Math.abs(i - valToIndex.get(num));
                if (d <= k) {
                    return true;
                }
            }
            valToIndex.put(num, i);
        }
        return false;
    }

    /**
     * 滑动窗口思想
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
