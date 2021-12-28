package com.hnq.study.everyday.earlier;

/**
 * 你和你的朋友，两个人一起玩Nim 游戏：
 *
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合，你作为先手。
 * 每一回合，轮到的人拿掉1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：false 
 * 解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *     因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 *
 * 示例 3：
 * 输入：n = 2
 * 输出：true
 *
 * 提示：
 *
 * 1 <= n <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2021/11/29
 * @see <a href="https://leetcode-cn.com/problems/nim-game">链接</a>
 */
public class CanWinNim {

    public static void main(String[] args) {
        System.out.println(canWinNim(1));
        System.out.println(canWinNim(2));
        System.out.println(canWinNim(3));
        System.out.println(canWinNim(4));
        System.out.println(canWinNim(5));
        System.out.println(canWinNim(6));
        System.out.println(canWinNim(7));
        System.out.println(canWinNim(8));
        System.out.println(canWinNim(9));
        System.out.println(canWinNim(10));
        System.out.println(canWinNim(11));
        System.out.println(canWinNim(12));
        System.out.println(canWinNim(13));
        System.out.println(canWinNim(14));
        System.out.println(canWinNim(15));
        System.out.println(canWinNim(16));
        System.out.println(canWinNim(17));
        System.out.println(canWinNim(18));
        System.out.println(canWinNim(19));
        System.out.println(canWinNim(20));
    }

    /**
     * 从结果中发现规律：
     *
     * 1 true
     * 2 true
     * 3 true
     * 4 false  X
     * 5 true
     * 6 true
     * 7 true
     * 8 false  X
     * 9 true
     * 10 true
     * 11 true
     * 12 false  X
     * 13 true
     * 14 true
     * 15 true
     * 16 false  X
     * 17 true
     * 18 true
     * 19 true
     * 20 false  X
     */
    private static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    // 巴什博奕，n%(m+1)!=0时，先手总是会赢的
}
