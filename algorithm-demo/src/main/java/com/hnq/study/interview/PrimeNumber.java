package com.hnq.study.interview;

/**
 * 判断101-200之间有多少个素数，并输出所有素数。
 *
 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。
 *
 * @author henengqiang
 * @date 2019/08/21
 */
public class PrimeNumber {

    public static void main(String[] args) {
        myAnswer(101, 200);
        myAnswer(-101, 101);
    }

    private static void myAnswer(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            int temp = (int) Math.sqrt(Math.abs(i));
            // 解决当根号i小于2时下面for循环跳过的情况，这是个bug
            temp = temp > 2 ? temp : 2;
            for (int j = 2; j <= temp; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j >= temp) {
                    System.out.println(i + " is a prime number.");
                    count++;
                }
            }
        }
        System.out.println("There are " + count + " prime numbers between " + start + " and " + end + ".");
    }

}
