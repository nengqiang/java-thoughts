package com.hnq.study.interview;

/**
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 程序分析：兔子的规律为数列1,1,2,3,5,8,13,21….
 *
 * @author henengqiang
 * @date 2019/08/21
 */
public class RabbitQuestion {

    public static void main(String[] args) {
        myAnswer(5);
        myAnswer(8);
    }

    private static void myAnswer(int month) {
        int count = 0;
        for (int i = 1; i <= month; i++) {
            count += fn(i);
        }
        System.out.println("第" + month + "月共有" + count + "只兔子");
    }

    private static int fn(int month) {
        if (month <= 2) {
            return 1;
        }
        return fn(month - 1) + fn(month - 2);
    }

}
