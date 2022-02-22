package com.hnq.study.everyday.month2202;

/**
 * 你总共有n枚硬币，并计划将它们按阶梯状排列。
 * 对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 *
 * 示例 2：
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 *
 * 提示：
 *
 * 1 <= n <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2022/02/22
 * @see <a href="https://leetcode-cn.com/problems/arranging-coins">链接</a>
 */
public class ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(1804289383));
    }

    /**
     * 公式求解： (-b±根号下（b * b - 4 * a * c）) / 2 * a
     */
    private static int arrangeCoins(int n) {
        // 1 ms	38.9 MB
        return (int) ((- 1 + Math.sqrt(1 + 8D * n)) / 2);
    }

    /**
     * 迭代求解法 O(n)
     */
    private static int arrangeCoins2(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    /**
     * 二分查找，O(log(n / 2 + 1))
     */
    public static int arrangeCoins3(int n) {
        long start = 0, end = (long) n / 2 + 1, mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }

}
