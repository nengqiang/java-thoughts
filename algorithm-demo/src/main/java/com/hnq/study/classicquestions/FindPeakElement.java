package com.hnq.study.classicquestions;

import com.hnq.study.utils.GenUtils;

import java.util.Arrays;

/**
 * A peak element is an element that grater than its neighbors. Given an input array where num[i] ≠ num[i+1],
 * find a peak element and return its index. The array may contain multiple peaks, in that case return the index
 * to any one of the peaks is fine.
 *
 * You may imagine that num[-1] =num[n] = -♾. For example, in array [1, 2, 3, 1], 3 is a peak element and your
 * function should return the index number 2.
 *
 * @author henengqiang
 * @date 2019/07/03
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = GenUtils.genNotRepeatingArr(8, 20);
        System.out.println("Original array: " + Arrays.toString(arr));
        int[] result = mySolution(arr);
        System.out.println("These index of arr element is peak: " + Arrays.toString(result));
    }

    /*
     * Thoughts
     * This is a very simple problem. We can scan the array and find any element that is greater than its previous
     * and next. The first and last element are handled separately.
     */

    private static int[] mySolution(int[] arr) {
        int[] temp = new int[arr.length - 2];
        int j = 0;
        for (int i = 1; i <= arr.length - 2; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                temp[j++] = i;
            }
        }
        int[] result = new int[j];
        System.arraycopy(temp, 0, result, 0, result.length);
        return result;
    }

}
