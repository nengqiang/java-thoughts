package com.hnq.study.classicquestions;

/**
 * Write an efficient algorithm that searches for a value in an m * n matrix. This matrix has properties:
 * 1) Integers in each row are sorted from left to right.
 * 2) The first integer of each row is greater than the last integer of the previous row.
 *
 * For example, consider the following matrix:
 *
 * [
 *  [1, 3, 5, 7]
 *  [10, 11, 16, 20]
 *  [23, 30, 34, 50]
 * ]
 *
 * Given target 3, return true.
 *
 * @author henengqiang
 * @date 2019/04/16
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 10},
                {2, 4, 6, 8},
                {3, 5, 7, 9}
        };
        System.out.println(searchTheMatrix(matrix, 10));
    }

    /*
     * This is a typical problem of binary search.
     *
     * You may try to solve this problem by finding the rwo first and then the column. There is no need to do that.
     * Because of the matrix's special features, the matrix can be considered as a sorted array. The goal is to find
     * the element in this sorted array by using binary search.
     */

    private static boolean searchTheMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midX = mid / n;
            int midY = mid % n;

            if (matrix[midX][midY] == target) {
                return true;
            }

            if (matrix[midX][midY] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    /*
     * tips: It has a bug if the target number is larger than pivot; however, it is at left-hand side of flattened array.
     */


}
