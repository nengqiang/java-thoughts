package com.hnq.study.everyday.quarter202403;

/**
 * @author henengqiang
 * @date 2024/11/5
 */
public class LosingPlayer {

    public static void main(String[] args) {
        LosingPlayer l = new LosingPlayer();
        System.out.println(l.losingPlayer(2, 7));
        System.out.println(l.losingPlayer(4, 11));
    }

    public String losingPlayer(int x, int y) {
        // 0ms
        int t = Math.min(x, y / 4);
        return t % 2 == 0 ? "Bob" : "Alice";
    }

}
