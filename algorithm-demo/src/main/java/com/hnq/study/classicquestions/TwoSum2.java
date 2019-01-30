package com.hnq.study.classicquestions;

import java.util.Arrays;
import java.util.Random;

import static com.hnq.study.classicquestions.TwoSum.generateRandomIntegers;

/**
 * Input array is sorted.
 *
 * This problem is similar to two sum.
 *
 * @author henengqiang
 * @date 2019/01/30
 */
public class TwoSum2 {

    public static void main(String[] args) {
        int[] nums = new int[10];
        int bound = 20;
        generateRandomIntegers(nums, bound);
        Arrays.sort(nums);
        int target = Math.max(bound / 2, new Random().nextInt(bound));

        int[] result = twoSum(nums, target);
        System.out.println(String.format("nums=%s, target=%d, result=%s", Arrays.toString(nums), target, Arrays.toString(result)));
    }

    /**
     * Solution
     * To solve this problem, we can use two points to scan the array from both sides. See solution below:
     *
     * @param nums      Given array of integers
     * @param target    Given specific target number
     * @return          index
     */
    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int x = nums[i] + nums[j];
            if (x < target) {
                i++;
            } else if (x > target) {
                j--;
            } else {
                return new int[] {i, j};
            }
        }
        return null;
    }

}
