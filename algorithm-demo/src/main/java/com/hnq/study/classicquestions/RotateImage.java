package com.hnq.study.classicquestions;

import java.util.Arrays;

/**
 * Given an n * n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 *  Do this in-place?
 *
 * @author henengqiang
 * @date 2019/04/23
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Origin matrix:");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        rotate(matrix);
        System.out.println("Matrix after rotate:");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * In-place Solution
     *
     * By using the relation "matrix[i][j] = matrix[n-1-j][i]", we can loop through the matrix.
     *
     * @param matrix    Given matrix representing an image.
     */
    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil((double) n / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

}
