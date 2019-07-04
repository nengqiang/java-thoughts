package com.hnq.study.classicquestions;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

import static com.hnq.study.utils.GenUtils.genArrWithPositiveOrNegative;

/**
 * Problem:
 *  Given an array S of n integers, are there elements a, b, c and d in S such that a + b + c + d = target?
 *  Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *  Elements in a quadruplet(a, b, c, d) must be in non-descending order. (ie, a <= b <= c <= d)
 *  The solution set must not contain duplicate quadruplets
 *
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 * A solution set is:
 *  {-1, 0, 0, 1}
 *  {-2, -1, 1, 2}
 *  {-2, 0, 0, 2}
 *
 * @author henengqiang
 * @date 2019/01/31
 */
public class FourSum {

    public static void main(String[] args) {
        int size = 6;
        int bound = 5;
        int target = 0;
        int[] param = genArrWithPositiveOrNegative(size, bound);
        List<List<Integer>> result = fourSum(param, target);
        System.out.println("The original array: " + Arrays.toString(param));
        System.out.println("The solution set: " + result);
    }

    /**
     * Solution
     * A typical k-sum problem. Time is N to the power of (k-1).
     *
     * @param nums      Given array
     * @param target    Given target
     * @return          Solution set
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = Lists.newArrayList();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        k++;
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                    } else {
                        List<Integer> tmp = Lists.newArrayList();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[l]);
                        result.add(tmp);

                        k++;
                        l--;

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    }
                }
            }
        }
        return result;
    }

}
