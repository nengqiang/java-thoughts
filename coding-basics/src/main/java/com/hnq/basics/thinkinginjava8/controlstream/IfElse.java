package com.hnq.basics.thinkinginjava8.controlstream;

/**
 * @author henengqiang
 * @date 2020/11/19
 */
public class IfElse {

    private static int result = 0;

    public static void main(String[] args) {
        test(10, 5);
        System.out.println(result);
        test(5, 10);
        System.out.println(result);
        test(5, 5);
        System.out.println(result);
    }

    private static void test(int testVal, int target) {
        // result = Integer.compare(testVal, target);
        if (testVal > target) {
            result = 1;
        } else if (testVal < target) {
            result = -1;
        } else {
            result = 0;
        }
    }

}
