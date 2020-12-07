package com.hnq.basics.thinkinginjava8.controlstream;

import java.util.Random;

/**
 * @author henengqiang
 * @date 2020/11/19
 */
public class ForInFloat {

    public static void main(String[] args) {
        Random rand = new Random(47);
        float[] f = new float[10];
        for (int i = 0; i < 10; i++) {
            f[i] = rand.nextFloat();
        }

        for (float v : f) {
            System.out.println(v);
        }
    }

}
