package com.hnq.basics.thinkinginjava8.operators;

/**
 * 内存溢出
 *
 * @author henengqiang
 * @date 2020/11/07
 */
public class Overflow {

    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println("big=" + big);
        int bigger = big * 4;
        System.out.println("bigger=" + bigger);
    }

}
