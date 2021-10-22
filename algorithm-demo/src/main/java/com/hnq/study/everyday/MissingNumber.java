package com.hnq.study.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 *
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 * @author henengqiang
 * @date 2021/10/21
 * @see <a href="https://leetcode-cn.com/problems/missing-number">链接</a>
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] n1 = new int[] {3, 0, 1};
        System.out.println(missingNumber3(n1));
        int[] n2 = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber3(n2));
    }

    private static int missingNumber(int[] nums) {
        // 3ms
        int len = nums.length;
        Set<Integer> sets = new HashSet<>(len);
        for (int num : nums) {
            sets.add(num);
        }
        for (int i = 0; i <= len; i++) {
            if (!sets.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 0 ^ 4 = 4
     * 4 ^ 4 = 0
     */
    private static int missingNumber2(int[] nums) {
        // 0ms
        int res = nums.length;
        for (int i = 0, len = nums.length; i < len; i++) {
            res ^= nums[i] ^ i;
        }
        return res;
    }

    /**
     * 从1加到n，减法剩下地 就是缺失的
     */
    private static int missingNumber3(int[] nums) {
        // 0ms
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }

}
