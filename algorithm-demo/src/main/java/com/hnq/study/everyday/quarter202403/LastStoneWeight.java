package com.hnq.study.everyday.quarter202403;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author henengqiang
 * @date 2024/11/14
 * @see <a href="https://leetcode.cn/problems/last-stone-weight/">链接</a>
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight l = new LastStoneWeight();
        System.out.println(l.lastStoneWeight2(new int[] {2, 7, 4, 1, 8, 1}));
    }

    public int lastStoneWeight(int[] stones) {
        // 0ms
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        int st = stones.length - 1, stt = st - 1;
        while (true) {
            int a = stones[st];
            int b = stones[stt];
            stones[st] = 0;
            stones[stt] = 0;
            if (b == 0) {
                return a;
            }
            if (b < a) {
                stones[stt] = a - b;
            }
            Arrays.sort(stones);
        }
    }

    /**
     * 最大堆
     */
    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

}
