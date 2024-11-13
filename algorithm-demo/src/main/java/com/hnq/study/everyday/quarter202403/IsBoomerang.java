package com.hnq.study.everyday.quarter202403;

/**
 * @author henengqiang
 * @date 2024/11/13
 * @see <a href="https://leetcode.cn/problems/valid-boomerang/">链接</a>
 */
public class IsBoomerang {

    public static void main(String[] args) {
        IsBoomerang i = new IsBoomerang();
        System.out.println(i.isBoomerang2(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println(i.isBoomerang2(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(i.isBoomerang2(new int[][]{{0, 2}, {2, 1}, {0, 0}}));
    }

    /**
     * 假设3个点坐标(x1,y1),(x2,y2),(x3,y3)，不在一条直线，只要斜率不一样即可。
     * (y2 - y1) / (x2 -x1) != (y3 - y1) / (x3 - x1) 除法存在精度问题，
     * 换算成乘法 (y2 - y1) * (x3 - x1) != (y3 - y1) * (x2 - x1)
     */
    public boolean isBoomerang(int[][] points) {
        // 0ms
        int a = (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]);
        int b = (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
        return a != b;
    }

    /**
     * 计算从 points[0] 开始，分别指向 points[1] 和 points[2] 的向量 v1 和 v2
     * 「三点各不相同且不在一条直线上」等价于「这两个向量的叉乘结果不为零」： v1 * v2 != 0
     */
    public boolean isBoomerang2(int[][] points) {
        // 0ms
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

}
