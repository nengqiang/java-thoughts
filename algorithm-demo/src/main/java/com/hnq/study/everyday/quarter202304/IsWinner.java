package com.hnq.study.everyday.quarter202304;

/**
 * 保龄球游戏的获胜者
 * <p>
 * 给你两个下标从 0 开始的整数数组 player1 和 player2 ，分别表示玩家 1 和玩家 2 击中的瓶数。
 * <p>
 * 保龄球比赛由 n 轮组成，每轮的瓶数恰好为 10 。
 * <p>
 * 假设玩家在第 i 轮中击中 xi 个瓶子。玩家第 i 轮的价值为：
 * <p>
 * 如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子，则为 2xi 。
 * 否则，为 xi 。
 * 玩家的得分是其 n 轮价值的总和。
 * <p>
 * 返回
 * <p>
 * 如果玩家 1 的得分高于玩家 2 的得分，则为 1 ；
 * 如果玩家 2 的得分高于玩家 1 的得分，则为 2 ；
 * 如果平局，则为 0 。
 * <p>
 *
 * 示例 1：
 * 输入：player1 = [4,10,7,9], player2 = [6,5,2,3]
 * 输出：1
 * 解释：player1 的得分是 4 + 10 + 2*7 + 2*9 = 46 。
 * player2 的得分是 6 + 5 + 2 + 3 = 16 。
 * player1 的得分高于 player2 的得分，所以 play1 在比赛中获胜，答案为 1 。
 * <p>
 *
 * 示例 2：
 * 输入：player1 = [3,5,7,6], player2 = [8,10,10,2]
 * 输出：2
 * 解释：player1 的得分是 3 + 5 + 7 + 6 = 21 。
 * player2 的得分是 8 + 10 + 2*10 + 2*2 = 42 。
 * player2 的得分高于 player1 的得分，所以 play2 在比赛中获胜，答案为 2 。
 * <p>
 *
 * 示例 3：
 * 输入：player1 = [2,3], player2 = [4,1]
 * 输出：0
 * 解释：player1 的得分是 2 + 3 = 5 。
 * player2 的得分是 4 + 1 = 5 。
 * player1 的得分等于 player2 的得分，所以这一场比赛平局，答案为 0 。
 * <p>
 *
 * 提示：
 * n == player1.length == player2.length
 * 1 <= n <= 1000
 * 0 <= player1[i], player2[i] <= 10
 *
 * @author henengqiang
 * @date 2023/12/27
 * @see <a href="https://leetcode.cn/problems/determine-the-winner-of-a-bowling-game/?envType=daily-question&envId=2023-12-27">链接</a>
 */
public class IsWinner {

    public static void main(String[] args) {
        IsWinner i = new IsWinner();
        System.out.println(i.isWinner(new int[]{4, 10, 7, 9}, new int[]{6, 5, 2, 3}));
        System.out.println(i.isWinner(new int[]{3, 5, 7, 6}, new int[]{8, 10, 10, 2}));
        System.out.println(i.isWinner(new int[]{2, 3}, new int[]{4, 1}));
    }

    public int isWinner(int[] player1, int[] player2) {
        // 1ms
        int sum1 = 0, sum2 = 0, n = player1.length;
        int pre11 = 0, pre12 = 0, pre21 = 0, pre22 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += pre11 == 10 || pre12 == 10 ? 2 * player1[i] : player1[i];
            sum2 += pre21 == 10 || pre22 == 10 ? 2 * player2[i] : player2[i];
            pre12 = pre11;
            pre11 = player1[i];
            pre22 = pre21;
            pre21 = player2[i];
        }
        return sum1 == sum2 ? 0 : (sum1 > sum2 ? 1 : 2);
    }

}
