package com.hnq.study.everyday.quarter202304;

import java.util.Arrays;

/**
 * 轮转数组
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 * <p>
 *
 * 进阶：
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * @author henengqiang
 * @date 2023/12/29
 * @see <a href="https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150">链接</a>
 */
public class Rotate {

    public static void main(String[] args) {
        Rotate r = new Rotate();
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        r.rotate3(a, 1);
        System.out.println(Arrays.toString(a));
        r.rotate3(a, 2);
        System.out.println(Arrays.toString(a));
        r.rotate3(a, 3);
        System.out.println(Arrays.toString(a));
        // 5,6,7,1,2,3,4

        int[] b = new int[]{-1, -100, 3, 99};
        r.rotate3(b, 2);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 使用额外的数组
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 环状替换
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int i = 0; i < count; i++) {
            int current = i;
            int pre = nums[i];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
            } while (i != current);
        }
    }

    /**
     * 求最大公约数
     */
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    /**
     * 数组翻转：
     * 翻转三遍：第一遍全体翻转，第二编翻转0~k-1之间的，第三遍翻转k~n-1之间的
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
