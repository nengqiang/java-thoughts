package com.hnq.study.interview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author henengqiang
 * @since 2026/4/7
 * @see <a href="https://leetcode.cn/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75">最近的请求次数</a>
 */
public class RecentCounter {

    private static Deque<Integer> DEQUE;

    public RecentCounter() {
        DEQUE = new ArrayDeque<>();
    }

    public int ping(int t) {
        // 22ms
        DEQUE.addLast(t);
        while (!DEQUE.isEmpty() && DEQUE.peekFirst() < t - 3000) {
            DEQUE.pollFirst();
        }
        return DEQUE.size();
    }

    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        System.out.println(r.ping(1));
        System.out.println(r.ping(100));
        System.out.println(r.ping(3001));
        System.out.println(r.ping(3002));
    }

}
