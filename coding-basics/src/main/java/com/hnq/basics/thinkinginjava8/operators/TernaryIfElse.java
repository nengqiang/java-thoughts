package com.hnq.basics.thinkinginjava8.operators;

/**
 * 三元运算符
 *
 * @author henengqiang
 * @date 2020/11/07
 */
public class TernaryIfElse {

    public static void main(String[] args) {
        System.out.println(ternary(9));
        System.out.println(ternary(10));
        System.out.println(standardIfElse(9));
        System.out.println(standardIfElse(10));
    }

    static int standardIfElse(int i) {
        if (i < 10) {
            return  i * 100;
        } else {
            return i * 10;
        }
    }

    static int ternary(int i) {
        return i < 10 ? i * 100 : i * 10;
    }

}
