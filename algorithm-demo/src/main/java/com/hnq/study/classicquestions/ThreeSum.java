package com.hnq.study.classicquestions;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

import static com.hnq.study.utils.GenUtils.genArrWithPositiveOrNegative;

/**
 * Problem:
 *  Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique
 *  triplets in the array which gives the sum of zero.
 *
 * Note:
 *  Elements in a triplet(a, b, c) must be in non-descending order.(ie, a <= b <= c)
 *  The solution set must not contain duplicate triplets.
 *
 * For example, given array s = {-1 0 1 2 -1 -4},
 * A solution set is:
 *  {-1, 0, 1}
 *  {-1, -1, 2}
 *
 * @author henengqiang
 * @date 2019/01/31
 */
public class ThreeSum {

    public static void main(String[] args) {
        int size = 6;
        int bound = 5;
        int[] param = genArrWithPositiveOrNegative(size, bound);
        List<List<Integer>> result = threeSum(param);
        System.out.println("The original array: " + Arrays.toString(param));
        System.out.println("The solution set: " + result);
    }

    /**
     * Solution
     * This problem can be solved by using two pointers. Time complexity is O(n^2)
     *
     * To avoid duplicate, we can take advantage of sorted arrays, i.e., move pointers by >1 to use same element
     * only once.
     *
     * @param nums  Given array
     * @return      Solution set
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i-1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Lists.newArrayList();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        result.add(tmp);

                        j++;
                        k--;

                        // handle duplicate here
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }

}
