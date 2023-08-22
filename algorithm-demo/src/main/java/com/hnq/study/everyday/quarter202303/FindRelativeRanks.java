package com.hnq.study.everyday.quarter202303;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都互不相同 。
 * <p>
 * 运动员将根据得分决定名次，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，
 * 依此类推。运动员的名次决定了他们的获奖情况：
 * <p>
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * <p>
 *
 *
 * 示例 1：
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * <p>
 *
 * 示例 2：
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 * <p>
 *
 * 提示：
 * n == score.length
 * 1 <= n <= 10^4
 * 0 <= score[i] <= 10^6
 * score 中的所有值互不相同
 *
 * @author henengqiang
 * @date 2023/8/22
 * @see <a href="https://leetcode.cn/problems/relative-ranks/">链接</a>
 */
public class FindRelativeRanks {

    public static void main(String[] args) {
        FindRelativeRanks r = new FindRelativeRanks();
        System.out.println(Arrays.toString(r.findRelativeRanks3(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(r.findRelativeRanks3(new int[]{10,3,8,9,4})));
    }

    public String[] findRelativeRanks(int[] score) {
        // 超时
        int[] t = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            t[i] = score[i];
        }
        quickSort(t, 0, score.length - 1);
        Map<Integer, String> m = new HashMap<>();
        int k = 0;
        for (int i = t.length - 1; i >= 0; i--) {
            k++;
            if (k == 1) {
                m.put(t[i], "Gold Medal");
            } else if (k == 2) {
                m.put(t[i], "Silver Medal");
            } else if (k == 3) {
                m.put(t[i], "Bronze Medal");
            } else {
                m.put(t[i], String.valueOf(k));
            }
        }
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            ans[i] = m.get(score[i]);
        }
        return ans;
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end, baseVal = arr[start];
        while (i < j) {
            while (i< j && arr[j] >= baseVal) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < baseVal) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
            arr[i] = baseVal;
            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }
    }

    public String[] findRelativeRanks2(int[] score) {
        // 6ms
        int[] t = new int[score.length];
        System.arraycopy(score, 0, t, 0, score.length);
        Arrays.sort(t);
        Map<Integer, String> m = new HashMap<>();
        int k = 0;
        for (int i = t.length - 1; i >= 0; i--) {
            k++;
            if (k == 1) {
                m.put(t[i], "Gold Medal");
            } else if (k == 2) {
                m.put(t[i], "Silver Medal");
            } else if (k == 3) {
                m.put(t[i], "Bronze Medal");
            } else {
                m.put(t[i], String.valueOf(k));
            }
        }
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            ans[i] = m.get(score[i]);
        }
        return ans;
    }

    public String[] findRelativeRanks3(int[] score) {
        // 7ms
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;
    }

}
