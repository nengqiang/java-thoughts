package com.hnq.basics.thinkinginjava8.controlstream;

/**
 * @author henengqiang
 * @date 2020/11/19
 */
public class ListCharacters {

    public static void main(String[] args) {
        for (char c = 0; c < 128; c++) {
            if (Character.isLowerCase(c)) {
                System.out.println("value=" + (int) c + " character=" + c);
            }
        }
    }

}
