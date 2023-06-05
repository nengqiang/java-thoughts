package com.hnq.study.everyday.quarter202302;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的数组 nums ，数组大小为 n ，且由 非负 整数组成。
 * <p>
 * 你需要对数组执行 n - 1 步操作，其中第 i 步操作（从 0 开始计数）要求对 nums 中第 i 个元素执行下述指令：
 * <p>
 * 如果 nums[i] == nums[i + 1] ，则 nums[i] 的值变成原来的 2 倍，nums[i + 1] 的值变成 0 。否则，跳过这步操作。
 * 在执行完 全部 操作后，将所有 0 移动 到数组的 末尾 。
 * <p>
 * 例如，数组 [1,0,2,0,0,1] 将所有 0 移动到末尾后变为 [1,2,1,0,0,0] 。
 * 返回结果数组。
 * <p>
 * 注意 操作应当 依次有序 执行，而不是一次性全部执行。
 * <p>
 *
 * 示例 1：
 * 输入：nums = [1,2,2,1,1,0]
 * 输出：[1,4,2,0,0,0]
 * 解释：执行以下操作：
 * - i = 0: nums[0] 和 nums[1] 不相等，跳过这步操作。
 * - i = 1: nums[1] 和 nums[2] 相等，nums[1] 的值变成原来的 2 倍，nums[2] 的值变成 0 。数组变成 [1,4,0,1,1,0] 。
 * - i = 2: nums[2] 和 nums[3] 不相等，所以跳过这步操作。
 * - i = 3: nums[3] 和 nums[4] 相等，nums[3] 的值变成原来的 2 倍，nums[4] 的值变成 0 。数组变成 [1,4,0,2,0,0] 。
 * - i = 4: nums[4] 和 nums[5] 相等，nums[4] 的值变成原来的 2 倍，nums[5] 的值变成 0 。数组变成 [1,4,0,2,0,0] 。
 * 执行完所有操作后，将 0 全部移动到数组末尾，得到结果数组 [1,4,2,0,0,0] 。
 * <p>
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 解释：无法执行任何操作，只需要将 0 移动到末尾。
 * <p>
 *
 * 提示：
 * 2 <= nums.length <= 2000
 * 0 <= nums[i] <= 1000
 *
 * @author henengqiang
 * @date 2023/6/5
 * @see <a href="https://leetcode.cn/problems/apply-operations-to-an-array">链接</a>
 */
public class ApplyOperations {

    public static void main(String[] args) {
        int[] n4 = new int[]{2, 1};
        System.out.println(Arrays.toString(applyOperations2(n4)));

        int[] n3 = new int[]{312, 312, 436, 892, 0, 0, 528, 0, 686, 516, 0, 0, 0, 0, 0, 445, 445, 445, 445, 445, 445, 984, 984, 984, 0, 0, 0, 0, 168, 0, 0, 647, 41, 203, 203, 241, 241, 0, 628, 628, 0, 875, 875, 0, 0, 0, 803, 803, 54, 54, 852, 0, 0, 0, 958, 195, 590, 300, 126, 0, 0, 523, 523};
        System.out.println(Arrays.toString(applyOperations2(n3)));

        int[] n2 = new int[]{0, 1};
        System.out.println(Arrays.toString(applyOperations2(n2)));

        int[] n1 = new int[]{1, 2, 2, 1, 1, 0};
        System.out.println(Arrays.toString(applyOperations2(n1)));
    }

    private static int[] applyOperations(int[] nums) {
        // 1ms
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int j = 0, k = 0;
        while (j < len - 1 && k < len - 1) {
            if (nums[j] == 0) {
                if (k == 0) {
                    k = j + 1;
                }
                while (nums[k] == 0) {
                    if (k >= len - 1) {
                        break;
                    }
                    k++;
                }
                if (k <= len - 1) {
                    nums[j] ^= nums[k];
                    nums[k] ^= nums[j];
                    nums[j] ^= nums[k];
                }
            }
            j++;
        }

        return nums;
    }

    /**
     * 在遍历数组时，遇到前后相等的两个元素时直接进行变换，
     * 在遍历的同时进行原地交换，将所有非零的元素移动到数组的头部。
     */
    private static int[] applyOperations2(int[] nums) {
        // 0ms
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }

}
