package com.hnq.basics.thinkinginjava8.initializeclean;

/**
 * @author henengqiang
 * @date 2020/11/24
 */
public class Rock2 {

    Rock2(int i) {
        System.out.print("Rock2 " + i + " ");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Rock2(i);
        }
    }

}
