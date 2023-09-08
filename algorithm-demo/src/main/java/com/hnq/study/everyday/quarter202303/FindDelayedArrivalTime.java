package com.hnq.study.everyday.quarter202303;

/**
 * 计算列车到站时间
 * <p>
 * 给你一个正整数 arrivalTime 表示列车正点到站的时间（单位：小时），另给你一个正整数 delayedTime 表示列车延误的小时数。
 * <p>
 * 返回列车实际到站的时间。
 * <p>
 * 注意，该问题中的时间采用 24 小时制。
 * <p>
 *
 * 示例 1：
 * 输入：arrivalTime = 15, delayedTime = 5
 * 输出：20
 * 解释：列车正点到站时间是 15:00 ，延误 5 小时，所以列车实际到站的时间是 15 + 5 = 20（20:00）。
 * <p>
 *
 * 示例 2：
 * 输入：arrivalTime = 13, delayedTime = 11
 * 输出：0
 * 解释：列车正点到站时间是 13:00 ，延误 11 小时，所以列车实际到站的时间是 13 + 11 = 24（在 24 小时制中表示为 00:00 ，所以返回 0）。
 * <p>
 *
 * 提示：
 * 1 <= arrivaltime < 24
 * 1 <= delayedTime <= 24
 *
 * @author henengqiang
 * @date 2023/9/8
 * @see <a href="https://leetcode.cn/problems/calculate-delayed-arrival-time/?envType=daily-question&envId=2023-09-08">链接</a>
 */
public class FindDelayedArrivalTime {

    public static void main(String[] args) {
        FindDelayedArrivalTime f = new FindDelayedArrivalTime();
        System.out.println(f.findDelayedArrivalTime(15, 5));
        System.out.println(f.findDelayedArrivalTime(13, 11));
        System.out.println(f.findDelayedArrivalTime(13, 13));
    }

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        // 0ms
        int res = arrivalTime + delayedTime;
        return res == 24 ? 0 : (res > 24 ? res - 24 : res);
    }

    public int findDelayedArrivalTime2(int arrivalTime, int delayedTime) {
        // 0ms
        return (arrivalTime + delayedTime) % 24;
    }

}
