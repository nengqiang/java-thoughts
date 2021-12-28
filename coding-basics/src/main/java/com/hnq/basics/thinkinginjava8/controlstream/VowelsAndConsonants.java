package com.hnq.basics.thinkinginjava8.controlstream;

import java.util.Random;

/**
 * @author henengqiang
 * @date 2021/12/28
 */
public class VowelsAndConsonants {

    private static final Random R = new Random(47);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int c = R.nextInt(26) + 'a';
            System.out.println((char)c + ", " + c + ": ");
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;
                case 'y':
                case 'w':
                    System.out.println("Sometimes vowel");
                    break;
                default:
                    System.out.println("consonant");
            }
        }
    }

}
