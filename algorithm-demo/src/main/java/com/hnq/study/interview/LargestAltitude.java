package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/3/20
 * @see <a href="https://leetcode.cn/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75">找出最高海拔</a>
 */
public class LargestAltitude {

    public static void main(String[] args) {
        LargestAltitude l = new LargestAltitude();
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(l.largestAltitude(gain));
        gain = new int[]{-4, -3, -2, -1, 4, 3, 2};
        System.out.println(l.largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        // 0ms
        int max = 0, sum = 0;
        for (int j : gain) {
            sum += j;
            max = Math.max(max, sum);
        }
        return max;
    }

}
