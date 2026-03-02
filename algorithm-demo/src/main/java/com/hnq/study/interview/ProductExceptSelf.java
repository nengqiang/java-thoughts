package com.hnq.study.interview;

import java.util.Arrays;

/**
 * @author henengqiang
 * @since 2026/3/2
 * @see <a href="https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75">除了自身以外数组的乘积</a>
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf p = new ProductExceptSelf();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1, 2, 3, 4, 5})));
        
        // 测试优化算法
        System.out.println("优化算法结果:");
        System.out.println(Arrays.toString(p.productExceptSelfOptimized(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(p.productExceptSelfOptimized(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(p.productExceptSelfOptimized(new int[]{1, 2, 3, 4, 5})));
    }

    /*
     * prefix 空 a₁      a₁a₂    a₁a₂a₃
     * suffix    a₁a₂a₃   a₂a₃    a₃      空
     * result    a₂a₃     a₁a₃    a₂a₃
     *                   (prefix[i - 1] * suffix[i + 1])
     */
    public int[] productExceptSelf(int[] nums) {
        // 3ms
        int len = nums.length;
        int[] prefix = new int[len], suffix = new int[len];
        // 考虑把最左侧或者最右侧设置为1
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = prefix[i - 1] * nums[i];
            }
            if (i == 0) {
                suffix[len - 1 - i] = nums[len - 1 - i];
            } else {
                suffix[len - 1 - i] = suffix[len - i] * nums[len - 1 - i];
            }
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                res[i] = suffix[i + 1];
            } else if (i == len - 1) {
                res[i] = prefix[len - 1 - 1];
            } else {
                res[i] = prefix[i - 1] * suffix[i + 1];
            }
        }
        return res;
    }

    // 动态构建乘积
    public int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        // 计算左侧乘积
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        // 计算右侧乘积并更新结果
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        
        return res;
    }
}
