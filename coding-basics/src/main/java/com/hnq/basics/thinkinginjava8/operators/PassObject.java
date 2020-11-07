package com.hnq.basics.thinkinginjava8.operators;

/**
 * 别名现象
 *
 * @author henengqiang
 * @date 2020/11/07
 */
public class PassObject {

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1:x.c=" + x.c);
        f(x);
        System.out.println("2:x.c=" + x.c);
    }

    static void f(Letter y) {
        y.c = 'z';
    }

}

class Letter {
    char c;
}