package com.hnq.basics.thinkinginjava8.controlstream;

/**
 * @author henengqiang
 * @date 2020/11/19
 */
public class WhileTest {

    public static void main(String[] args) {
        while (condition()) {
            System.out.println("Inside 'while'");
        }
        System.out.println("Outside 'while'");
    }

    private static boolean condition() {
        boolean result = Math.random() < 0.99;
        System.out.print(result + ", ");
        return result;
    }

}
