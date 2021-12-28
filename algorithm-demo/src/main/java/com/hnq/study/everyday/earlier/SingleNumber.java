package com.hnq.study.everyday.earlier;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author henengqiang
 * @date 2021/07/30
 * @see <a href="https://leetcode-cn.com/problems/single-number">链接</a>
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] a = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(a));
        int[] b = new int[]{2,2,1};
        System.out.println(singleNumber(b));
    }

    /**
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     *
     * 任何数于0异或为任何数 0 ^ n => n
     *
     * 相同的数异或为0: n ^ n => 0
     */
    private static int singleNumber(int[] nums) {
        // 1ms
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x;
    }

}














