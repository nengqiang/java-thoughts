package com.hnq.study.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author henengqiang
 * @since 2026/3/23
 * @see <a href="https://leetcode.cn/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75">两个数组的差集</a>
 */
public class FindDifference {

    public static void main(String[] args) {
        FindDifference f = new FindDifference();
        System.out.println(f.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        System.out.println(f.findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // 11ms
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Integer integer : set1) {
            if (!set2.contains(integer)) {
                list1.add(integer);
            }
        }
        for (Integer i : set2) {
            if (!set1.contains(i)) {
                list2.add(i);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }

}
