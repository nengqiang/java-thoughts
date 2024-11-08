package com.hnq.study.everyday.quarter202403;

import java.util.Arrays;

/**
 * @author henengqiang
 * @date 2024/11/8
 * @see <a href="https://leetcode.cn/problems/matrix-cells-in-distance-order/">链接</a>
 */
public class AllCellsDistOrder {

    public static void main(String[] args) {
        AllCellsDistOrder a = new AllCellsDistOrder();
        System.out.println(Arrays.deepToString(a.allCellsDistOrder(1, 2, 0, 0)));
        System.out.println(Arrays.deepToString(a.allCellsDistOrder(2, 2, 0, 1)));
        System.out.println(Arrays.deepToString(a.allCellsDistOrder(2, 3, 1, 2)));
    }

    /**
     * 曼哈顿遍历
     */
    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};

    /**
     * 几何法，曼哈顿遍历
     */
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        // 4ms
        int maxDist = Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter);
        int[][] ret = new int[rows * cols][];
        int row = rCenter, col = cCenter;
        int index = 0;
        ret[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != rCenter) || (i % 2 != 0 && col != cCenter)) {
                    if (row >= 0 && row < rows && col >= 0 && col < cols) {
                        ret[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return ret;
    }

}
