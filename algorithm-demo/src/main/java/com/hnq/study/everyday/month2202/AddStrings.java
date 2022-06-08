package com.hnq.study.everyday.month2202;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 *
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 *
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 *
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 * 提示：
 * 1 <= num1.length, num2.length <= 10^4
 * num1 和num2 都只包含数字0-9
 * num1 和num2 都不包含任何前导零
 *
 * @author henengqiang
 * @date 2022/02/25
 * @see <a href="https://leetcode-cn.com/problems/add-strings">链接</a>
 */
public class AddStrings {

    public static void main(String[] args) {
        String res4 = addStrings2("0", "0");
        String res1 = addStrings2("123", "45");
        String res2 = addStrings2("123", "88");
        String res3 = addStrings2("199", "1");
        System.out.println(res4);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    private static String addStrings(String num1, String num2) {
        // 8ms
        int len = Math.max(num1.length(), num2.length());
        int[] a = new int[len], b = new int[len];
        int i = len, j = len;
        char[] arr1 = num1.toCharArray(), arr2 = num2.toCharArray();
        for (int k = arr1.length - 1; k >= 0; k--) {
            a[--i] = arr1[k] - '0';
        }
        for (int k = arr2.length - 1; k >= 0; k--) {
            b[--j] = arr2[k] - '0';
        }

        int[] z = new int[len + 1];
        int ca = 0;
        for (int k = len - 1; k >= 0; k--) {
            int t = a[k] + b[k] + ca;
            ca = t / 10;
            z[k + 1] = t % 10;
        }
        if (ca > 0) {
            z[0] = ca;
        }

        return IntStream.range(0, z.length)
                .filter(k -> !(k == 0 && z[k] <= 0))
                .mapToObj(k -> String.valueOf(z[k]))
                .collect(Collectors.joining());
    }

    /**
     * 字符串加法、链表加法以及二进制加法之类的都可以这么写
     */
    private static String addStrings2(String num1, String num2) {
        // 1ms
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

}
