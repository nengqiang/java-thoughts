package com.hnq.study.everyday.quarter202403;

import java.util.HashSet;
import java.util.Set;

/**
 * @author henengqiang
 * @date 2024/10/12
 */
public class DuplicateNumbersXOR {

    public static void main(String[] args) {
        DuplicateNumbersXOR d = new DuplicateNumbersXOR();
        System.out.println(d.duplicateNumbersXOR(new int[]{1, 2, 1, 3}));
        System.out.println(d.duplicateNumbersXOR(new int[]{1, 2, 3}));
        System.out.println(d.duplicateNumbersXOR(new int[]{1, 2, 2, 1}));
    }

    public int duplicateNumbersXOR(int[] nums) {
        // 2ms
        Set<Integer> set = new HashSet<>();
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) {
                if (res == Integer.MIN_VALUE) {
                    res = num;
                } else {
                    res ^= num;
                }
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

}
