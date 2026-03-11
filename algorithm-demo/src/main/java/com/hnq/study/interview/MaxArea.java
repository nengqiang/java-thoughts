package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/3/11
 * @see <a href="https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75">盛最多水的容器</a>
 */
public class MaxArea {

    public static void main(String[] args) {
        MaxArea m = new MaxArea();
        System.out.println(m.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(m.maxArea(new int[]{1, 1}));
    }

    /**
     * left++和right--都是为了尝试取到更多的水，如果短的板不动的话，取到的水永远不会比上次多。
     */
    public int maxArea(int[] height) {
        // 4ms
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            int area = (right - left + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }

}
