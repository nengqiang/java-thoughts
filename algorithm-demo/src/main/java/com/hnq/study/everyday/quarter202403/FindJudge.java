package com.hnq.study.everyday.quarter202403;

import java.util.HashMap;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2024/10/17
 */
public class FindJudge {

    public static void main(String[] args) {
        FindJudge f = new FindJudge();
        System.out.println(f.findJudge2(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
        System.out.println(f.findJudge2(2, new int[][]{{1, 2}}));
        System.out.println(f.findJudge2(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(f.findJudge2(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }

    public int findJudge(int n, int[][] trust) {
        // 19ms
        if (trust.length == 0) {
            return n < 2 ? 1 : -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : trust) {
            map.merge(t[0], -1, Integer::sum);
            map.merge(t[1], 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == n - 1) {
                return e.getKey();
            }
        }
        return -1;
    }

    /**
     * 入度和出度（图）
     */
    public int findJudge2(int n, int[][] trust) {
        // 2ms
        int[] in = new int[n + 1], out = new int[n + 1];
        for (int[] edge : trust) {
            int x = edge[0], y = edge[1];
            ++in[y];
            ++out[x];
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }

        }
        return -1;
    }

}
