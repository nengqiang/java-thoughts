package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/6/8
 * @see <a href="https://leetcode.cn/problems/number-of-provinces/?envType=study-plan-v2&envId=leetcode-75>省份数量</a>
 */
public class FindCircleNum {

    public static void main(String[] args) {
        FindCircleNum c = new FindCircleNum();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(c.findCircleNum(isConnected));
    }

    /**
     * 并查集
     */
    public int findCircleNum(int[][] isConnected) {
        // 1ms
        int cities = isConnected.length;
        int[] parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}