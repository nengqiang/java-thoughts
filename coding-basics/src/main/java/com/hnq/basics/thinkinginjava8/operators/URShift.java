package com.hnq.basics.thinkinginjava8.operators;

/**
 * 位移运算符
 *
 * 移位运算符面向的运算对象也是二进制的“位”。它们只能用于处理整数类型（基本类型的一种）。
 * 左移位运算符 << 能将其左边的运算对象向左移动右侧指定的位数（在低位补 0）。右移位运算符 >> 则相反。
 * 右移位运算符有“正”、“负”值：若值为正，则在高位插入 0；若值为负，则在高位插入 1。
 * Java 也添加了一种“不分正负”的右移位运算符（>>>），它使用了“零扩展”（zero extension）：无论正负，都在高位插入 0。这一运算符是 C/C++ 没有的。
 *
 * 如果移动 char、byte 或 short，则会在移动发生之前将其提升为 int，结果为 int。仅使用右值（rvalue）的 5 个低阶位。
 * 这可以防止我们移动超过 int 范围的位数。若对一个 long 值进行处理，最后得到的结果也是 long。
 *
 * 移位可以与等号 <<= 或 >>= 或 >>>= 组合使用。左值被替换为其移位运算后的值。
 * 但是，问题来了，当无符号右移与赋值相结合时，若将其与 byte 或 short 一起使用的话，则结果错误。
 * 取而代之的是，它们被提升为 int 型并右移，但在重新赋值时被截断。在这种情况下，结果为 -1。
 *
 * 右移位运算符>>，若操作的值为正，则在高位插入0；若值为负，则在高位插入1。
 *
 * 右移补零操作符>>>，无论正负，都在高位插入0。
 *
 * @author henengqiang
 * @date 2020/11/07
 */
public class URShift {

    public static void main(String[] args) {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
         i >>>= 10;
        System.out.println(Integer.toBinaryString(i));
        long l = -1;
        System.out.println(Long.toBinaryString(l));
        l >>>= 10;
        System.out.println(Long.toBinaryString(l));
        short s = -1;
        System.out.println(Integer.toBinaryString(s));
        s >>>= 10;
        System.out.println(Integer.toBinaryString(s));
        byte b = -1;
        System.out.println(Integer.toBinaryString(b));
        b >>>= 10;
        System.out.println(Integer.toBinaryString(b));
        b = -1;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b >>> 10));
    }

}
