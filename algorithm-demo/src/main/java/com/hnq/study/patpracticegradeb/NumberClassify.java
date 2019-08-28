package com.hnq.study.patpracticegradeb;
import	java.math.RoundingMode;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 数字分类
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：
 * A​1= 能被 5 整除的数字中所有偶数的和；
 * A​2= 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n1−n2+n​3−n4⋯；
 * A​3= 被 5 除后余 2 的数字的个数；
 * A​4= 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
 * A​5= 被 5 除后余 4 的数字中最大数字。
 *
 * 输入：
 *  每个输入包含 1 个测试用例。每个测试用例先给出一个不超过 1000 的正整数 N，随后给出 N 个不超过 1000 的待分类的正整数。数字间以空格分隔。
 *  13 1 2 3 4 5 6 7 8 9 10 20 16 18
 *  8 1 2 4 5 6 7 9 16
 *
 * 输出：
 *  对给定的 N 个正整数，按题目要求计算 A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 *  若其中某一类数字不存在，则在相应位置输出 N。
 *  30 11 2 9.7 9
 *  N 11 2 N 9
 *
 * @author henengqiang
 * @date 2019/08/28
 */
public class NumberClassify {

    private static Scanner sc = new Scanner(System.in);

    private static final String N = "N";

    public static void main(String[] args) {
        String input = sc.nextLine();
        List<Integer> nums = Arrays.stream(input.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        printClassify(nums);
    }

    private static void printClassify(List<Integer> nums) {
        Integer a1 = calA1(nums);
        Integer a2 = calA2(nums);
        Integer a3 = calA3(nums);
        Double a4 = calA4(nums);
        Integer a5 = calA5(nums);
        System.out.print(a1 == null ? N : a1);
        System.out.print(" ");
        System.out.print(a2 == null ? N : a2);
        System.out.print(" ");
        System.out.print(a3 == null ? N : a3);
        System.out.print(" ");
        System.out.print(a4 == null ? N : a4);
        System.out.print(" ");
        System.out.print(a5 == null ? N : a5);
    }

    private static Integer calA1(List<Integer> nums) {
        int count = nums.stream().filter(x -> x % 2 == 0 && x % 5 == 0).mapToInt(a -> a).sum();
        return (count == 0 && ! nums.contains(0)) ? null : count;
    }

    private static Integer calA2(List<Integer> nums) {
        int count = 0;
        List<Integer> temp = nums.stream().filter(x -> x % 5 == 1).collect(Collectors.toList());
        for (int i = 0; i < temp.size(); i++) {
            if (i % 2 == 0) {
                count += temp.get(i);
            } else {
                count -= temp.get(i);
            }
        }
        return (count == 0 && !nums.contains(0)) ? null : count;
    }

    private static Integer calA3(List<Integer> nums) {
        long count = nums.stream().filter(x -> x % 5 == 2).count();
        return count == 0 ? null : Long.valueOf(count).intValue();
    }

    /**
     * // TODO: 2019-08-28 henengqiang 答案不对？
     */
    private static Double calA4(List<Integer> nums) {
        double temp = nums.stream().filter(x -> x % 5 == 3).mapToDouble(a -> a).average().orElse(0D);
        return temp == 0 ? null : new BigDecimal(temp).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private static Integer calA5(List<Integer> nums) {
        return nums.stream().filter(x -> x % 5 == 4).max(Comparator.comparingInt(o -> o)).orElse(null);
    }
}



























