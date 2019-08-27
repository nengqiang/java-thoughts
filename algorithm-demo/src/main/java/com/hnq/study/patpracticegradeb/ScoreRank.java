package com.hnq.study.patpracticegradeb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 读入 n（>0）名学生的姓名、学号、成绩，分别输出成绩最高和成绩最低学生的姓名和学号。
 *
 * 输入：
 * 每个测试输入包含 1 个测试用例，格式为
 *
 * 第 1 行：正整数 n
 * 第 2 行：第 1 个学生的姓名 学号 成绩
 * 第 3 行：第 2 个学生的姓名 学号 成绩
 *   ... ... ...
 * 第 n+1 行：第 n 个学生的姓名 学号 成绩
 * 其中姓名和学号均为不超过 10 个字符的字符串，成绩为 0 到 100 之间的一个整数，这里保证在一组测试用例中没有两个学生的成绩是相同的。
 *
 * 输出：
 * 对每个测试用例输出 2 行，第 1 行是成绩最高学生的姓名和学号，第 2 行是成绩最低学生的姓名和学号，字符串间有 1 空格。
 *
 * 输入：
 * 3
 * Joe Math990112 89
 * Mike CS991301 100
 * Mary EE990830 95
 *
 * 输出：
 * Mike CS991301
 * Joe Math990112
 *
 * 时间限制: 400 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/23
 */
public class ScoreRank {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        rankStudents();
    }

    private static void rankStudents() {
        int n = sc.nextInt();
        sc.nextLine();
        List<Triple<String, String, Integer>> triples = new ArrayList<>(n * 4 / 3 + 1);
        for (int i = 0; i < n; i++) {
            String info = sc.nextLine();
            String[] temp = info.split(" ");
            Triple<String, String, Integer> triple = new Triple<>(temp[0], temp[1], Integer.parseInt(temp[2]));
            triples.add(triple);
        }
        triples = triples.stream().sorted(Comparator.comparing(Triple::getRight)).collect(Collectors.toList());
        Triple<String, String, Integer> triple = triples.get(triples.size() - 1);
        System.out.println(triple.getLeft() + " " + triple.getMiddle());
        triple = triples.get(0);
        System.out.println(triple.getLeft() + " " + triple.getMiddle());
    }

    private static class Triple<L, M, R> {

        private L left;

        private M middle;

        private R right;

        public Triple(L left, M middle, R right) {
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        public L getLeft() {
            return left;
        }

        public void setLeft(L left) {
            this.left = left;
        }

        public M getMiddle() {
            return middle;
        }

        public void setMiddle(M middle) {
            this.middle = middle;
        }

        public R getRight() {
            return right;
        }

        public void setRight(R right) {
            this.right = right;
        }
    }

}
