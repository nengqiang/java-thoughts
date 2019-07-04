package com.hnq.study.classicquestions;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.hnq.study.utils.GenUtils.genArrWithPositiveOrNegative;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closet to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. {-1 + 2 + 1 = 2}
 *
 * @author henengqiang
 * @date 2019/01/31
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int size = 6;
        int bound = 5;
        int target = 0;
        int[] param = genArrWithPositiveOrNegative(size, bound);
        Map<Integer, List<Integer>> result = threeSumClosest(param, target);
        System.out.println("The original array: " + Arrays.toString(param));
        System.out.println("The solution set: " + result);
    }

    /*
     * Analysis
     * This problem is similar to two Sum. This kind of problem can be solved by using a similar approach, i.e., two
     * pointers from both left and right.
     */

    /**
     * Solution
     *
     * @param nums      Given array
     * @param target    Given target
     * @return          key: sum of the three closest numbers, value: a list of the three closest numbers
     */
    private static Map<Integer, List<Integer>> threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = Maps.newLinkedHashMap();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if (diff == 0) {
                    map.put(sum, Lists.newArrayList(nums[i], nums[j], nums[k]));
                }

                if (diff < min) {
                    min = diff;
                    map.put(sum, Lists.newArrayList(nums[i], nums[j], nums[k]));
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        removeKeyNotEqualToTarget(map, target);
        return map;
    }

    private static void removeKeyNotEqualToTarget(Map<Integer, List<Integer>> map, Integer target) {
        Iterator<Map.Entry<Integer, List<Integer>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Integer>> entry = it.next();
            Integer key = entry.getKey();
            if (!key.equals(target)) {
                it.remove();
            }
        }
    }

}
