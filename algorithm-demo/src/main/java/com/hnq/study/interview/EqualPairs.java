package com.hnq.study.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author henengqiang
 * @since 2026/3/27
 * @see <a href="https://leetcode.cn/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75">相等的行和列</a>
 */
public class EqualPairs {

    public static void main(String[] args) {
        EqualPairs e = new EqualPairs();
        int[][] g0 = new int[][]{{13, 13}, {13, 13}};
        System.out.println(e.equalPairs(g0));

        int[][] g = new int[][]{{3, 1, 2, 2}, {1, 4, 4, 4}, {2, 4, 2, 2}, {2, 5, 2, 2}};
        System.out.println(e.equalPairs(g));

        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(e.equalPairs(grid));
        grid = new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(e.equalPairs(grid));
        grid = new int[][]{{3, 1}, {1, 3}};
        System.out.println(e.equalPairs(grid));
    }

    public int equalPairs(int[][] grid) {
        // 17ms
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<>(n * 4 / 3);
        for (int[] ints : grid) {
            List<Integer> row = new ArrayList<>(n);
            for (int anInt : ints) {
                row.add(anInt);
            }
            cnt.put(row, cnt.getOrDefault(row, 0) + 1);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                arr.add(grid[j][i]);
            }
            res += cnt.getOrDefault(arr, 0);
        }
        return res;
    }

}
