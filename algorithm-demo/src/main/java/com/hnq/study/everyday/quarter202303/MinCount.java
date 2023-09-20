package com.hnq.study.everyday.quarter202303;

/**
 * 拿硬币
 * <p>
 *
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * <p>
 *
 * 示例 1：
 * 输入：[4,2,1]
 * 输出：4
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 * <p>
 *
 * 示例 2：
 * 输入：[2,3,10]
 * 输出：8
 * <p>
 *
 * 限制：
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 *
 * @author henengqiang
 * @date 2023/9/20
 * @see <a href="https://leetcode.cn/problems/na-ying-bi/?envType=daily-question&envId=2023-09-20">链接</a>
 */
public class MinCount {

    public static void main(String[] args) {
        MinCount m = new MinCount();
        System.out.println(m.minCount2(new int[]{4, 2, 1}));
        System.out.println(m.minCount2(new int[]{2, 3, 10}));
    }

    public int minCount(int[] coins) {
        // 0ms
        int count = 0;
        for (int x : coins) {
            if (x <= 2) {
                count++;
            } else {
                count += x / 2;
                count += x % 2;
            }
        }
        return count;
    }

    public int minCount2(int[] coins) {
        // 0ms
        int sum = 0;
        for (int i : coins) {
            sum += (i + 1) / 2;
        }
        return sum;
    }

}
