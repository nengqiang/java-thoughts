package com.hnq.study.everyday.quarter202303;

/**
 * 学生出勤记录 I
 * <p>
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * <p>
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * <p>
 *
 * 示例 1：
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * <p>
 *
 * 示例 2：
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 * <p>
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 为 'A'、'L' 或 'P'
 *
 * @author henengqiang
 * @date 2023/9/1
 * @see <a href="https://leetcode.cn/problems/student-attendance-record-i/">链接</a>
 */
public class CheckRecord {

    public static void main(String[] args) {
        CheckRecord c = new CheckRecord();
        System.out.println(c.checkRecord2("PPALLA"));
        System.out.println(c.checkRecord2("PPALLP"));
        System.out.println(c.checkRecord2("PPALLL"));
    }

    public boolean checkRecord(String s) {
        // 0ms
        int ac = 0, lc = 0;
        char pl = ' ';
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                ac++;
                if (ac >= 2) {
                    return false;
                }
            }
            if (pl == 'L') {
                if (c == 'L') {
                    lc++;
                    if (lc >= 3) {
                        return false;
                    }
                } else {
                    pl = ' ';
                    lc = 0;
                }
            } else {
                if (c == 'L') {
                    pl = 'L';
                    lc++;
                }
            }
        }
        return true;
    }

    public boolean checkRecord2(String s) {
        // 0ms
        int a = 0, l = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                a++;
                if (a >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                l++;
                if (l >= 3) {
                    return false;
                }
            } else {
                l = 0;
            }
        }
        return true;
    }

}
