package com.hnq.study.classicquestions;

import java.util.Arrays;
import java.util.Random;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note:
 *  You may assume that A has enough space to hold additional elements from B. The number of elements
 *  initialized in A and B are m and n respectively.
 *
 * @author henengqiang
 * @date 2019/01/31
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int arrASize = 10;
        int arrBSize = 5;
        int initialASize = 5;
        int initialBSize = 5;
        int bound = 10;
        int[] arrA = initializeArrayWithGivenSize(arrASize, initialASize, bound);
        int[] arrB = initializeArrayWithGivenSize(arrBSize, initialBSize, bound);
        System.out.println(String.format("The original two arrays: A=%s, B=%s", Arrays.toString(arrA), Arrays.toString(arrB)));
        merge1(arrA, initialASize, arrB, initialBSize);
        System.out.println(String.format("Merge B into A as one array by methodA: arrMerged=%s", Arrays.toString(arrA)));

        arrA = initializeArrayWithGivenSize(arrASize, initialASize, bound);
        arrB = initializeArrayWithGivenSize(arrBSize, initialBSize, bound);
        System.out.println(String.format("The original two arrays: A=%s, B=%s", Arrays.toString(arrA), Arrays.toString(arrB)));
        merge1(arrA, initialASize, arrB, initialBSize);
        System.out.println(String.format("Merge B into A as one array by methodB: arrMerged=%s", Arrays.toString(arrA)));
    }

    /*
     * Analysis
     * The key to solve this problem is moving element of A and B backwards. If B has some elements left after A is
     * done, also need to handle that case.
     *
     * The takeaway message from this problem is that the loop condition. This kind of condition is also used for
     * merging two sorted linked list.
     */

    /**
     * Solution 1
     *
     * @param arrA  Given sorted array A
     * @param m     Initialized in array A
     * @param arrB  Given sorted array B
     * @param n     Initialized in array B
     */
    private static void merge1(int[] arrA, int m, int[] arrB, int n) {
        while (m > 0 && n > 0) {
            if (arrA[m - 1] > arrB[n - 1]) {
                arrA[m + n - 1] = arrA[m - 1];
                m--;
            } else {
                arrA[m + n - 1] = arrB[n - 1];
                n--;
            }
        }

        while (n > 0) {
            arrA[m + n - 1] = arrB[n - 1];
            n--;
        }
    }

    /**
     * Solution 2
     * The loop condition also can use m + n like the following.
     *
     * @param arrA  Given sorted array A
     * @param m     Initialized in array A
     * @param arrB  Given sorted array B
     * @param n     Initialized in array B
     */
    private static void merge2(int[] arrA, int m, int[] arrB, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (k >= 0) {
            if (j < 0 || (i >= 0 && arrA[i] > arrB[j])) {
                arrA[k--] = arrA[i--];
            } else {
                arrA[k--] = arrB[j--];
            }
        }
    }

    // ----------------------------------------------------------------------------------------

    private static int[] initializeArrayWithGivenSize(int arrSize, int initialSize, int bound) {
        int[] arr = new int[arrSize];
        Random r = new Random();
        for (int i = 0; i < initialSize; i++) {
            arr[i] = bound - r.nextInt(bound * 2);
        }
        Arrays.sort(arr);
        return arr;
    }

}
