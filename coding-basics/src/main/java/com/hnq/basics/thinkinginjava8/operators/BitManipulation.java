package com.hnq.basics.thinkinginjava8.operators;

import java.util.Random;

/**
 * 使用位运算符
 *
 * @author henengqiang
 * @date 2020/11/07
 */
public class BitManipulation {

    public static void main(String[] args) {
        Random rand = new Random();
        int i = rand.nextInt();
        int j = rand.nextInt();
        printBinaryInt("-1", -1);
        printBinaryInt("+1", +1);
        int maxPos = Integer.MAX_VALUE;
        printBinaryInt("maxPos", maxPos);
        int maxNeg = Integer.MIN_VALUE;
        printBinaryInt("maxNeg", maxNeg);
        printBinaryInt("i", i);
        printBinaryInt("~i", ~i);
        printBinaryInt("-i", -i);
        printBinaryInt("j", j);
        printBinaryInt("i & j", i & j);
        printBinaryInt("1 | j", i | j);
        printBinaryInt("i ^ j", i ^ j);
        printBinaryInt("i << 5", i << 5);
        printBinaryInt("i >> 5", i >> 5);
        printBinaryInt("(~i) >> 5", (~i) >> 5);
        printBinaryInt("i >>> 5", i>>> 5);
        printBinaryInt("(~i) >>> 5", (~i) >>> 5);
        long l = rand.nextLong();
        long m = rand.nextLong();
        printBinaryLong("-1L", -1L);
        printBinaryLong("+1L", +1L);
        long l1 = Long.MAX_VALUE;
        printBinaryLong("maxPos", l1);
        long l2 = Long.MIN_VALUE;
        printBinaryLong("minPos", l2);
        printBinaryLong("l", l);
        printBinaryLong("~l", ~l);
        printBinaryLong("-l", -l);
        printBinaryLong("m", m);
        printBinaryLong("l & m", l & m);
        printBinaryLong("l ^ m", l ^ m);
        printBinaryLong("l << 5", l << 5);
        printBinaryLong("l >> 5", l >> 5);
        printBinaryLong("(~l) >> 5", (~l) >> 5);
        printBinaryLong("l >>> 5", l >>> 5);
        printBinaryLong("(~L) >>> 5", (~l) >>> 5);

    }

    static void printBinaryInt(String s, int i) {
        System.out.println(s + ", int=" + i + ", binary=" + Integer.toBinaryString(i));
    }

    static void printBinaryLong(String s, long l) {
        System.out.println(s + ", long=" + l + ", binary=" + Long.toBinaryString(l));
    }

}
