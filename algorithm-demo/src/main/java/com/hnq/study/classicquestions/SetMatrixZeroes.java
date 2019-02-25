package com.hnq.study.classicquestions;

/**
 * Given a m * n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 *
 * @author henengqiang
 * @date 2019/02/25
 */
public class SetMatrixZeroes {

    private static int[][] matrix = {
            {1, 1, 1, 0},
            {1, 1, 1, 0},
            {1, 1, 0, 0},
            {1, 0, 0, 0}
    };

    public static void main(String[] args) {
        System.out.println("The original matrix:");
        for (int[] matrix : matrix) {
            System.out.println(String.format("%d, %d, %d, %d", matrix[0], matrix[1], matrix[2], matrix[3]));
        }

        setZeroes(matrix);

        System.out.println("After setZeroes:");
        for (int[] matrix : matrix) {
            System.out.println(String.format("%d, %d, %d, %d", matrix[0], matrix[1], matrix[2], matrix[3]));
        }
    }

    /*
     * Analysis
     *
     * This problem should be solved in place, i.e., no other array should be used. We can use the first column and
     * the first row to track if a row/column should be set to 0.
     *
     * Since we used the first row and first column to mark the zero row/column, the original values are changed.
     *
     * Specifically, given, the following matrix
     *  1   1   1   0
     *  1   1   1   0
     *  1   1   0   0
     *  1   0   0   0
     *
     *  this problem can be solved by following 4 steps:
     *
     * Step 1:
     * First row contains zero = true;
     * First column contains zero = false;
     *
     * Step 2: use first row and column to mark zero row and column.
     *  1   0   0   0
     *  0   1   1   0
     *  0   1   0   0
     *  0   0   0   0
     *
     * Step 3: set each elements by using marks in first row and column.
     *  1   0   0   0
     *  0   0   0   0
     *  0   0   0   0
     *  0   0   0   0
     *
     * Step 4: set first column and row by using marks in step 1.
     *  0   0   0   0
     *  0   0   0   0
     *  0   0   0   0
     *  0   0   0   0
     */

    /**
     * Solution
     * @param matrix    Given m * n matrix
     */
    private static void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        // set first row and column zero or not
        for (int[] mat : matrix) {
            if (mat[0] == 0) {
                firstColumnZero = true;
                break;
            }
        }

        for (int mat : matrix[0]) {
            if (mat == 0) {
                firstRowZero = true;
                break;
            }
        }

        // mark zeroes on first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set first column and row
        if (firstColumnZero) {
            for (int[] mat : matrix) {
                mat[0] = 0;
            }
        }

        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
