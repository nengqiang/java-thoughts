package com.hnq.study.interview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author henengqiang
 * @since 2026/4/7
 * @see <a href="https://leetcode.cn/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75">Dota2 参议院</a>
 */
public class PredictPartyVictory {

    public static void main(String[] args) {
        PredictPartyVictory r = new PredictPartyVictory();
        System.out.println(r.predictPartyVictory("RD"));
        System.out.println(r.predictPartyVictory("DR"));
        System.out.println(r.predictPartyVictory("RDD"));
        System.out.println(r.predictPartyVictory("RDDR"));
        System.out.println(r.predictPartyVictory("RDDRRR"));
    }

    public String predictPartyVictory(String senate) {
        // 10ms
        int len = senate.length();
        Queue<Integer> a = new ArrayDeque<>(len);
        Queue<Integer> b = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                a.add(i);
            } else {
                b.add(i);
            }
        }
        while (!a.isEmpty() && !b.isEmpty()) {
            int c = a.poll();
            int d = b.poll();
            if (c < d) {
                a.offer(c + len);
            } else {
                b.offer(d + len);
            }
        }
        return a.isEmpty() ? "Dire" : "Radiant";
    }

}
