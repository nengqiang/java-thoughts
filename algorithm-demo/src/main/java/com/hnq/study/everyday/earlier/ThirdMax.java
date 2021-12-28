package com.hnq.study.everyday.earlier;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 * @author henengqiang
 * @date 2021/11/21
 * @see <a href="https://leetcode-cn.com/problems/third-maximum-number">链接</a>
 */
public class ThirdMax {

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1};
        System.out.println(thirdMax2(a));
        int[] b = new int[]{1, 2};
        System.out.println(thirdMax2(b));
        int[] c = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax2(c));
        int[] d = new int[]{1};
        System.out.println(thirdMax2(d));
    }

    private static int thirdMax(int[] nums) {
        // 11ms
        if (nums.length == 1) {
            return nums[0];
        }
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return list.size() <= 2 ? list.get(0) : list.get(2);
    }

    /**
     * 1.给三个变量a，b，c初始值设为INT_MIN，目的是记录前三大的数，a>b>c
     *
     * 2.如果num比a都大，那么a，b，c三个值都得更新
     *
     * 如果num被a，b卡住了，更新bc的值
     *
     * 如果num被b，c卡住了，就更新c的值
     *
     * 其他情况：如果比c小，如果等于a或者b或者c了，continue
     *
     * 3.最后理应返回c的值，但是c如果没有值的话，依照题意返回最大的值
     */
    private static int thirdMax2(int[] nums) {
        // 0ms
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

}
