package com.hnq.study.everyday.quarter202303;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
 * <p>
 *
 * 示例 1：
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * <p>
 *
 * 示例 2：
 * 输入：num = 7
 * 输出：false
 * <p>
 *
 * 提示：
 * 1 <= num <= 10^8
 *
 * @author henengqiang
 * @date 2023/8/23
 * @see <a href="https://leetcode.cn/problems/perfect-number/">链接</a>
 */
public class CheckPerfectNumber {

    public static void main(String[] args) {
        CheckPerfectNumber c = new CheckPerfectNumber();
        System.out.println(c.checkPerfectNumber3(1));
        System.out.println(c.checkPerfectNumber3(28));
        System.out.println(c.checkPerfectNumber3(7));
    }

    public boolean checkPerfectNumber(int num) {
        // 1047ms
        if (num == 1) {
            return false;
        }
        int count = 1, end = num / 2 + 1;
        for (int i = 2; i < end; i++) {
            if (num % i == 0) {
                count += i;
            }
        }
        return count == num;
    }

    /**
     * 枚举不超过 sqrt(num) 的数
     */
    public boolean checkPerfectNumber2(int num) {
        // 1ms
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int d = 2; d * d <= num; d++) {
            if (num % d == 0) {
                sum += d;
                if (d * d < num) {
                    sum += num / d;
                }
            }
        }
        return sum == num;
    }

    /**
     * 根据欧几里得-欧拉定理，每个偶完全数都可以写成 (2^(p - 1)) * (2 ^ p - 1) 的形式，其中 p 为素数且 2^p - 1 为素数。
     * 由于目前奇完全数还未被发现，因此题目范围 [1,10^8]内的完全数都可以写成上述形式。
     * 这一共有如下 5 个：
     * 6,28,496,8128,33550336
     */
    public boolean checkPerfectNumber3(int num) {
        // 0ms
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}
