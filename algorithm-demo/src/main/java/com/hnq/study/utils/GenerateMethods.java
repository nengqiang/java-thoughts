package com.hnq.study.utils;

import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Random;

/**
 * @author henengqiang
 * @date 2019/02/26
 */
public class GenerateMethods {

    public static int[] generatePositiveOrNegativeRandomNumbersWithBound(int size, int bound) {
        int[] result = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = bound - r.nextInt(bound * 2);
        }
        return result;
    }

    public static List<Integer> generatePositiveOrNegativeRandomNumbersArrayWithBound(int size, int bound) {
        return Ints.asList(generatePositiveOrNegativeRandomNumbersWithBound(size, bound));
    }

}
