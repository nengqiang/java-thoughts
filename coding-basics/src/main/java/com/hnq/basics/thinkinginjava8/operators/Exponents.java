package com.hnq.basics.thinkinginjava8.operators;

/**
 * 指数计数法
 *
 * @author henengqiang
 * @date 2020/11/07
 */
public class Exponents {

    public static void main(String[] args) {
        // 大写 E 和小写 e 的效果相同:
        float expFloat = 1.39e-43f;
        expFloat = 1.39E-43f;
        System.out.println(expFloat);
        // 'd' 是可选的
        double expDouble = 47e47d;
        // 自动转换为 double
        double expDouble2 = 47e47;
        System.out.println(expDouble);
    }

}
