package com.hnq.study.everyday.quarter202401;

/**
 * 托普利茨矩阵
 * <p>
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * <p>
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * <p>
 *
 * 示例 2：
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 * <p>
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 * <p>
 *
 * 进阶：
 * 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 *
 * @author henengqiang
 * @date 2024/1/4
 * @see <a href="https://leetcode.cn/problems/toeplitz-matrix/">链接</a>
 */
public class IsToeplitzMatrix {

    public static void main(String[] args) {
        IsToeplitzMatrix i = new IsToeplitzMatrix();
        int[][] i1 = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(i.isToeplitzMatrix2(i1));

        int[][] i2 = new int[][]{{1, 2}, {2, 2}};
        System.out.println(i.isToeplitzMatrix2(i2));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        // 0ms
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int p = 1, q = i + 1, x = matrix[0][i];
            while (p < m && q < n) {
                if (matrix[p++][q++] != x) {
                    return false;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int p = i + 1, q = 1, x = matrix[i][0];
            while (p < m && q < n) {
                if (matrix[p++][q++] != x) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 根据定义，当且仅当矩阵中每个元素都与其左上角相邻的元素（如果存在）相等时，该矩阵为托普利茨矩阵。
     * 因此，我们遍历该矩阵，将每一个元素和它左上角的元素相比对即可。
     */
    public boolean isToeplitzMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

}
