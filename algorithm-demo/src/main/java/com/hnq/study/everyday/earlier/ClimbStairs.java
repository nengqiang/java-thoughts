package com.hnq.study.everyday.earlier;

/**
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author henengqiang
 * @date 2021/07/15
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs">链接</a>
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(10));
    }

    /**
     * 当n < 0时，无解，当n = 1 时，f ( n ) = 1， 当n = 2时，有两种方法，一次1级爬2次，或一次2级，
     * f （n） = 2。当 n > 2时，第一次跳一级还是两级，决定了后面剩下的台阶的跳法数目的不同：
     * 如果第一次只跳一级，则后面剩下的n-1级台阶的跳法数目为f(n-1)；如果第一次跳两级，则后面剩下的n-2级台阶的跳法数目为f(n-2)。
     * 所以，得出递归方程，f(n) = f(n-1) + f(n-2)。问题本质是斐波那契数列
     */
    private static int climbStairs(int n) {
        // 超时
        if (n <= 0) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    private static int climbStairs2(int n) {
        return 0;
    }

}
