package com.hnq.study.everyday.quarter202401;

/**
 * 最大三角形面积
 * <p>
 * 给你一个由 X-Y 平面上的点组成的数组 points ，其中 points[i] = [xi, yi] 。
 * 从其中取任意三个不同的点组成三角形，返回能组成的最大三角形的面积。与真实值误差在 10^-5 内的答案将会视为正确答案。
 * <p>
 *
 * 示例 1：
 * 输入：points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出：2.00000
 * 解释：输入中的 5 个点如上图所示，红色的三角形面积最大。
 * <p>
 *
 * 示例 2：
 * 输入：points = [[1,0],[0,0],[0,1]]
 * 输出：0.50000
 * <p>
 *
 * 提示：
 * 3 <= points.length <= 50
 * -50 <= xi, yi <= 50
 * 给出的所有点 互不相同
 *
 * @author henengqiang
 * @date 2024/1/19
 * @see <a href="https://leetcode.cn/problems/largest-triangle-area/">链接</a>
 */
public class LargestTriangleArea {

    public static void main(String[] args) {
        LargestTriangleArea l = new LargestTriangleArea();
        int[][] p1 = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(l.largestTriangleArea(p1));

        int[][] p2 = new int[][]{{1, 0}, {0, 0}, {0, 1}};
        System.out.println(l.largestTriangleArea(p2));
    }

    public double largestTriangleArea(int[][] points) {
        // 14ms
        double max = 0D;
        for (int[] point : points) {
            for (int j = 1; j < points.length; j++) {
                for (int k = 1; k < points.length; k++) {
                    int x1 = point[0];
                    int y1 = point[1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    double area = 0.5 * Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) ;
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

}
