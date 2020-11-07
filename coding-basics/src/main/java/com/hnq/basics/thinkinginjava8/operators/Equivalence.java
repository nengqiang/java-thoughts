package com.hnq.basics.thinkinginjava8.operators;

/**
 * 关系运算符
 *
 * @author henengqiang
 * @date 2020/11/07
 */
public class Equivalence {

    public static void main(String[] args) {
        Integer n1 = 47;
        Integer n2 = 47;
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
        System.out.println(n1.equals(n2));

        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        // equals() 的默认行为是比较对象的引用而非具体内容
        System.out.println(v1.equals(v2));
    }

}

class Value {
    int i;
}