package com.hnq.study.everyday.quarter202303;

/**
 * 将钱分给最多的儿童
 * <p>
 * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
 * <p>
 * 你需要按照如下规则分配：
 * 所有的钱都必须被分配。
 * 每个儿童至少获得 1 美元。
 * 没有人获得 4 美元。
 * 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
 * <p>
 *
 * 示例 1：
 * 输入：money = 20, children = 3
 * 输出：1
 * 解释：
 * 最多获得 8 美元的儿童数为 1 。一种分配方案为：
 * - 给第一个儿童分配 8 美元。
 * - 给第二个儿童分配 9 美元。
 * - 给第三个儿童分配 3 美元。
 * 没有分配方案能让获得 8 美元的儿童数超过 1 。
 * <p>
 *
 * 示例 2：
 * 输入：money = 16, children = 2
 * 输出：2
 * 解释：每个儿童都可以获得 8 美元。
 * <p>
 *
 * 提示：
 * 1 <= money <= 200
 * 2 <= children <= 30
 *
 * @author henengqiang
 * @date 2023/9/22
 * @see <a href="https://leetcode.cn/problems/distribute-money-to-maximum-children/?envType=daily-question&envId=2023-09-22">链接</a>
 */
public class DistMoney {

    public static void main(String[] args) {
        DistMoney d = new DistMoney();
        System.out.println(d.distMoney2(20, 3));
        System.out.println(d.distMoney2(16, 2));
    }

    public int distMoney(int money, int children) {
        // 2ms
        if (money < children) {
            return -1;
        }
        if (money > children * 8) {
            return children - 1;
        }
        if (money == (children * 8 - 4)) {
            return children - 2;
        }
        return (int) Math.floor((double) (money - children) / 7);
    }

    /**
     * 贪心
     */
    public int distMoney2(int money, int children) {
        if (money < children) {
            return -1;
        }
        money -= children;
        int cnt = Math.min(money / 7, children);
        money -= cnt * 7;
        children -= cnt;
        if ((children == 0 && money > 0) || (children == 1 && money == 3)) {
            cnt--;
        }
        return cnt;
    }

}
