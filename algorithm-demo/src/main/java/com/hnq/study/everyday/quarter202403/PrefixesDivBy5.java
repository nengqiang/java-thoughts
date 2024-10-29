package com.hnq.study.everyday.quarter202403;

import java.util.ArrayList;
import java.util.List;

/**
 * @author henengqiang
 * @date 2024/10/29
 */
public class PrefixesDivBy5 {

    public static void main(String[] args) {
        PrefixesDivBy5 p = new PrefixesDivBy5();
        System.out.println(p.prefixesDivBy5(new int[]{1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1,
                1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0,
                0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0}));
        System.out.println(p.prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,
                0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}));
        System.out.println(p.prefixesDivBy5(new int[]{0, 1, 1}));
        System.out.println(p.prefixesDivBy5(new int[]{1, 1, 1}));
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        // 超时
        List<Boolean> ans = new ArrayList<>();
        int remainder = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                int bit = nums[j];
                remainder = (remainder * 2 + bit) % 5;
            }
            ans.add(remainder == 0);
            remainder = 0;
        }
        return ans;
    }

    public List<Boolean> prefixesDivBy5_2(int[] nums) {
        // 3ms
        List<Boolean> ans = new ArrayList<>();
        int prefix = 0;
        for (int num : nums) {
            prefix = ((prefix << 1) + num) % 5;
            ans.add(prefix == 0);
        }
        return ans;
    }

}
