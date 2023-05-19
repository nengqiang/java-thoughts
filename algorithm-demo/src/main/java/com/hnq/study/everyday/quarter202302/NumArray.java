package com.hnq.study.everyday.quarter202302;

/**
 * 给定一个整数数组 nums，处理以下类型的多个查询:
 * <p>
 * 计算索引left和right（包含 left 和 right）之间的 nums 元素的和 ，其中left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的 总和 ，
 * 包含left和right两点（也就是nums[left] + nums[left + 1] + ... + nums[right])
 * <p>
 *
 * 示例 1：
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * <p>
 * 解释：
 * <pre>
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * </pre>
 * <p>
 *
 * 提示：
 * 1 <= nums.length <= 10^4
 * -10^5<= nums[i] <=10^5
 * 0 <= i <= j < nums.length
 * 最多调用 10^4 次 sumRange 方法
 * <pre>
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 * </pre>
 *
 * @author henengqiang
 * @date 2023/5/19
 * @see <a href="https://leetcode.cn/problems/range-sum-query-immutable">链接</a>
 */
public class NumArray {

    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        // 55ms
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += this.nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray2 a1 = new NumArray2(n1);
        System.out.println(a1.sumRange2(0, 2));
        System.out.println(a1.sumRange2(2, 5));
        System.out.println(a1.sumRange2(0, 5));
    }

    private static class NumArray2{
        // 7ms
        private final int[] sums;
        public NumArray2(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange2(int i, int j) {
            return sums[j + 1] - sums[i];
        }

    }

}

