package com.hnq.study.everyday.quarter202403;

/**
 * @author henengqiang
 * @date 2024/10/15
 */
public class MaxHeightOfTriangle {

    public static void main(String[] args) {
        MaxHeightOfTriangle m = new MaxHeightOfTriangle();
        System.out.println(m.maxHeightOfTriangle2(2, 4));
        System.out.println(m.maxHeightOfTriangle2(2, 1));
        System.out.println(m.maxHeightOfTriangle2(1, 1));
        System.out.println(m.maxHeightOfTriangle2(10, 1));
    }

    public int maxHeightOfTriangle(int red, int blue) {
        // 1ms
        return Math.max(maxHeight(red, blue), maxHeight(blue, red));
    }

    private int maxHeight(int x, int y) {
        int k = 1;
        while (true) {
            if (k % 2 != 0) {
                x -= k;
                if (x < 0) {
                    return k - 1;
                }
            } else {
                y -= k;
                if (y < 0) {
                    return k - 1;
                }
            }
            k++;
        }
    }

    /**
     * 直接计算：等差数列
     */
    public int maxHeightOfTriangle2(int red, int blue) {
        // 0ms
        return Math.max(maxHeight2(red, blue), maxHeight2(blue, red));
    }

    private int maxHeight2(int x, int y) {
        int odd = 2 * (int) (Math.sqrt(x)) - 1;
        int even = 2 * (int)((-1 + Math.sqrt(1 + 4 * y)) / 2);
        return Math.min(odd, even) + 1;
    }

}
