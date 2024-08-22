package com.hnq.study.everyday.quarter202403;

import java.util.HashMap;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2024/8/22
 */
public class RepeatedNTimes {

    public static void main(String[] args) {
        RepeatedNTimes r = new RepeatedNTimes();
        int[] a = {1, 2, 3, 3};
        System.out.println(r.repeatedNTimes(a));
        int[] b = {2, 1, 2, 5, 3, 2};
        System.out.println(r.repeatedNTimes(b));
        int[] c = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(r.repeatedNTimes(c));
    }

    /**
     * 可以用hash表而不是map
     */
    public int repeatedNTimes(int[] nums) {
        // 1ms
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2 * 4 / 3);
        for (int num : nums) {
            int t = map.merge(num, 1, Integer::sum);
            if (t > 1) {
                return num;
            }
        }
        return 0;
    }

}
