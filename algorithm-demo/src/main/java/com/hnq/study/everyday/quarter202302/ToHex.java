package com.hnq.study.everyday.quarter202302;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用补码运算方法。
 * <p>
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，
 * 十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * <p>
 *
 * 示例 1：
 * 输入:
 * 26
 * 输出:
 * "1a"
 * <p>
 *
 * 示例 2：
 * 输入:
 * -1
 * 输出:
 * "ffffffff"
 * 
 * @author henengqiang
 * @date 2023/6/14
 * @see <a href="https://leetcode.cn/problems/convert-a-number-to-hexadecimal">链接</a>
 */
public class ToHex {

    public static void main(String[] args) {
        ToHex h = new ToHex();
        System.out.println(h.toHex(26));
        System.out.println(h.toHex(-1));
    }

    /**
     * 【笔记】核心思想，使用位运算，每4位，对应1位16进制数字。
     * 使用0xf(00...01111b)获取num的低4位。
     * >>算数位移，其中正数右移左边补0，负数右移左边补1。
     * 位移运算并不能保证num==0，需要使用32位int保证（对应16进制小于等于8位）。
     * 使用string直接进行字符串拼接....
     */
    public String toHex(int num) {
        // 0ms
        if (num == 0) {
            return "0";
        }
        String hex = "0123456789abcdef";
        StringBuilder ans = new StringBuilder();
        while (num != 0 && ans.length() < 8) {
            ans.insert(0, hex.charAt(num & 0xf));
            num >>= 4;
        }
        return ans.toString();
    }

}
