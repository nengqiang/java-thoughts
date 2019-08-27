package com.hnq.study.patpracticegradeb;

import java.util.Scanner;

/**
 * 一元多项式求导
 * 设计函数求一元多项式的导数。（注：x^n（n为整数）的一阶导数为nx^(n−1)。）
 *
 * 输入：
 *  以指数递降方式输入多项式非零项系数和指数（绝对值均为不超过 1000 的整数）。数字间以空格分隔。
 *  3 4 -5 2 6 1 -2 0
 *
 * 输出：
 *  以与输入相同的格式输出导数多项式非零项的系数和指数。数字间以空格分隔，但结尾不能有多余空格。
 *  注意“零多项式”的指数和系数都是 0，但是表示为 0 0。
 *  12 3 -10 1 6 0
 *
 * @author henengqiang
 * @date 2019/8/27 0027
 */
public class PolynomialDerivation {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        calIt();
    }

    private static void calIt() {
        String input = sc.nextLine();
        String[] data = input.split(" ");
        int[] nums = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            nums[i] = Integer.parseInt(data[i]);
        }
        int[] result = calculateDerivation(nums);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.print(sb.substring(0, sb.length() - 1));
    }

    /**
     * // TODO: 2019/8/27 0027 题目还没大看懂
     */
    private static int[] calculateDerivation(int[] data) {
        int[] result = new int[data.length];
        int j = 0;
        for (int i = 0; i < data.length; i += 2) {
            if (data[i + 1] == 0) {
                break;
            }
            result[j++] = data[i] * data[i + 1];
            result[j++] = data[i + 1] - 1;
        }
        return result;
    }

}
