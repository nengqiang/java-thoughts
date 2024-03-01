package com.hnq.study.everyday.quarter202401;

/**
 * 三维形体的表面积
 * <p>
 * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 * <p>
 * 请你返回最终这些形体的总表面积。
 * <p>
 * 注意：每个形体的底面也需要计入表面积中。
 * <p>
 *
 * 示例 1：
 * 输入：grid = [[1,2],[3,4]]
 * 输出：34
 * <p>
 *
 * 示例 2：
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * <p>
 *
 * 示例 3：
 * 输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * <p>
 *
 * 提示：
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 *
 * @author henengqiang
 * @date 2024/3/1
 * @see <a href="https://leetcode.cn/problems/surface-area-of-3d-shapes/">链接</a>
 */
public class SurfaceArea {

    public static void main(String[] args) {
        SurfaceArea s = new SurfaceArea();
        int[][] g1 = {{1, 2}, {3, 4}};
        System.out.println(s.surfaceArea(g1));
        int[][] g2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(s.surfaceArea(g2));
    }

    public int surfaceArea(int[][] grid) {
        // 3ms
        int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

        int N = grid.length, ans = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                            nv = grid[nr][nc];
                        }

                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }
            }
        }

        return ans;
    }

}
