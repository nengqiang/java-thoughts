package com.hnq.study.everyday;

/**
 * 统计所有小于非负整数n的质数的数量。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 *
 * 提示：
 *
 * 0 <= n <= 5 * 10^6
 *
 * @author henengqiang
 * @date 2021/9/14
 * @see <a href="https://leetcode-cn.com/problems/count-primes">链接</a>
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes2(10));
        System.out.println(countPrimes2(0));
        System.out.println(countPrimes2(1));
    }

    private static int countPrimes(int n) {
        // 超时
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                continue;
            }
            if (i == 2) {
                count++;
                continue;
            }
            int k = (int) Math.sqrt(i);
            k = k < 2 ? i : k;
            for (int j = 2; j <= k; j++) {
                if (i != j && i % j == 0) {
                    break;
                } else if (j >= k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 厄拉多塞筛法：
     * 比如说求20以内质数的个数,首先0,1不是质数.
     * 2是第一个质数,然后把20以内所有2的倍数划去.
     * 2后面紧跟的数即为下一个质数3,然后把3所有的倍数划去.
     * 3后面紧跟的数即为下一个质数5,再把5所有的倍数划去.以此类推.
     */
    private static int countPrimes2(int n) {
        // 45ms
        int count = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    flag[j] = true;
                }
            }
        }
        return count;
    }

}
