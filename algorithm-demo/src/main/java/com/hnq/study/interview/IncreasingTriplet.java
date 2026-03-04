package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/3/4
 * @see <a href="https://leetcode.cn/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75">递增的三元子序列</a>
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
        IncreasingTriplet i = new IncreasingTriplet();
        System.out.println(i.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(i.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(i.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    /**
     * 用a来存最小值，b来存a之后任意比a大的值，如果存了b之后有再比b大的值，就return true，就有三个连续了
     */
    public boolean increasingTriplet(int[] nums) {
        // 2ms
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }
        }
        return false;
    }

}
