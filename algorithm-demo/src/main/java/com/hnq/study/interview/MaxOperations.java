package com.hnq.study.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author henengqiang
 * @since 2026/3/13
 * @see <a href="https://leetcode.cn/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75">K 和数对的最大数目</a>
 */
public class MaxOperations {

    public static void main(String[] args) {
        MaxOperations m = new MaxOperations();
        System.out.println(m.maxOperations2(new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2}, 3));
        System.out.println(m.maxOperations2(new int[]{1, 2, 3, 4}, 5));
        System.out.println(m.maxOperations2(new int[]{3, 1, 3, 4, 3}, 6));
    }

    public int maxOperations(int[] nums, int k) {
        // 22ms
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                left++;
                right--;
                count++;
            } else if (nums[left] + nums[right] < k) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public int maxOperations2(int[] nums, int k) {
        // 32ms
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (num >= k) {
                continue;
            }
            if (map.containsKey(k - num)) {
                map.compute(k - num, (key, value) -> value - 1);
                if (map.get(k - num) == 0) {
                    map.remove(k - num);
                }
                count++;
            } else {
                map.compute(num, (key, value) -> value == null ? 1 : value + 1);
            }
        }
        return count;
    }

}
