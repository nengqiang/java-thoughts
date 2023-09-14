package com.hnq.study.everyday.quarter202303;

import java.util.Arrays;

/**
 * 重塑矩阵
 * <p>
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 *
 * 示例 1：
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * <p>
 *
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * <p>
 *
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 *
 * @author henengqiang
 * @date 2023/9/14
 */
public class MatrixReshape {

    public static void main(String[] args) {
        MatrixReshape m = new MatrixReshape();
        int[][] a = new int[][]{{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(m.matrixReshape2(a, 1, 4)));

        System.out.println(Arrays.deepToString(m.matrixReshape2(a, 2, 4)));
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // 0ms
        int m = mat.length, n = mat[0].length, p = 0, q = 0;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            int[] a = new int[c];
            for (int j = 0; j < c; j++) {
                a[j] = mat[p][q];
                if (q < n - 1) {
                    q++;
                } else {
                    q = 0;
                    p++;
                }
            }
            res[i] = a;
        }
        return res;
    }

    /**
     * 否则，对于 x 属于 [0,mn)，第 x 个元素在 mat 中对应的下标为 (x / n, x % n)，
     * 而在新的重塑矩阵中对应的下标为(x / c, x % c)。直接进行赋值即可。
     */
    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < m * n; ++i) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        return res;
    }

}
