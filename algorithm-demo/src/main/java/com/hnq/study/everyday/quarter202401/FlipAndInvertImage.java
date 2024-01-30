package com.hnq.study.everyday.quarter202401;

import java.util.Arrays;

/**
 * 翻转图像
 * <p>
 * 给定一个 n x n 的二进制矩阵 image ，先 水平 翻转图像，然后 反转 图像并返回 结果 。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。
 * <p>
 * 例如，水平翻转 [1,1,0] 的结果是 [0,1,1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。
 * <p>
 * 例如，反转 [0,1,1] 的结果是 [1,0,0]。
 * <p>
 *
 * 示例 1：
 * 输入：image = [[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 *
 * 示例 2：
 * 输入：image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 *
 * 提示：
 * n == image.length
 * n == image[i].length
 * 1 <= n <= 20
 * images[i][j] == 0 或 1.
 *
 * @author henengqiang
 * @date 2024/1/30
 * @see <a href="https://leetcode.cn/problems/flipping-an-image/">链接</a>
 */
public class FlipAndInvertImage {

    public static void main(String[] args) {
        FlipAndInvertImage f = new FlipAndInvertImage();
        int[][] i1 = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(f.flipAndInvertImage2(i1)));
        int[][] i2 = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(f.flipAndInvertImage2(i2)));
    }

    public int[][] flipAndInvertImage(int[][] image) {
        // 0ms
        int len = image[0].length;
        boolean even = len % 2 == 0;
        int n = even ? len / 2 : len / 2 + 1;
        for (int[] r : image) {
            for (int i = 0; i < n; i++) {
                int tmp = r[i];
                r[i] = r[len - i - 1] ^ 1;
                r[len - i - 1] = tmp ^ 1;
            }
        }
        return image;
    }

    /**
     * 双指针
     */
    public int[][] flipAndInvertImage2(int[][] image) {
        // 0ms
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (image[i][left] == image[i][right]) {
                    image[i][left] ^= 1;
                    image[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                image[i][left] ^= 1;
            }
        }
        return image;
    }

}
