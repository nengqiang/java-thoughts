package com.hnq.study.everyday.quarter202304;

/**
 * 统计能整除数字的位数
 * <p>
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * <p>
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 * <p>
 *
 * 示例 1：
 * 输入：num = 7
 * 输出：1
 * 解释：7 被自己整除，因此答案是 1 。
 * <p>
 *
 * 示例 2：
 * 输入：num = 121
 * 输出：2
 * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
 * <p>
 *
 * 示例 3：
 * 输入：num = 1248
 * 输出：4
 * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
 * <p>
 *
 * 提示：
 * 1 <= num <= 10^9
 * num 的数位中不含 0
 *
 * @author henengqiang
 * @date 2023/10/26
 * @see <a href="https://leetcode.cn/problems/count-the-digits-that-divide-a-number/?envType=daily-question&envId=2023-10-26">链接</a>
 */
public class CountDigits {

    public static void main(String[] args) {
        CountDigits c = new CountDigits();
        System.out.println(c.countDigits2(121));
        System.out.println(c.countDigits2(7));
        System.out.println(c.countDigits2(1248));
    }

    public int countDigits(int num) {
        // 0ms
        int[] p = new int[9];
        int x = num;
        while (x > 0) {
            int n = x % 10;
            p[n - 1]++;
            x /= 10;
        }
        int count = 0;
        for (int i = 1; i <= p.length; i++) {
            int n = p[i - 1];
            if (n > 0 && num % i == 0) {
                count += n;
            }
        }
        return count;
    }

    public int countDigits2(int num) {
        // 0ms
        int t = num, res = 0;
        while (t != 0) {
            if (num % (t % 10) == 0) {
                res++;
            }
            t /= 10;
        }
        return res;
    }

}
