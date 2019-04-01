package com.hnq.study.utils;

import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Random;

/**
 * @author henengqiang
 * @date 2019/02/26
 */
public class GenerateMethods {

    public static int[] generateUnDuplicatedRandomNumbersWithBound(int size, int bound) {
        int[] result = new int[size];
        Random r = new Random();
        int j = 0;
        for (int i = 0; i < size; i++) {
            result[i] = r.nextInt(bound);
            while (j < i) {
                for (j = 0; j < i; j++) {
                    if (result[i] == result[j]) {
                        result[i] = r.nextInt(bound);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static int[] generateRandomNumbersWithBound(int size, int bound) {
        int[] result = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = r.nextInt(bound);
        }
        return result;
    }

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
