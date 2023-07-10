package com.hnq.study.everyday.quarter202303;

/**
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * <p>
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿
 * （或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
 * 网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 *
 * 示例 1：
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * [0,1,0,0]
 * [1,1,1,0]
 * [0,1,0,0]
 * [1,1,0,0]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * <p>
 *
 * 示例 2：
 * 输入：grid = [[1]]
 * 输出：4
 * <p>
 *
 * 示例 3：
 * 输入：grid = [[1,0]]
 * 输出：4
 * <p>
 *
 * 提示：
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] 为 0 或 1
 * 
 * @author henengqiang
 * @date 2023/7/6
 * @see <a href="https://leetcode.cn/problems/island-perimeter">链接</a>
 */
public class IslandPerimeter {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        IslandPerimeter i = new IslandPerimeter();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(i.islandPerimeter2(grid));
    }

    /**
     * 方法一：迭代
     * 思路与算法
     *
     * 对于一个陆地格子的每条边，它被算作岛屿的周长当且仅当这条边为网格的边界或者相邻的另一个格子为水域。
     * 因此，我们可以遍历每个陆地格子，看其四个方向是否为边界或者水域，如果是，将这条边的贡献（即 1）加入答案 ans 中即可。
     */
    public int islandPerimeter(int[][] grid) {
        // 6ms
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }

    /**
     * 方法二：深度优先搜索
     * 思路与算法
     *
     * 我们也可以将方法一改成深度优先搜索遍历的方式，此时遍历的方式可扩展至统计多个岛屿各自的周长。
     * 需要注意的是为了防止陆地格子在深度优先搜索中被重复遍历导致死循环，我们需要将遍历过的陆地格子标记为已经遍历过，
     * 下面的代码中我们设定值为 2 的格子为已经遍历过的陆地格子。
     */
    public int islandPerimeter2(int[][] grid) {
        // 10ms
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }

}
