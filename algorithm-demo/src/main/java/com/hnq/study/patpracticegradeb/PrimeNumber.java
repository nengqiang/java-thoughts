package com.hnq.study.patpracticegradeb;


import java.util.Scanner;

/**
 * 数素数
 *
 * 令 Pi表示第 i 个素数。现任给两个正整数 M≤N≤10​^4，请输出 P​M到 P​N的所有素数。
 *
 * 输入：
 *  输入在一行中给出 M 和 N，其间以空格分隔。
 *  5 27
 *
 * 输出：
 *  输出从 P​M 到 P​N 的所有素数，每 10 个数字占 1 行，其间以空格分隔，但行末不得有多余空格。
 *  11 13 17 19 23 29 31 37 41 43
 * 47 53 59 61 67 71 73 79 83 89
 * 97 101 103
 *
 * 时间限制: 200 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/21
 */
public class PrimeNumber {

    private static Scanner sc = new Scanner(System.in);

    /**
     * // TODO: 2019-08-29 henengqiang 部分正确？
     */
    public static void main(String[] args) {
        String[] input = sc.nextLine().split(" ");
        int[] result = findPrimeNum(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        for (int i = 1; i <= result.length; i++) {
            System.out.print(result[i - 1]);
            if (i % 10 == 0 && i < result.length) {
                System.out.println();
            } else if (i < result.length) {
                System.out.print(" ");
            }
        }
    }

    private static int[] findPrimeNum(int start, int end) {
        int[] result = new int[end - start + 1];
        int k = 0;
        int count = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int temp = (int) Math.sqrt(Math.abs(i));
            temp = temp > 2 ? temp : 2;
            for (int j = 2; j <= temp; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j >= temp) {
                    count++;
                    if (count >= start && count <= end) {
                        result[k++] = i;
                    }
                }
            }
            if (count >= end) {
                break;
            }
        }
        return result;
    }

}
