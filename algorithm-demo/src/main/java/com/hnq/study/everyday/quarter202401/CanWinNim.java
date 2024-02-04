package com.hnq.study.everyday.quarter202401;

/**
 * Nim 游戏
 * <p>
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * <p>
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合， 你作为先手 。
 * 每一回合，轮到的人拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。
 * 如果可以赢，返回 true；否则，返回 false 。
 * <p>
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：false
 * 解释：以下是可能的结果:
 * 1. 移除1颗石头。你的朋友移走了3块石头，包括最后一块。你的朋友赢了。
 * 2. 移除2个石子。你的朋友移走2块石头，包括最后一块。你的朋友赢了。
 * 3.你移走3颗石子。你的朋友移走了最后一块石头。你的朋友赢了。
 * 在所有结果中，你的朋友是赢家。
 * <p>
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 * <p>
 *
 * 示例 3：
 * 输入：n = 2
 * 输出：true
 * <p>
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2024/2/4
 * @see <a href="https://leetcode.cn/problems/nim-game/?envType=daily-question&envId=2024-02-04">链接</a>
 */
public class CanWinNim {

    public static void main(String[] args) {
        CanWinNim c = new CanWinNim();
        System.out.println(c.canWinNim(4));
        System.out.println(c.canWinNim(1));
        System.out.println(c.canWinNim(2));
    }

    /**
     * 博弈论
     *
     * 找规律
     * n = 0 先手必输
     *
     * n = 1 先手全拿走 后手必输
     * n = 2 先手全拿走 后手必输
     * n = 3 先手全拿走 后手必输
     * n = 4 先手无论怎么拿 都会剩下1或2或3 先手必输
     *
     * n = 5 先手拿走1个给后手制造n == 4 后手必输
     * n = 6 先手拿走2个给后手制造n == 4 后手必输
     * n = 7 先手拿走3个给后手制造n == 4 后手必输
     * n = 8 先手无论怎么拿 都会剩下5或6或7 先手必输
     * ...
     */
    public boolean canWinNim(int n) {
        // 0ms
        return n % 4 != 0;
    }

}
