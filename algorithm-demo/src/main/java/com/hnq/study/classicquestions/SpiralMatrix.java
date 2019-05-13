package com.hnq.study.classicquestions;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 螺旋矩阵
 *
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example, given the following matrix:
 * [
 *  [1, 2, 3],
 *  [4, 5, 6],
 *  [7, 8, 9]
 * ]
 * You should return [1, 2, 3, 6, 9, 8, 7, 4, 5].
 *
 * @author henengqiang
 * @date 2019/04/02
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };
        System.out.println(spiralOrder1(matrix));
        System.out.println(spiralOrder2(matrix));
    }

    /**
     * Solution 1
     * If more than one row and column left, it can from a circle and we process the circle. Otherwise, if only one row
     * or column left, we process that column or row ONLY.
     *
     * @param matrix Given Matrix
     * @return       Spiral order of the given matrix
     */
    private static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = Lists.newArrayList();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = 0;

        while (m > 0 && n > 0) {
            // if one row/column left, no circle can be formed
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }

            // below, process a circle

            // top -> right
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y++]);
            }
            // right -> bottom
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x++][y]);
            }
            // bottom -> left
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y--]);
            }
            // left -> top
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            m -= 2;
            n -= 2;
        }
        return result;
    }

    /*
     * Similarly, we can write the solution this way:
     */

    private static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = Lists.newArrayList();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while (result.size() < m * n) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // prevent duplicate row
            if (bottom < top) {
                break;
            }

            for (int i = right; i >= left ; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            // prevent duplicate column
            if (right < left) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }

}
