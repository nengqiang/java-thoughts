package com.hnq.study.everyday.quarter202302;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
 * 都有一个尺寸 s[j]。如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 
 * 示例1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释: 
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * <p>
 *
 * 示例2:
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释: 
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * <p>
 *
 * 提示：
 * 1 <= g.length <= 3 * 10^4
 * 0 <= s.length <= 3 * 10^4
 * 1 <= g[i], s[j] <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2023/6/29
 * @see <a href="https://leetcode.cn/problems/assign-cookies">链接</a>
 */
public class FindContentChildren {

    public static void main(String[] args) {
        FindContentChildren f = new FindContentChildren();
        System.out.println(f.findContentChildren2(new int[]{1, 2, 3}, new int[]{3}));
        System.out.println(f.findContentChildren2(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(f.findContentChildren2(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    public int findContentChildren(int[] g, int[] s) {
        // 超出内存限制
        if (s.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i : g) {
            max = Math.max(max, i);
        }
        for (int j : s) {
            max = Math.max(max, j);
        }
        int[] st = new int[max + 1];
        for (int j : s) {
            st[j]++;
        }
        int num = 0;
        for (int i : g) {
            int j = i;
            while (j <= max) {
                if (st[j] > 0) {
                    st[j]--;
                    num += 1;
                    break;
                }
                j++;
            }
        }

        return num;
    }

    /**
     * 贪心的思想是，用尽量小的饼干去满足小需求的孩子，所以需要进行排序先
     */
    public int findContentChildren2(int[] g, int[] s) {
        // 7ms
        int child = 0, cookie = 0;
        // 先将饼干 和 孩子所需大小都进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 当其中一个遍历结束就结束
        while (child < g.length && cookie < s.length) {
            // 当用当前饼干可以满足当前孩子的需求，可以满足的孩子数量+1
            if (g[child] <= s[cookie]) {
                child++;
            }
            // 饼干只可以用一次，因为饼干如果小的话，就是无法满足被抛弃，满足的话就是被用了
            cookie++;
        }
        return child;
    }

}
