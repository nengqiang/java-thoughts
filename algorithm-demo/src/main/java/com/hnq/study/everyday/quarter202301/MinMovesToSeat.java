package com.hnq.study.everyday.quarter202301;

import java.util.Arrays;

/**
 * 一个房间里有 n个座位和 n名学生，房间用一个数轴表示。给你一个长度为 n的数组seats，其中seats[i] 是第 i个座位的位置。
 * 同时给你一个长度为 n的数组students，其中students[j]是第 j位学生的位置。
 * <p>
 * 你可以执行以下操作任意次：
 * <p>
 * 增加或者减少第i位学生的位置，每次变化量为 1（也就是将第 i位学生从位置 x移动到 x + 1或者 x - 1）
 * 请你返回使所有学生都有座位坐的 最少移动次数，并确保没有两位学生的座位相同。
 * <p>
 * 请注意，初始时有可能有多个座位或者多位学生在 同一位置。
 * <p>
 * 示例 1：
 * 输入：seats = [3,1,5], students = [2,7,4]
 * 输出：4
 * 解释：学生移动方式如下：
 * - 第一位学生从位置 2 移动到位置 1 ，移动 1 次。
 * - 第二位学生从位置 7 移动到位置 5 ，移动 2 次。
 * - 第三位学生从位置 4 移动到位置 3 ，移动 1 次。
 * 总共 1 + 2 + 1 = 4 次移动。
 * <p>
 * 示例 2：
 * 输入：seats = [4,1,5,9], students = [1,3,2,6]
 * 输出：7
 * 解释：学生移动方式如下：
 * - 第一位学生不移动。
 * - 第二位学生从位置 3 移动到位置 4 ，移动 1 次。
 * - 第三位学生从位置 2 移动到位置 5 ，移动 3 次。
 * - 第四位学生从位置 6 移动到位置 9 ，移动 3 次。
 * 总共 0 + 1 + 3 + 3 = 7 次移动。
 * <p>
 * 示例 3：
 * 输入：seats = [2,2,6,6], students = [1,3,2,6]
 * 输出：4
 * 解释：学生移动方式如下：
 * - 第一位学生从位置 1 移动到位置 2 ，移动 1 次。
 * - 第二位学生从位置 3 移动到位置 6 ，移动 3 次。
 * - 第三位学生不移动。
 * - 第四位学生不移动。
 * 总共 1 + 3 + 0 + 0 = 4 次移动。
 * <p>
 * 提示：
 * n == seats.length == students.length
 * 1 <= n <= 100
 * 1 <= seats[i], students[j] <= 100
 *
 * @author henengqiang
 * @date 2023/1/18
 * @see <a href="https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone">链接</a>
 */
public class MinMovesToSeat {

    public static void main(String[] args) {
        int[] st4 = new int[]{12,14,19,19,12};
        int[] sd4 = new int[]{19,2,17,20,7};
        System.out.println(minMovesToSeat(st4, sd4));

        int[] st1 = new int[]{3, 1, 5};
        int[] sd1 = new int[]{2, 7, 4};
        System.out.println(minMovesToSeat(st1, sd1));

        int[] st2 = new int[]{4,1,5,9};
        int[] sd2 = new int[]{1,3,2,6};
        System.out.println(minMovesToSeat(st2, sd2));

        int[] st3 = new int[]{2,2,6,6};
        int[] sd3 = new int[]{1,3,2,6};
        System.out.println(minMovesToSeat(st3, sd3));

    }

    private static int minMovesToSeat(int[] seats, int[] students) {
        // 2ms
        Arrays.sort(seats);
        Arrays.sort(students);
        int min = 0;
        for (int i = 0; i < seats.length; i++) {
            min += Math.abs(seats[i] - students[i]);
        }
        return min;
    }

}
