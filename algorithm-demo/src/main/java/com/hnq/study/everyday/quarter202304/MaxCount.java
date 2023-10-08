package com.hnq.study.everyday.quarter202304;

/**
 * 范围求和 II
 * <p>
 * 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi]
 * 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 * <p>
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 * <p>
 *
 * 示例 1:
 * 输入: m = 3, n = 3，ops = [[2,2],[3,3]]
 * 输出: 4
 * 解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * <p>
 *
 * 示例 2:
 * 输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
 * 输出: 4
 * <p>
 *
 * 示例 3:
 * 输入: m = 3, n = 3, ops = []
 * 输出: 9
 * <p>
 *
 * 提示:
 * 1 <= m, n <= 4 * 10^4
 * 0 <= ops.length <= 10^4
 * ops[i].length == 2
 * 1 <= ai <= m
 * 1 <= bi <= n
 *
 * @author henengqiang
 * @date 2023/10/8
 * @see <a href="https://leetcode.cn/problems/range-addition-ii/">链接</a>
 */
public class MaxCount {

    public static void main(String[] args) {
        MaxCount m = new MaxCount();
        int[][] op1 = {{2, 2}, {3, 3}};
        System.out.println(m.maxCount2(3, 3, op1));
    }

    public int maxCount(int m, int n, int[][] ops) {
        int[][] a = new int[m][n];
        for (int[] op : ops) {
            for (int i = 0; i < op[0]; i++) {
                for (int j = 0; j < op[1]; j++) {
                    a[i][j]++;
                }
            }
        }
        int max = a[0][0], count = 0;
        for (int[] ints : a) {
            for (int i : ints) {
                if (i == max) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 维护所有操作的集合
     */
    public int maxCount2(int m, int n, int[][] ops) {
        // 0ms
        int mina = m, minb = n;
        for (int[] op : ops) {
            mina = Math.min(mina, op[0]);
            minb = Math.min(minb, op[1]);
        }
        return mina * minb;
    }

}
