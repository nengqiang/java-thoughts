package com.hnq.study.everyday.quarter202403;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2024/10/23
 */
public class LargestSumAfterKNegations {

    public static void main(String[] args) {
        LargestSumAfterKNegations l = new LargestSumAfterKNegations();
        System.out.println(l.largestSumAfterKNegations(new int[]{5, 6, 9, -3, 3}, 2));
        System.out.println(l.largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6));
        System.out.println(l.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(l.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(l.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 3ms
        Arrays.sort(nums);
        int i = 0, len = nums.length;
        while (i < len - 1 && nums[i] < 0 && k > 0) {
            nums[i] = -nums[i];
            i++;
            k--;
        }
        if (i > 0) {
            i--;
        }
        if (k > 0) {
            if (i >= len - 1 || i <= len - 2 && nums[i] <= nums[i + 1]) {
                while (k > 0) {
                    nums[i] = -nums[i];
                    k--;
                }
            } else if (i <= len - 2 && nums[i + 1] < nums[i]) {
                while (k > 0) {
                    nums[i + 1] = -nums[i + 1];
                    k--;
                }
            }
        }
        return Arrays.stream(nums).sum();
    }

    /**
     * 数组元素的范围为 [−100,100]，可以使用计数数组（桶）或者哈希表，
     * 直接统计每个元素出现的次数，再升序遍历元素的范围，省去排序需要的时间。
     */
    public int largestSumAfterKNegations2(int[] nums, int k) {
        // 6ms
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = Arrays.stream(nums).sum();
        for (int i = -100; i < 0; ++i) {
            if (freq.containsKey(i)) {
                int ops = Math.min(k, freq.get(i));
                ans += (-i) * ops * 2;
                freq.put(i, freq.get(i) - ops);
                freq.put(-i, freq.getOrDefault(-i, 0) + ops);
                k -= ops;
                if (k == 0) {
                    break;
                }
            }
        }
        if (k > 0 && k % 2 == 1 && !freq.containsKey(0)) {
            for (int i = 1; i <= 100; ++i) {
                if (freq.containsKey(i)) {
                    ans -= i * 2;
                    break;
                }
            }
        }
        return ans;
    }


}
