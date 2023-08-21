package com.hnq.study.everyday.quarter202303;

/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 *
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 * <p>
 *
 * 示例 2:
 * 输入: num = -7
 * 输出: "-10"
 * <p>
 *
 * 提示：
 * -10^7 <= num <= 10^7
 *
 * @author henengqiang
 * @date 2023/8/21
 */
public class ConvertToBase7 {

    public static void main(String[] args) {
        ConvertToBase7 c = new ConvertToBase7();
        System.out.println(c.convertToX(100, 7));
        System.out.println(c.convertToX(-7, 7));
    }

    public String convertToBase7(int num) {
        // 0ms
        return Integer.toString(num, 7);
    }

    public String convertToBase72(int num) {
        // 1ms
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "0";
        }
        boolean ne = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (ne) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public String convertToX(int num, int x) {
        // 1ms
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean ne = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            sb.insert(0, num % x);
            num /= x;
        }
        if (ne) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }

}
