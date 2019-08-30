package com.hnq.study.patpracticegradeb;

import com.google.common.base.Stopwatch;

import java.util.Scanner;

/**
 * 输入：
 *  输入第 1 行给出正整数 N（≤10^5），即双方交锋的次数。随后 N 行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。
 *  C 代表“锤子”、J 代表“剪刀”、B 代表“布”，第 1 个字母代表甲方，第 2 个代表乙方，中间有 1 个空格。
 * 10
 * C J
 * J B
 * C B
 * B B
 * B C
 * C C
 * C B
 * J B
 * B C
 * J J
 *
 * 输出：
 *  输出第 1、2 行分别给出甲、乙的胜、平、负次数，数字间以 1 个空格分隔。第 3 行给出两个字母，分别代表甲、乙获胜次数最多的手势，
 *  中间有 1 个空格。如果解不唯一，则输出按字母序最小的解。
 * 5 3 2
 * 2 3 5
 * B B
 *
 * 时间限制: 200 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/30
 */
public class RockPaperScissors {

    private static Scanner sc = new Scanner(System.in);

    private static final String C = "C";
    private static final String J = "J";
    private static final String B = "B";

    public static void main(String[] args) {
        logic();
    }

    /**
     * // TODO: 2019-08-30 henengqiang 部分正确 运行超时
     */
    private static void logic() {
        int num = sc.nextInt();
        sc.nextLine();
        String[] a = new String[num];
        String[] b = new String[num];
        for (int i = 0; i < num; i++) {
            String[] input = sc.nextLine().split(" ");
            a[i] = input[0];
            b[i] = input[1];
        }

        Stopwatch watch = Stopwatch.createStarted();
        calWinNums(a, b);
        watch.stop();
        System.out.println("-------------");
        System.out.println(watch.toString());
    }

    private static void calWinNums(String[] ar, String[] br) {
        int countAwin = 0, countAtie = 0, countAloss = 0, countAC = 0, countAJ = 0, countAB = 0;
        int countBwin = 0, countBtie = 0, countBloss = 0, countBC = 0, countBJ = 0, countBB = 0;
        for (int i = 0; i < ar.length; i++) {
            String a = ar[i];
            String b = br[i];
            if (isAwin(a, b)) {
                countAwin++;
                countBloss++;
                switch (a) {
                    case C:
                        countAC++; break;
                    case J:
                        countAJ++; break;
                    case B:
                        countAB++; break;
                        default: break;
                }
            } else if (isBwin(a, b)) {
                countBwin++;
                countAloss++;
                switch (b) {
                    case C:
                        countBC++; break;
                    case J:
                        countBJ++; break;
                    case B:
                        countBB++; break;
                    default: break;
                }
            } else {
                countAtie++;
                countBtie++;
            }
        }
        System.out.println(countAwin + " " + countAtie + " " + countAloss);
        System.out.println(countBwin + " " + countBtie + " " + countBloss);

        int temp = Math.max(countAC, countAJ);
        if (temp <= countAB) {
            System.out.print(B);
        } else {
            if (temp == countAC) {
                System.out.print(C);
            } else {
                System.out.print(J);
            }
        }
        System.out.print(" ");

        temp = Math.max(countBC, countBJ);
        if (temp <= countBB) {
            System.out.print(B);
        } else {
            if (temp == countBC) {
                System.out.print(C);
            } else {
                System.out.print(J);
            }
        }
    }

    private static boolean isAwin(String a, String b) {
        return C.equals(a) && J.equals(b)
                || J.equals(a) && B.equals(b)
                || B.equals(a) && C.equals(b);
    }

    private static boolean isBwin(String a, String b) {
        return isAwin(b, a);
    }
}
