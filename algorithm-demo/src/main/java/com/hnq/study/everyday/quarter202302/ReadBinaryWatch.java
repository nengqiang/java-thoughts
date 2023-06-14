package com.hnq.study.everyday.quarter202302;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * 例如，下面的二进制手表读取 "3:25" 。
 * <p>
 *
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。
 * 你可以 按任意顺序 返回答案。
 * <p>
 * 小时不会以零开头：
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * <p>
 * 分钟必须由两位数组成，可能会以零开头：
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 *
 * 示例 1：
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * <p>
 * 示例 2：
 * 输入：turnedOn = 9
 * 输出：[]
 * <p>
 *
 * 提示：
 * 0 <= turnedOn <= 10
 *
 * @author henengqiang
 * @date 2023/6/14
 * @see <a href="https://leetcode.cn/problems/binary-watch">链接</a>
 */
public class ReadBinaryWatch {

    public static void main(String[] args) {
        ReadBinaryWatch r = new ReadBinaryWatch();
        System.out.println(r.readBinaryWatch2(1));
    }

    /**
     * 方法一：枚举时分     
     * 由题意可知，小时由4个比特表示，分钟由6个比特表示，比特位值为0表示灯灭，为1表示灯亮。
     * 我们可以枚举小时的所有可能值[0,11]，以及分钟的所有可能值[0,59]，
     * 并计算二者的二进制中1的个数之和，若为turnedOn，则将其加入到答案中。
     */
    public List<String> readBinaryWatch(int turnedOn) {
        // 10ms
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

    /**
     * 方法二：二进制枚举
     * 另一种枚举方法是枚举所有2^10=1024种灯的开闭组合，即用一个二进制数表示灯的开闭，
     * 其中高4位为小时，低6位为分钟。若小时和分钟的值均在合法范围内，且二进制中1的个数为turnedOn，
     * 则将其加入到答案中。
     */
    public List<String> readBinaryWatch2(int turnedOn) {
        // 10ms
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            // 用位运算取出高 4 位和低 6 位
            int h = i >> 6, m = i & 63;
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }

}
