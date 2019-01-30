package com.hnq.study.classicquestions;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

/**
 * Given an array of integers, find two numbers that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 *
 * For example:
 *  Input numbers = {2, 7, 11, 15}, target = 9
 *  Output: index1 = 0, index2 = 1
 *
 * @author henengqiang
 * @date 2019/01/30
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[10];
        int bound = 20;
        generateRandomIntegers(nums, bound);
        int target = Math.max(bound / 2, new Random().nextInt(bound));

        int[] result = twoSum(nums, target);
        System.out.println(String.format("nums=%s, target=%d, result=%s", Arrays.toString(nums), target, Arrays.toString(result)));
    }

    /**
     * Solution
     * The optional solution to solve this problem is using a HashMap. For each element of the array, (target - nums[i])
     * and the index are stored in the HashMap.
     *
     * @param nums      Given array of integers
     * @param target    Given specific target number
     * @return          index
     */
    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {0, 0};
        }

        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return new int[] {map.get(num), i};
            } else {
                map.put(target - num, i);
            }
        }
        return new int[] {0, 0};
    }

    // ------------------------------------------------

    static void generateRandomIntegers(int[] nums, int bound) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(bound);
        }
    }

}
