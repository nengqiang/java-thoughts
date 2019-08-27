package com.hnq.study.patpracticegradeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 卡拉兹(Callatz)猜想：
 *
 * 当我们验证卡拉兹猜想的时候，为了避免重复计算，可以记录下递推过程中遇到的每一个数。例如对 n=3 进行验证的时候，我们需要计算 3、5、8、4、2、1，
 * 则当我们对 n=5、8、4、2 进行验证的时候，就可以直接判定卡拉兹猜想的真伪，而不需要重复计算，因为这 4 个数已经在验证3的时候遇到过了，
 * 我们称 5、8、4、2 是被 3“覆盖”的数。我们称一个数列中的某个数 n 为“关键数”，如果 n 不能被数列中的其他数字所覆盖。
 * 现在给定一系列待验证的数字，我们只需要验证其中的几个关键数，就可以不必再重复验证余下的数字。你的任务就是找出这些关键数字，并按从大到小的顺序输出它们。
 * 我们今天的题目不是证明卡拉兹猜想，而是对给定的任一不超过 1000 的正整数 n，简单地数一下，需要多少步（砍几下）才能得到 n=1？
 *
 * 输入：
 * 每个测试输入包含 1 个测试用例，第 1 行给出一个正整数 K (<100)，第 2 行给出 K 个互不相同的待验证的正整数 n (1<n≤100)的值，数字间用空格隔开。
 * 6
 * 3 5 6 7 8 11
 *
 * 输出：
 * 每个测试用例的输出占一行，按从大到小的顺序输出关键数字。数字间用 1 个空格隔开，但一行中最后一个数字后没有空格。
 * 7 6
 *
 * 时间限制: 400 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/21
 */
public class ThreeNAddOneGuess2 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.nextLine();
        List<Integer> nums = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        findKeyNumber(nums);
    }

    private static void findKeyNumber(List<Integer> numbers) {
        List<Integer> contains = new ArrayList<>(numbers.size() * 4 / 3 + 1);
        for (int n : numbers) {
            while (n > 1) {
                if (!isEven(n)) {
                    n = (3 * n + 1) / 2;
                    if (numbers.contains(n)) {
                        contains.add(n);
                    }
                }
                if (isEven(n)) {
                    n = n / 2;
                    if (numbers.contains(n)) {
                        contains.add(n);
                    }
                }
            }
        }
        numbers.removeAll(contains);
        StringBuilder result = new StringBuilder();
        numbers.stream().sorted((n1, n2) -> n2 - n1).forEach(x -> result.append(x).append(" "));
        System.out.print(result.substring(0, result.length() - 1));
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

}
