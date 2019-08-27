package com.hnq.study.patpracticegradeb;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 数组元素循环右移问题
 * 在不允许使用另外数组的前提下，如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 *
 * 输入：
 * 6 2
 * 1 2 3 4 5 6
 *
 * 输出：
 * 5 6 1 2 3 4
 *
 * @author henengqiang
 * @date 2019/08/27
 */
public class ArrayMove {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.nextLine();
        int steps = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList()).get(1);
        String[] nums = sc.nextLine().split(" ");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        moveArray(steps, arr);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(x -> sb.append(x).append(" "));
        System.out.print(sb.substring(0, sb.length() - 1));
    }

    /**
     * // TODO: 2019-08-27 henengqiang 应该会有更好的方案
     */
    private static void moveArray(int steps, int[] arr) {
        if (steps > arr.length) {
            steps -= arr.length;
        }
        for (int i = 0; i < steps; i++) {
            int temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j >= 0; j--) {
                if (j + 1 <= arr.length - 1) {
                    arr[j + 1] = arr[j];
                }
                if (j <= 0) {
                    arr[0] = temp;
                }
            }
        }
    }

}
