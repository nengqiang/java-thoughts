package com.hnq.study.everyday.quarter202303;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 *
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 *
 * 示例 3：
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 *
 * 提示：
 * 0 <= n <= 30
 *
 * @author henengqiang
 * @date 2023/8/25
 * @see <a href="https://leetcode.cn/problems/fibonacci-number/">链接</a>
 */
public class Fib {

    public static void main(String[] args) {
        Fib f = new Fib();
        System.out.println(f.fib4(2));
        System.out.println(f.fib4(3));
        System.out.println(f.fib4(4));
        System.out.println(f.fib4(30));
    }

    public int fib(int n) {
        // 8ms
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        // 0ms
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int sum = 1, p = 0, k = 2;
        while (k <= n) {
            int pre = sum;
            sum = sum + p;
            p = pre;
            k++;
        }
        return sum;
    }

    /**
     * 动态规划
     */
    public int fib3(int n) {
        // 0ms
        if (n < 2) {
            return n;
        }
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 矩阵快速幂
     */
    public int fib4(int n) {
        // 0ms
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return  ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * 通项公式
     */
    public int fib5(int n) {
        // 0ms
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

}
