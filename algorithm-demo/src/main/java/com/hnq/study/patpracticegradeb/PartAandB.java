package com.hnq.study.patpracticegradeb;

import com.google.common.base.Stopwatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 正整数 A 的“D​A（为 1 位整数）部分”定义为由 A 中所有 DA组成的新整数 PA。
 * 例如：给定 A=3862767，DA=6，则 A 的“6 部分”PA是 66，因为 A 中有 2 个 6。
 * 现给定 A、D​A、B、DB，请编写程序计算 P​A+PB。
 *
 * 输入：
 *  输入在一行中依次给出 A、DA、B、DB，中间以空格分隔，其中 0<A,B<10^10。
 *  3862767 6 13530293 3
 *  3862767 1 13530293 8
 *
 * 输出：
 *  在一行中输出 PA+P​B的值。
 *  399
 *  0
 *
 * 时间限制: 150 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/30
 */
public class PartAandB {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        logic();
    }

    private static void logic() {
        String[] input = sc.nextLine().split(" ");
        Stopwatch watch = Stopwatch.createStarted();
        Map<String, String> param = new HashMap<>(input.length / 2 * 3 / 4 + 1);
        param.put(input[1], input[0]);
        param.put(input[3], input[2]);
        int sum = selectAndAdd(param);
        System.out.print(sum);
        watch.stop();
        System.out.println("--------------");
        System.out.println(watch.toString());
    }

    /**
     * // TODO: 2019-08-30 henengqiang 有一个测试用例答案错误？
     */
    private static int selectAndAdd(Map<String, String> param) {
        int sum = 0;
        for (Map.Entry<String, String> entry : param.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            if (!v.contains(k)) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            String[] temp = v.split("");
            for (String s : temp) {
                if (k.equals(s)) {
                    sb.append(s);
                }
            }
            sum += Integer.parseInt(sb.toString());
        }
        return sum;
    }

}
