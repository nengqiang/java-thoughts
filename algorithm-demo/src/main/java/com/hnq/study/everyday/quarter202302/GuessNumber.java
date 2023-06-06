package com.hnq.study.everyday.quarter202302;

import com.hnq.study.everyday.GuessGame;

/**
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，
 * 返回值一共有 3 种可能的情况（-1，1或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * <p>
 * 
 *
 * 示例 1：
 * 输入：n = 10, pick = 6
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：n = 1, pick = 1
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：n = 2, pick = 1
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：n = 2, pick = 2
 * 输出：2
 * <p>
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 * 1 <= pick <= n
 *
 * @author henengqiang
 * @date 2023/6/6
 * @see <a href="https://leetcode.cn/problems/guess-number-higher-or-lower">链接</a>
 */
public class GuessNumber extends GuessGame {

    public static void main(String[] args) {
        GuessNumber g = new GuessNumber();
        System.out.println(g.guessNumber(2));
        System.out.println(g.guessNumber(25));
        System.out.println(g.guessNumber(14));
        System.out.println(g.guessNumber(15));
        System.out.println(g.guessNumber(16));
        System.out.println(g.guessNumber(17));
        System.out.println(g.guessNumber(18));
        System.out.println(g.guessNumber(19));
        System.out.println(g.guessNumber(20));
        System.out.println(g.guessNumber(21));
        System.out.println(g.guessNumber(22));
        System.out.println(g.guessNumber(23));
        System.out.println(g.guessNumber(24));
        System.out.println(g.guessNumber(25));
        System.out.println(g.guessNumber(255));
        System.out.println(g.guessNumber(2588888));
    }

    public int guessNumber(int n) {
        // 0ms
        if (guess(1) == 0) {
            return 1;
        }
        if (guess(n) == 0) {
            return n;
        }
        int l = 1, r = n, mid = l + (r - l) / 2;
        int p = guess(mid);
        while (p != 0) {
            if (p > 0) {
                l = mid;
            } else {
                r = mid;
            }
            mid = l + (r - l) / 2;
            p = guess(mid);
        }
        return mid;
    }

    public int guessNumber2(int n) {
        int left = 1, right = n;
        // 循环直至区间左右端点相同
        while (left < right) {
            // 防止计算时溢出
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                // 答案在区间 [left, mid] 中
                right = mid;
            } else {
                // 答案在区间 [mid + 1, right] 中
                left = mid + 1;
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

}
