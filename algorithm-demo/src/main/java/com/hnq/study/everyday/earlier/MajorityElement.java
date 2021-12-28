package com.hnq.study.everyday.earlier;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * @author henengqiang
 * @date 2021/08/02
 * @see <a href="https://leetcode-cn.com/problems/majority-element">链接</a>
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] c = new int[]{6,5,5};
        System.out.println(majorityElement(c));
        int[] b = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(b));
        int[] a = new int[]{3,2,3};
        System.out.println(majorityElement(a));
    }

    /**
     * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
     * 【摩尔投票法思想】
     */
    private static int majorityElement(int[] nums) {
        // 1ms
        int x = nums[0], c = 1;
        for (int num : nums) {
            if (x == num) {
                c++;
            } else {
                c--;
                if (c <= 0) {
                    x = num;
                    c = 1;
                }
            }
        }
        return x;
    }

}













