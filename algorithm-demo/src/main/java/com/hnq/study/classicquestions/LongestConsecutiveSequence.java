package com.hnq.study.classicquestions;

import com.google.common.collect.Sets;
import com.hnq.study.utils.GenUtils;

import java.util.Arrays;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be
 * [1, 2, 3, 4]. Its length is 4.
 *
 * The algorithm should run in O(n) complexity.
 *
 * @author henengqiang
 * @date 2019/03/12
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = GenUtils.genNotRepeatingArr(10, 50);
        System.out.println(getLongestConsecutive(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Solution 1
     *
     * Because it requires O(n) complexity, we can not solve the problem by sorting the array first. Sorting takes
     * at least O(nlogn) time.
     *
     * We can use a HashSet to add and remove elements. HashSet is implemented by using a hash table.
     * Elements are not ordered. The add, remove and contains methods have constant time complexity O(1).
     *
     * @param nums  given array of integers
     * @return      longest consecutive element sequence
     */
    private static int getLongestConsecutive(int[] nums) {
        // if array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = Sets.newHashSet();
        int max = 1;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            int count = 1;
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    /*
     * Solution 2
     *
     * We can also project the arrays to a new array with length to be the largest element in the array.
     * Then iterate over the array and get the longest consecutive sequence. If the largest number is very large,
     * then the time complexity would be bad.
     */

}
