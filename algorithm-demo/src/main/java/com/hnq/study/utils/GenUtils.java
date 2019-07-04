package com.hnq.study.utils;

import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Random;

/**
 * @author henengqiang
 * @date 2019/02/26
 */
public class GenUtils {

    private static final Random R = new Random();

    /**
     * Generate random array.（do not duplicated）
     *
     * @param size  array size
     * @param bound array bound
     * @return      array
     */
    public static int[] genNotRepeatingArr(int size, int bound) {
        int[] nums = new int[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            nums[i] = R.nextInt(bound);
            while (j < i) {
                for (j = 0; j < i; j++) {
                    if (nums[i] == nums[j]) {
                        nums[i] = R.nextInt(bound);
                        break;
                    }
                }
            }
        }
        return nums;
    }

    /**
     * Generate random array.（may be duplicate）
     *
     * @param size  array size
     * @param bound array bound
     * @return      array
     */
    public static int[] generateArray(int size, int bound) {
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = R.nextInt(bound);
        }
        return nums;
    }

    public static int[] genArrWithPositiveOrNegative(int size, int bound) {
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = bound - R.nextInt(bound * 2);
        }
        return nums;
    }

    public static List<Integer> genListWithPOrN(int size, int bound) {
        return Ints.asList(genArrWithPositiveOrNegative(size, bound));
    }

}
