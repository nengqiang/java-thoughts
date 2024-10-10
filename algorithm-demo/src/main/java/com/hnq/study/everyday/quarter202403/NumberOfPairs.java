package com.hnq.study.everyday.quarter202403;

import java.util.HashMap;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2024/10/10
 */
public class NumberOfPairs {

    public static void main(String[] args) {
        NumberOfPairs n = new NumberOfPairs();
        System.out.println(n.numberOfPairs2(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        System.out.println(n.numberOfPairs2(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        // 1ms
        int count = 0;
        for (int val1 : nums1) {
            for (int val2 : nums2) {
                if (val1 % (val2 * k) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 枚举倍数
     */
    public int numberOfPairs2(int[] nums1, int[] nums2, int k) {
        // 3ms
        Map<Integer, Integer> count = new HashMap<>(), count2 = new HashMap<>();
        int max1 = 0;
        for (int i : nums1) {
            count.put(i, count.getOrDefault(i, 0) + 1);
            max1 = Math.max(max1, i);
        }
        for (int i : nums2) {
            count2.put(i, count2.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Integer a : count2.keySet()) {
            for (int b = a * k; b <= max1; b += a * k) {
                if (count.containsKey(b)) {
                    res += count.get(b) * count2.get(a);
                }
            }
        }
        return res;
    }

}
