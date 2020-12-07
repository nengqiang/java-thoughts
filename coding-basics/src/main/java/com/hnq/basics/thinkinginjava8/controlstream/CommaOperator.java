package com.hnq.basics.thinkinginjava8.controlstream;

/**
 * @author henengqiang
 * @date 2020/11/19
 */
public class CommaOperator {

    public static void main(String[] args) {
        for (int i = 0, j = i + 10; i < 5; i++, j = i * 2) {
            System.out.println("i=" + i + ", j=" + j);
        }
    }

}
