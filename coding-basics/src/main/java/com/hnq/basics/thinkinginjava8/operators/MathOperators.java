package com.hnq.basics.thinkinginjava8.operators;

import java.util.Random;

/**
 * 算术运算符
 *
 * @author henengqiang
 * @date 2020/11/07
 */
public class MathOperators {

    public static void main(String[] args) {
        Random rand = new Random(47);
        int i, j, k;
        j = rand.nextInt(100) + 1;
        System.out.println("j=" + j);
        k = rand.nextInt(100) + 1;
        System.out.println("k=" + k);
        System.out.println("j + k = " + (j + k));
        System.out.println("j - k = " + (j - k));
        System.out.println("j * k = " + j * k);
        System.out.println("j / k = " + j / k);
        System.out.println("j % k = " + j % k);
        j %= k;
        System.out.println("j %= K = " + j);

        float u, v, w;
        v = rand.nextFloat();
        System.out.println("v=" + v);
        w = rand.nextFloat();
        System.out.println("w=" + w);
        System.out.println("v + w =" + (v + w));
        System.out.println("v - w = " + (v - w));
        System.out.println("v * w = " + v * w);
        System.out.println("v / w = " + v / w);

        u = v;
        v += w;
        System.out.println("v += w = " + v);
        v = u;
        v -= w;
        System.out.println("v -= w = " + v);
        v = u;
        v *= w;
        System.out.println("v *= w = " + v);
        v = u;
        v /= w;
        System.out.println("v /= w = " + v);
    }

}
