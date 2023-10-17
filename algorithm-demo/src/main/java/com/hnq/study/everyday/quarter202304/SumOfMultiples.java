package com.hnq.study.everyday.quarter202304;

/**
 * 倍数求和
 * <p>
 * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
 * <p>
 * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
 * <p>
 *
 * 示例 1：
 * 输入：n = 7
 * 输出：21
 * 解释：在 [1, 7] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7 。数字之和为 21 。
 * <p>
 *
 * 示例 2：
 * 输入：n = 10
 * 输出：40
 * 解释：在 [1, 10] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9、10 。数字之和为 40 。
 * <p>
 *
 * 示例 3：
 * 输入：n = 9
 * 输出：30
 * 解释：在 [1, 9] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9 。数字之和为 30 。
 * <p>
 *
 * 提示：
 * 1 <= n <= 10^3
 *
 * @author henengqiang
 * @date 2023/10/17
 * @see <a href="https://leetcode.cn/problems/sum-multiples/?envType=daily-question&envId=2023-10-17">链接</a>
 */
public class SumOfMultiples {

    public static void main(String[] args) {
        SumOfMultiples s = new SumOfMultiples();
        System.out.println(s.sumOfMultiples2(7));
        System.out.println(s.sumOfMultiples2(10));
        System.out.println(s.sumOfMultiples2(9));
    }

    public int sumOfMultiples(int n) {
        // 2ms
        if (n < 3) {
            return 0;
        }
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int sumOfMultiples2(int n) {
        // 1ms
        return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
    }

    public int f(int n, int m) {
        return (m + n / m * m) * (n / m) / 2;
    }

}
