package com.hnq.study.everyday;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 * 
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author henengqiang
 * @date 2021/6/17
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-2147483412));
        System.out.println(reverse(123));
        System.out.println(reverse(1230));
        System.out.println(reverse(-123));
        System.out.println(reverse(-1230));
        System.out.println(reverse(-1230));
        System.out.println(reverse(-1234567891));
    }

    private static int reverse(int x) {
        String s = String.valueOf(x);
        boolean neg = false;
        if (s.startsWith("-")) {
            neg = true;
            s = s.substring(1);
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        String max = String.valueOf(Integer.MAX_VALUE);
        int len = max.length();
        int ge = 0;
        if (sb.toString().length() >= len) {
            char[] c1 = sb.toString().toCharArray();
            char[] c2 = max.toCharArray();
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] >= c2[i]) {
                    ge++;
                }
                if (c1[i] > c2[i] && ge >= i + 1) {
                    return 0;
                }
            }
        }
        int y = Integer.parseInt(sb.toString());
        return neg ? -y : y;
    }

}
