package com.hnq.study.classicquestions;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Data structure design.
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * For example,
 * add(1);
 * add(3);
 * add(5);
 * find(4) -> true
 * find(7) -> false
 *
 * @author henengqiang
 * @date 2019/01/30
 */
public class TwoSum3 {

    public static void main(String[] args) {
        add(1);
        add(3);
        add(5);
        System.out.println(find(4));
        System.out.println(find(7));
    }

    /*
     * Since the desired class need add and get operations, HashMap is a good option for this purpose.
     */

    private static HashMap<Integer, Integer> elements = Maps.newHashMap();

    private static void add(int number) {
        if (elements.containsKey(number)) {
            elements.put(number, elements.get(number) + 1);
        } else {
            elements.put(number, 1);
        }
    }

    private static boolean find(int value) {
        for (Integer integer : elements.keySet()) {
            int target = value - 1;
            if (elements.containsKey(target)) {
                if (integer == target && elements.get(target) < 2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

}
