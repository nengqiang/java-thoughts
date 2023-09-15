package com.hnq.study.everyday.quarter202303;

/**
 * 宝石补给
 * <p>
 * 欢迎各位勇者来到力扣新手村，在开始试炼之前，请各位勇者先进行「宝石补给」。
 * <p>
 * 每位勇者初始都拥有一些能量宝石， gem[i] 表示第 i 位勇者的宝石数量。
 * 现在这些勇者们进行了一系列的赠送，operations[j] = [x, y] 表示在第 j 次的赠送中
 * 第 x 位勇者将自己一半的宝石（需向下取整）赠送给第 y 位勇者。
 * <p>
 * 在完成所有的赠送后，请找到拥有最多宝石的勇者和拥有最少宝石的勇者，并返回他们二者的宝石数量之差。
 * <p>
 *
 * 注意：
 * 赠送将按顺序逐步进行。
 * <p>
 *
 * 示例 1：
 * 输入：gem = [3,1,2], operations = [[0,2],[2,1],[2,0]]
 * 输出：2
 * 解释： 第 1 次操作，勇者 0 将一半的宝石赠送给勇者 2， gem = [2,1,3] 第 2 次操作，
 * 勇者 2 将一半的宝石赠送给勇者 1， gem = [2,2,2] 第 3 次操作，勇者 2 将一半的宝石赠送给勇者 0， gem = [3,2,1] 返回 3 - 1 = 2
 * <p>
 *
 * 示例 2：
 * 输入：gem = [100,0,50,100], operations = [[0,2],[0,1],[3,0],[3,0]]
 * 输出：75
 * 解释： 第 1 次操作，勇者 0 将一半的宝石赠送给勇者 2， gem = [50,0,100,100] 第 2 次操作，
 * 勇者 0 将一半的宝石赠送给勇者 1， gem = [25,25,100,100] 第 3 次操作，
 * 勇者 3 将一半的宝石赠送给勇者 0， gem = [75,25,100,50] 第 4 次操作，
 * 勇者 3 将一半的宝石赠送给勇者 0， gem = [100,25,100,25] 返回 100 - 25 = 75
 * <p>
 *
 * 示例 3：
 * 输入：gem = [0,0,0,0], operations = [[1,2],[3,1],[1,2]]
 * 输出：0
 * <p>
 *
 * 提示：
 * 2 <= gem.length <= 10^3
 * 0 <= gem[i] <= 10^3
 * 0 <= operations.length <= 10^4
 * operations[i].length == 2
 * 0 <= operations[i][0], operations[i][1] < gem.length
 *
 * @author henengqiang
 * @date 2023/9/15
 * @see <a href="https://leetcode.cn/problems/WHnhjV/?envType=daily-question&envId=2023-09-15">链接</a>
 */
public class GiveGem {

    public static void main(String[] args) {
        GiveGem g = new GiveGem();
        int[] g4 = {0, 2, 5, 4};
        int[][] op4 = {{3, 2}, {3, 2}, {1, 3}, {0, 2}, {3, 0}, {3, 1}, {0, 3}, {2, 1}, {3, 0}};
        System.out.println(g.giveGem(g4, op4));

        int[] g1 = {3, 2, 1};
        int[][] op1 = {{0, 2}, {2, 1}, {2, 0}};
        System.out.println(g.giveGem(g1, op1));

        int[] g2 = {100, 0, 50, 100};
        int[][] op2 = {{0, 2}, {0, 1}, {3, 0}, {3, 0}};
        System.out.println(g.giveGem(g2, op2));

        int[] g3 = {0, 0, 0, 0};
        int[][] op3 = {{1, 2}, {3, 1}, {1, 2}};
        System.out.println(g.giveGem(g3, op3));
    }

    public int giveGem(int[] gem, int[][] operations) {
        // 2ms
        for (int[] o : operations) {
            int x = gem[o[0]] / 2;
            gem[o[0]] -= x;
            gem[o[1]] += x;
        }
        int max = gem[0], min = gem[0];
        for (int i = 1; i < gem.length; i++) {
            max = Math.max(max, gem[i]);
            min = Math.min(min, gem[i]);
        }
        return max - min;
    }

}
