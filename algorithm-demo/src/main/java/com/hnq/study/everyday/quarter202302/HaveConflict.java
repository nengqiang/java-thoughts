package com.hnq.study.everyday.quarter202302;

/**
 * 给你两个字符串数组 event1 和event2，表示发生在同一天的两个闭区间时间段事件，其中：
 * <p>
 * event1 = [startTime1, endTime1] 且
 * event2 = [startTime2, endTime2]
 * 事件的时间为有效的 24 小时制且按HH:MM格式给出。
 * <p>
 * 当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突。
 * <p>
 * 如果两个事件之间存在冲突，返回true；否则，返回false 。
 * <p>
 * 
 * 示例 1：
 * 输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
 * 输出：true
 * 解释：两个事件在 2:00 出现交集。
 * <p>
 *
 * 示例 2：
 * 输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
 * 输出：true
 * 解释：两个事件的交集从 01:20 开始，到 02:00 结束。
 * <p>
 *
 * 示例 3：
 * 输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
 * 输出：false
 * 解释：两个事件不存在交集。
 * <p>
 *
 * 提示：
 * event1.length == event2.length == 2.
 * event1[i].length == event2[i].length == 5
 * startTime1 <= endTime1
 * startTime2 <= endTime2
 * 所有事件的时间都按照HH:MM格式给出
 *
 * @author henengqiang
 * @date 2023/5/17
 * @see <a href="https://leetcode.cn/problems/determine-if-two-events-have-conflict">链接</a>
 */
public class HaveConflict {

    public static void main(String[] args) {
        String[] e9 = new String[]{"16:30","16:40"}, e10 = new String[]{"06:14","16:04"};
        System.out.println(haveConflict2(e9, e10));
        String[] e7 = new String[]{"01:37","14:20"}, e8 = new String[]{"05:06","06:17"};
        System.out.println(haveConflict2(e7, e8));
        String[] e5 = new String[]{"10:00","11:00"}, e6 = new String[]{"14:00","15:00"};
        System.out.println(haveConflict2(e5, e6));
        String[] e1 = new String[]{"01:00", "02:00"}, e2 = new String[]{"01:20", "03:00"};
        System.out.println(haveConflict2(e1, e2));
        String[] e3 = new String[]{"01:00","02:00"}, e4 = new String[]{"01:20","03:00"};
        System.out.println(haveConflict2(e3, e4));
    }

    /**
     * event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
     */
    private static boolean haveConflict(String[] event1, String[] event2) {
        // 1ms
        String[] sa = event1[0].split(":"), sb = event1[1].split(":");
        int a1 = Integer.parseInt(sa[0]), a2 = Integer.parseInt(sa[1]),
                b1 = Integer.parseInt(sb[0]), b2 = Integer.parseInt(sb[1]);

        String[] sc = event2[0].split(":"), sd = event2[1].split(":");
        int c1 = Integer.parseInt(sc[0]), c2 = Integer.parseInt(sc[1]),
                d1 = Integer.parseInt(sd[0]), d2 = Integer.parseInt(sd[1]);

        return inIt(a1, a2, c1, c2, d1, d2)
                || inIt(b1, b2, c1, c2, d1, d2)
                || inIt(c1, c2, a1, a2, b1, b2)
                || inIt(d1, d2, a1, a2, b1, b2);
    }

    private static boolean inIt(int a1, int a2, int b1, int b2, int c1, int c2) {
        if (a1 > b1 && a1 < c1) {
            return true;
        }
        if (b1 == c1) {
            return a1 == b1 && a2 >= b2 && a2 <= c2;
        }
        if (a1 == b1 && a2 >= b2) {
            return true;
        }
        if (a1 == c1 && a2 <= c2) {
            return true;
        }
        return false;
    }

    private static boolean haveConflict2(String[] event1, String[] event2) {
        // 0ms
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }

}
