package com.hnq.basics.thinkinginjava8.initializeclean;

/**
 * @author henengqiang
 * @date 2020/11/24
 */
public class Rock {

    Rock() {
        System.out.println("Rock Constructor.");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock();
        }
    }

}
