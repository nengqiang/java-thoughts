package com.hnq.study.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author henengqiang
 * @since 2026/3/24
 * @see <a href="https://leetcode.cn/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75">独一无二的出现次数</a>
 */
public class UniqueOccurrences {

    public static void main(String[] args) {
        UniqueOccurrences u = new UniqueOccurrences();
        System.out.println(u.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(u.uniqueOccurrences(new int[]{1, 2}));
        System.out.println(u.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        // 3ms
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer integer : map.values()) {
            if (set.contains(integer)) {
                return false;
            }
            set.add(integer);
        }
        return true;
    }

}
