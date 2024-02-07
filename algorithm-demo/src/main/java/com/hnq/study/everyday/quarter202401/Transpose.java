package com.hnq.study.everyday.quarter202401;

import java.util.Arrays;

/**
 * 转置矩阵
 * <p>
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * <p>
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 10^5
 * -10^9 <= matrix[i][j] <= 10^9
 *
 * @author henengqiang
 * @date 2024/2/7
 * @see <a href="https://leetcode.cn/problems/transpose-matrix/">链接</a>
 */
public class Transpose {

    public static void main(String[] args) {
        Transpose t = new Transpose();
        int[][] t1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(t.transpose(t1)));

        int[][] t2 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(t.transpose(t2)));
    }

    public int[][] transpose(int[][] matrix) {
        // 0ms
        int rows = matrix.length, cols = matrix[0].length;
        int[][] ans = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

}
