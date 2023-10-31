package com.hnq.study.everyday.quarter202304;

import java.util.Arrays;

/**
 * 图片平滑器
 * <p>
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 * <p>
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。
 * （即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 * <p>
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格
 * （即，需要计算红色平滑器中 4 个单元格的平均值）。
 * <p>
 *
 * 给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。
 * <p>
 *
 * 示例 1:
 * 输入:img = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * <p>
 *
 * 示例 2:
 * 输入: img = [[100,200,100],[200,50,200],[100,200,100]]
 * 输出: [[137,141,137],[141,138,141],[137,141,137]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * 对于点 (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * 对于点 (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 * <p>
 *
 * 提示:
 * m == img.length
 * n == img[i].length
 * 1 <= m, n <= 200
 * 0 <= img[i][j] <= 255
 *
 * @author henengqiang
 * @date 2023/10/31
 * @see <a href="https://leetcode.cn/problems/image-smoother/">链接</a>
 */
public class ImageSmoother {

    public static void main(String[] args) {
        ImageSmoother i = new ImageSmoother();
        int[][] i1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(i.imageSmoother2(i1)));
        int[][] i2 = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        System.out.println(Arrays.deepToString(i.imageSmoother2(i2)));
    }

    public int[][] imageSmoother(int[][] img) {
        // 7ms
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = img[i][j], x = 1;
                boolean a = i - 1 >= 0, b = j - 1 >= 0, p = i + 1 <= m - 1, q = j + 1 <= n - 1;
                if (a) {
                    sum += img[i - 1][j];
                    x++;
                }
                if (b) {
                    sum += img[i][j - 1];
                    x++;
                }
                if (p) {
                    sum += img[i + 1][j];
                    x++;
                }
                if (q) {
                    sum += img[i][j + 1];
                    x++;
                }
                if (a && b) {
                    sum += img[i- 1][j - 1];
                    x++;
                }
                if (a && q) {
                    sum += img[i - 1][j + 1];
                    x++;
                }
                if (b && p) {
                    sum += img[i + 1][j - 1];
                    x++;
                }
                if (p && q) {
                    sum += img[i + 1][j + 1];
                    x++;
                }
                res[i][j] = (int) Math.floor((double) sum / x);
            }
        }
        return res;
    }

    public int[][] imageSmoother2(int[][] img) {
        // 5ms
        int m = img.length, n = img[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0, sum = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            num++;
                            sum += img[x][y];
                        }
                    }
                }
                ret[i][j] = sum / num;
            }
        }
        return ret;
    }

}
