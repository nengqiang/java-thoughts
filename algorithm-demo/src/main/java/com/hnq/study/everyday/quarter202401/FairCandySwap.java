package com.hnq.study.everyday.quarter202401;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 公平的糖果交换
 * <p>
 * 爱丽丝和鲍勃拥有不同总数量的糖果。给你两个数组 aliceSizes 和 bobSizes ，
 * aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量，bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
 * <p>
 * 两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。
 * 一个人拥有的糖果总数量是他们每盒糖果数量的总和。
 * <p>
 * 返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，
 * answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。如果存在多个答案，你可以返回其中 任何一个 。
 * 题目测试用例保证存在与输入对应的答案。
 * <p>
 *
 * 示例 1：
 * 输入：aliceSizes = [1,1], bobSizes = [2,2]
 * 输出：[1,2]
 * <p>
 *
 * 示例 2：
 * 输入：aliceSizes = [1,2], bobSizes = [2,3]
 * 输出：[1,2]
 * <p>
 *
 * 示例 3：
 * 输入：aliceSizes = [2], bobSizes = [1,3]
 * 输出：[2,3]
 * <p>
 *
 * 示例 4：
 * 输入：aliceSizes = [1,2,5], bobSizes = [2,4]
 * 输出：[5,4]
 * <p>
 *
 * 提示：
 * 1 <= aliceSizes.length, bobSizes.length <= 10^4
 * 1 <= aliceSizes[i], bobSizes[j] <= 10^5
 * 爱丽丝和鲍勃的糖果总数量不同。
 * 题目数据保证对于给定的输入至少存在一个有效答案。
 *
 * @author henengqiang
 * @date 2024/2/27
 * @see <a href="https://leetcode.cn/problems/fair-candy-swap/">链接</a>
 */
public class FairCandySwap {

    public static void main(String[] args) {
        FairCandySwap f = new FairCandySwap();
        System.out.println(Arrays.toString(f.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }

    /**
     * sumA - x + y = sumB + x - y
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // 14ms
        int sumA = Arrays.stream(aliceSizes).sum();
        int sumB = Arrays.stream(bobSizes).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<>();
        for (int num : aliceSizes) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : bobSizes) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }

}
