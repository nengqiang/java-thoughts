package com.hnq.study.everyday.quarter202401;

import java.util.HashMap;
import java.util.Map;

/**
 * 柠檬水找零
 * <p>
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，
 * 也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 *
 * 示例 1：
 * 输入：bills = [5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * <p>
 *
 * 示例 2：
 * 输入：bills = [5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * <p>
 *
 * 提示：
 * 1 <= bills.length <= 10^5
 * bills[i] 不是 5 就是 10 或是 20
 *
 * @author henengqiang
 * @date 2024/2/6
 * @see <a href="https://leetcode.cn/problems/lemonade-change/">链接</a>
 */
public class LemonadeChange {

    public static void main(String[] args) {
        LemonadeChange l = new LemonadeChange();
        System.out.println(l.lemonadeChange2(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5}));
        System.out.println(l.lemonadeChange2(new int[]{5, 5, 5, 5, 10, 5, 10, 10, 10, 20}));
        System.out.println(l.lemonadeChange2(new int[]{5, 5, 10}));
        System.out.println(l.lemonadeChange2(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5}));
        System.out.println(l.lemonadeChange2(new int[]{5, 5, 5, 10, 20}));
        System.out.println(l.lemonadeChange2(new int[]{5, 5, 10, 10, 20}));
    }

    public boolean lemonadeChange(int[] bills) {
        // 16ms
        Map<Integer, Integer> cg = new HashMap<>();
        for (int b : bills) {
            if (b == 5) {
                cg.merge(5, 1, Integer::sum);
            } else if (b == 10) {
                cg.merge(10, 1, Integer::sum);
                int c5 = cg.getOrDefault(5, 0);
                if (c5 > 0) {
                    cg.merge(5, -1, Integer::sum);
                } else {
                    return false;
                }
            } else if (b == 20) {
                cg.merge(20, 1, Integer::sum);
                int c5 = cg.getOrDefault(5, 0);
                int c10 = cg.getOrDefault(10, 0);
                if (c5 > 0 && c10 > 0) {
                    cg.merge(10, -1, Integer::sum);
                    cg.merge(5, -1, Integer::sum);
                } else if (c5 > 2) {
                    cg.merge(5, -3, Integer::sum);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean lemonadeChange2(int[] bills) {
        // 1ms
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
                ten++;
            } else if (b == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
