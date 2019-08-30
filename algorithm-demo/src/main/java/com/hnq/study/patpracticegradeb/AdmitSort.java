package com.hnq.study.patpracticegradeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 德才论
 *
 * 输入：
 *  考生总数 L录取最低分数线 H优先录取线
 *  准考证号(8位) 德分 才分
 *
 *  德分和才分均不低于最低录取线才有资格被录取
 *  德分和才分均不低于优先录取线的被定义为“才德全尽” 此类考生按德才总分从高到低排序
 *  才分不到但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后
 *  德才分均低于 H，但是德分不低于才分的考生属于“才德兼亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后
 *  其他达到最低线 L 的考生也按总分排序，但排在第三类考生之后
 *
 * 输出：
 *  输出第一行首先给出达到最低分数线的考生人数 M，随后 M 行，每行按照输入格式输出一位考生的信息，考生按输入中说明的规则从高到低排序。
 *  当某类考生中有多人总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。
 *
 * 输入：
 * 14 60 80
 * 10000001 64 90
 * 10000002 90 60
 * 10000011 85 80
 * 10000003 85 80
 * 10000004 80 85
 * 10000005 82 77
 * 10000006 83 76
 * 10000007 90 78
 * 10000008 75 79
 * 10000009 59 90
 * 10000010 88 45
 * 10000012 80 100
 * 10000013 90 99
 * 10000014 66 60
 *
 * 输出：
 * 12
 * 10000013 90 99
 * 10000012 80 100
 * 10000003 85 80
 * 10000011 85 80
 * 10000004 80 85
 * 10000007 90 78
 * 10000006 83 76
 * 10000005 82 77
 * 10000002 90 60
 * 10000014 66 60
 * 10000008 75 79
 * 10000001 64 90
 *
 * 时间限制: 400 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 * 
 * @author henengqiang
 * @date 2019/08/30
 */
public class AdmitSort {

    private static Scanner sc = new Scanner(System.in);

    /**
     * // TODO: 2019-08-30 henengqiang 部分正确 运行超时
     */
    public static void main(String[] args) {
        logic();
    }

    private static void logic() {
        int[] conditions = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int stuNums = conditions[0];
        int lowestScore = conditions[1];
        int priorityScore = conditions[2];
        List<Student> students = new ArrayList<>(stuNums * 4 / 3 + 1);
        for (int i = 0; i < stuNums; i++) {
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Student student = new Student(input[0], input[1], input[2]);
            students.add(student);
        }

        students = students
                .stream()
                .filter(s -> s.getMoralityScore() >= lowestScore && s.getTalentScore() >= lowestScore)
                .collect(Collectors.toList());
        System.out.println(students.size());

        students = sort(students, priorityScore);
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.print(s.getId() + " " + s.getMoralityScore() + " " + s.getTalentScore());
            if (i < students.size() - 1) {
                System.out.println();
            }
        }
    }

    private static List<Student> sort(List<Student> students, int priorityScore) {
        List<Student> result = new ArrayList<>(students.size() * 4 / 3 + 1);

        List<Student> s1 = students
                .stream()
                .filter(s -> s.getMoralityScore() >= priorityScore && s.getTalentScore() >= priorityScore)
                .collect(Collectors.toList());
        students.removeAll(s1);
        s1 = sortScore(s1);
        result.addAll(s1);

        List<Student> s2 = students
                .stream()
                .filter(s -> s.getMoralityScore() >= priorityScore && s.getTalentScore() < priorityScore)
                .collect(Collectors.toList());
        students.removeAll(s2);
        s2 = sortScore(s2);
        result.addAll(s2);

        List<Student> s3 = students
                .stream()
                .filter(s -> s.getMoralityScore() < priorityScore && s.getTalentScore() < priorityScore && s.getMoralityScore() > s.getTalentScore())
                .collect(Collectors.toList());
        students.removeAll(s3);
        s3 = sortScore(s3);
        result.addAll(s3);

        List<Student> s4 = students;
        s4 = sortScore(s4);
        result.addAll(s4);

        return result;
    }

    private static List<Student> sortScore(List<Student> s) {
        return s.stream().sorted((st1, st2) -> {
            int score1 = st1.getMoralityScore() + st1.getTalentScore();
            int score2 = st2.getMoralityScore() + st2.getTalentScore();
            if (score1 != score2) {
                // 总分不相等按总分降序
                return score2 - score1;
            } 
            if (st1.getMoralityScore() != st2.getMoralityScore()) {
                // 总分相等 德分不相等 按德分降序
                return st2.getMoralityScore() - st1.getMoralityScore();
            }
            // 总分相等 德分相等 按准考证号升序
            return st1.getId() - st2.getId();
        }).collect(Collectors.toList());
    }

    private static class Student {
        private int id;
        private int moralityScore;
        private int talentScore;

        public Student(int id, int moralityScore, int talentScore) {
            this.id = id;
            this.moralityScore = moralityScore;
            this.talentScore = talentScore;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMoralityScore() {
            return moralityScore;
        }

        public void setMoralityScore(int moralityScore) {
            this.moralityScore = moralityScore;
        }

        public int getTalentScore() {
            return talentScore;
        }

        public void setTalentScore(int talentScore) {
            this.talentScore = talentScore;
        }
    }
}
