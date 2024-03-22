package com.hnq.study.everyday.quarter202401;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 最近的请求次数
 *
 * @author henengqiang
 * @date 2024/3/22
 * @see <a href="https://leetcode.cn/problems/number-of-recent-calls/">链接</a>
 */
public class RecentCounter {

    private final Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>(3001);
    }

    public int ping(int t) {
        // 21ms
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }

}
