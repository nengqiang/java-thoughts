package com.hnq.study.everyday.quarter202402;

/**
 * 找到冠军 I
 *
 * @author henengqiang
 * @date 2024/4/12
 * @see <a href="https://leetcode.cn/problems/find-champion-i/?envType=daily-question&envId=2024-04-12">链接</a>
 */
public class FindChampion {

    public static void main(String[] args) {
        FindChampion f = new FindChampion();
        System.out.println(f.findChampion(new int[][] {{0, 1}, {0, 0}}));
        System.out.println(f.findChampion(new int[][] {{0, 0, 1}, {1, 0, 1}, {0, 0, 0}}));
    }

    public int findChampion(int[][] grid) {
        // 0ms
        int n = grid.length;
        int champion = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][champion] == 1) {
                champion = i;
            }
        }
        return champion;
    }

}
