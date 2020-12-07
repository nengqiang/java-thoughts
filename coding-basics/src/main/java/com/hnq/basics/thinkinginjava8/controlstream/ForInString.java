package com.hnq.basics.thinkinginjava8.controlstream;

/**
 * @author henengqiang
 * @date 2020/11/19
 */
public class ForInString {

    public static void main(String[] args) {
        for (char c : "A handsome Chinese boy".toCharArray()) {
            System.out.print(c + " ");
        }
    }

}
