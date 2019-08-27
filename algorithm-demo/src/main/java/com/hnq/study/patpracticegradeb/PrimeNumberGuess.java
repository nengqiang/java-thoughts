package com.hnq.study.patpracticegradeb;

import java.util.Scanner;

/**
 * 素数对猜想
 *
 * 让我们定义dn为：d​n=p(n+1)−pn，其中pi是第i个素数。显然有d​1=1，且对于n>1有d​n是偶数。“素数对猜想”认为“存在无穷多对相邻且差为2的素数”。
 *
 * 输入：
 *  输入在一行给出正整数N
 *  20
 *
 * 输出：
 *  在一行中输出不超过N的满足猜想的素数对的个数
 *  4
 *
 * @author henengqiang
 * @date 2019/08/27
 */
public class PrimeNumberGuess {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num = sc.nextInt();
        System.out.println(countPrimePair(num));
    }

    private static int countPrimePair(int num) {
        int[] temp = new int[2];
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (isPrime(i)) {
                temp[1] = temp[0];
                temp[0] = i;
                if (temp[0] - temp[1] == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
        int temp = (int)Math.sqrt(Math.abs(num));
        for (int i = 2; i <= temp; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
