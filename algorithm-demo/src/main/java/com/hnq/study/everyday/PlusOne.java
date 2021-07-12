package com.hnq.study.everyday;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 * 
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author henengqiang
 * @date 2021/07/12
 * @see <a href="https://leetcode-cn.com/problems/plus-one">链接</a>
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 8, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }

    private static int[] plusOne(int[] digits) {
        // 0ms
        int len = digits.length;
        boolean ao = true;
        for (int digit : digits) {
            if (digit < 9) {
                ao = false;
                break;
            }
        }
        int resLen = ao ? len + 1 : len;
        int[] res = new int[resLen];
        boolean ca = digits[len - 1] + 1 > 9;
        res[resLen - 1] = ca ? 0 : digits[len - 1] + 1;
        for (int i = len - 2; i >= 0; i--) {
            int resIdx = ao ? i + 1 : i;
            if (ca) {
                // 如果上一位有进位则继续判断这一位是否有进位
                ca = digits[i] + 1 > 9;
                res[resIdx] = ca ? 0 : digits[i] + 1;
            } else {
                // 否则后面的都不会有进位了
                res[resIdx] = digits[i];
            }
        }
        // 全为9的情况
        if (ao && res[1] == 0) {
            res[0] = 1;
        }
        return res;
    }

}
