package com.hnq.study.everyday;

/**
 * 实现int sqrt(int x)函数。
 *
 * 计算并返回x的平方根，其中x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 *
 *
 * @author henengqiang
 * @date 2021/07/14
 * @see <a href="https://leetcode-cn.com/problems/sqrtx">链接</a>
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }

    private static int mySqrt(int x) {
        // 1ms
        double y = 1.0, check;
        do {
            y = (x / y + y) / 2.0;
            check = y * y - x;
        } while ((check >= 0 ? check : -check) >= 1);
        return (int) y;
    }

    private static int mySqrt2(int x) {
        // 牛顿迭代法
        long r = x  / 2;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    private static int mySqrt3(int x) {
        // 二分法 用 x/m < m 而不是 m*m > x 防止溢出
        if (x == 1) {
            return 1;
        }
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int m = (max + min) / 2;
            if (x / m < m) {
                max = m;
            } else {
                min = m;
            }
        }
        return min;
    }

}
