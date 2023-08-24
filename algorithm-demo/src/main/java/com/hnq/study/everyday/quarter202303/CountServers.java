package com.hnq.study.everyday.quarter202303;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * <p>
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * <p>
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * <p>
 *
 *
 * 示例 1：
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * <p>
 *
 * 示例 2：
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * <p>
 *
 * 示例 3：
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 * <p>
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 *
 * @author henengqiang
 * @date 2023/8/24
 * @see <a href="https://leetcode.cn/problems/count-servers-that-communicate/">链接</a>
 */
public class CountServers {

    public static void main(String[] args) {
        CountServers c = new CountServers();
        System.out.println(c.countServers(new int[][]{{1, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(c.countServers(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(c.countServers(new int[][]{{1, 0}, {1, 1}}));
        System.out.println(c.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
    }

    /**
     * 第一次遍历记录各行的服务器数rows 和 各列的服务器数cols
     * 第二次遍历每个服务器去判断当前行列的 rows > 1 || cols > 1 即可
     */
    public int countServers(int[][] grid) {
        // 2ms
        int r = grid.length, c = grid[0].length;
        int[] rows = new int[r], cols = new int[c];
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                int x = ints[j];
                rows[i] += x;
                cols[j] += x;
            }
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                int x = ints[j];
                if (x == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
