package com.hnq.study.everyday.quarter202304;

import java.util.Arrays;

/**
 * 错误的集合
 * <p>
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 *
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 *
 * 提示：
 * 2 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^4
 *
 * @author henengqiang
 * @date 2023/10/25
 * @see <a href="https://leetcode.cn/problems/set-mismatch/">链接</a>
 */
public class FindErrorNums {

    public static void main(String[] args) {
        FindErrorNums f = new FindErrorNums();
        System.out.println(Arrays.toString(f.findErrorNums2(new int[]{3, 2, 3, 4, 6, 5})));
        System.out.println(Arrays.toString(f.findErrorNums2(new int[]{2, 3 ,3, 4, 5, 6})));
        System.out.println(Arrays.toString(f.findErrorNums2(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(f.findErrorNums2(new int[]{1, 3, 3, 4})));
        System.out.println(Arrays.toString(f.findErrorNums2(new int[]{1, 2, 4, 4})));
        System.out.println(Arrays.toString(f.findErrorNums2(new int[]{1, 1})));
    }

    public int[] findErrorNums(int[] nums) {
        // 1ms
        int len = nums.length, p = 0, q = 0;
        int[] t = new int[len + 1];
        for (int num : nums) {
            if (t[num] == 0) {
                t[num] = 1;
            } else {
                p = num;
            }
        }
        for (int i = 1, limit = len + 1; i <= limit; i++) {
            if (t[i] == 0) {
                q = i;
                break;
            }
        }
        return new int[] {p, q};
    }

    /**
     * 位运算
     */
    public int[] findErrorNums2(int[] nums) {
        // 2ms
        int n = nums.length;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int lowBit = xor & (-xor);
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & lowBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lowBit) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        for (int num : nums) {
            if (num == num1) {
                return new int[]{num1, num2};
            }
        }
        return new int[]{num2, num1};
    }

}
