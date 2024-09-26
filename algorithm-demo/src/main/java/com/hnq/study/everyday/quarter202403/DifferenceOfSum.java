package com.hnq.study.everyday.quarter202403;

/**
 * @author henengqiang
 * @date 2024/9/26
 */
public class DifferenceOfSum {

    public static void main(String[] args) {
        DifferenceOfSum d = new DifferenceOfSum();

        int[] e = {3, 6, 15, 14, 17, 12, 9, 9, 15, 3, 13, 5, 18, 13, 18, 17, 5, 14, 7, 20};
        System.out.println(d.differenceOfSum2(e));
        int[] c = {2, 7, 8, 10, 8, 10, 1, 10, 5, 9};
        System.out.println(d.differenceOfSum2(c));
        int[] a = {1, 15, 6, 3};
        System.out.println(d.differenceOfSum2(a));
        int[] b = {1, 2, 3, 4};
        System.out.println(d.differenceOfSum2(b));
    }

    public int differenceOfSum(int[] nums) {
        // 2ms
        int sum1 = 0, sum2 = 0;
        for (int num : nums) {
            sum1 += num;
            while (num % 10 > 0 || num >= 10) {
                sum2 += num % 10;
                num /= 10;
            }
        }
        return Math.abs(sum1 - sum2);
    }

    /**
     * 由于元素值一定不小于其数位和，所以答案就是元素和减去数位和，无需取绝对值。
     */
    public int differenceOfSum2(int[] nums) {
        // 2ms
        int ans = 0;
        for (int x : nums) {
            ans += x;
            while (x > 0) {
                ans -= x % 10;
                x /= 10;
            }
        }
        return ans;
    }

}
