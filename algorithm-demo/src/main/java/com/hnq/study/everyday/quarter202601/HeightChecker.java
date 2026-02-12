package com.hnq.study.everyday.quarter202601;

import java.util.Arrays;

/**
 * @author henengqiang
 * @date 2026/2/10
 */
public class HeightChecker {

    public static void main(String[] args) {
        int[] h1 = new int[]{1, 1, 4, 2, 1, 3};
        System.out.println(new HeightChecker().heightChecker(h1));
        int[] h2 = new int[]{5, 1, 2, 3, 4};
        System.out.println(new HeightChecker().heightChecker(h2));
        int[] h3 = new int[]{1, 2, 3, 4, 5};
        System.out.println(new HeightChecker().heightChecker(h3));
    }

    public int heightChecker(int[] heights) {
        int[] after = new int[heights.length];
        System.arraycopy(heights, 0, after, 0, heights.length);
        Arrays.sort(after);
        int x = 0;
        for (int i = 0; i < heights.length; i++) {
            int n1 = heights[i];
            int n2 = after[i];
            if (n1 != n2) {
                x += 1;
            }
        }
        return x;
    }

}
