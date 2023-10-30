package com.hnq.study.everyday.quarter202304;

/**
 * 机器人能否返回原点
 * <p>
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * <p>
 * 移动顺序由字符串 moves 表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * <p>
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * <p>
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。
 * 此外，假设每次移动机器人的移动幅度相同。
 * <p>
 *
 * 示例 1:
 * 输入: moves = "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
 * <p>
 *
 * 示例 2:
 * 输入: moves = "LL"
 * 输出: false
 * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
 * <p>
 *
 * 提示:
 * 1 <= moves.length <= 2 * 10^4
 * moves 只包含字符 'U', 'D', 'L' 和 'R'
 *
 * @author henengqiang
 * @date 2023/10/30
 * @see <a href="https://leetcode.cn/problems/robot-return-to-origin/">链接</a>
 */
public class JudgeCircle {

    public static void main(String[] args) {
        JudgeCircle j = new JudgeCircle();
        System.out.println(j.judgeCircle2("UD"));
        System.out.println(j.judgeCircle2("LL"));
    }

    public boolean judgeCircle(String moves) {
        // 4ms
        char[] str = moves.toCharArray();
        int lr = 0, ud = 0;
        for (char c : str) {
            if ('L' == c) {
                lr--;
            } else if ('R' == c) {
                lr++;
            } else if ('U' == c) {
                ud++;
            } else if ('D' == c) {
                ud--;
            }
        }
        return lr == 0 && ud == 0;
    }

    public boolean judgeCircle2(String moves) {
        // 5ms
        int len = moves.length();
        if (len == 0) {
            return true;
        }
        if (len % 2 == 1) {
            return false;
        }
        int x = 0, y = 0;
        for (int i = 0; i < len; i++) {
            int c = moves.charAt(i);
            if ('L' == c) {
                x--;
            } else if ('R' == c) {
                x++;
            } else if ('U' == c) {
                y++;
            } else if ('D' == c) {
                y--;
            }
        }
        return x == 0 && y == 0;
    }

}
