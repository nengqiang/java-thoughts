package com.hnq.study.everyday.quarter202403;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author henengqiang
 * @date 2024/11/21
 */
public class FinalPositionOfSnake {

    public static void main(String[] args) {
        FinalPositionOfSnake f = new FinalPositionOfSnake();
        System.out.println(f.finalPositionOfSnake(2, Lists.newArrayList("RIGHT", "DOWN")));
        System.out.println(f.finalPositionOfSnake(3, Lists.newArrayList("DOWN", "RIGHT", "UP")));
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        // 2ms
        int[] p = {0, 0};
        for (String command : commands) {
            switch (command) {
                case "UP": p[1]--; break;
                case "DOWN": p[1]++; break;
                case "LEFT": p[0]--; break;
                case "RIGHT": p[0]++; break;
                default: break;
            }
        }
        return p[0] + p[1] * n;
    }

}
