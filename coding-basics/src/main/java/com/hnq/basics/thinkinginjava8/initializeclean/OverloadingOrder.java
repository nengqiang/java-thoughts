package com.hnq.basics.thinkinginjava8.initializeclean;

/**
 * 区分重载方法
 *
 * @author henengqiang
 * @date 2020/11/24
 */
public class OverloadingOrder {

    public static void main(String[] args) {
        f("String first", 1);
        f(99, "Int first");
    }

    private static void f(String s, int i) {
        System.out.println("String: " + s + ", int: " + i);
    }

    private static void f(int i, String s) {
        System.out.println("int: " + i +", String: " + s);
    }

}
