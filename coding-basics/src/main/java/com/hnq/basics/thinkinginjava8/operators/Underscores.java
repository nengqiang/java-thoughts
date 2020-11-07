package com.hnq.basics.thinkinginjava8.operators;

/**
 * 下划线
 *
 * @author henengqiang
 * @date 2020/11/07
 * @since JDK7
 */
public class Underscores {

    public static void main(String[] args) {
        double d = 341_234_344.334_334;
        System.out.println(d);
        int bin = 0b0010_1111_0010_0110_1111_0101_1100;
        System.out.println(Integer.toBinaryString(bin));
        // %x  整数类型（十六进制） %n 换行符
        System.out.printf("%x%n", bin);
        long hex = 0x7f_e9_b7_aa;
        System.out.printf("%x%n", hex);
    }

}
