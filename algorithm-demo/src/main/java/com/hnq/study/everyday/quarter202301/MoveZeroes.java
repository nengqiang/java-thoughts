package com.hnq.study.everyday.quarter202301;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 *
 * 提示:
 * 1 <= nums.length <= 10^4
 * -2^31<= nums[i] <= 2^31- 1
 * <p>
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * @author henengqiang
 * @date 2023/2/14
 * @see <a href="https://leetcode.cn/problems/move-zeroes">链接</a>
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] n5 = new int[]{73348, 66106, -85359, 53996, 18849, -6590, -53381, -86613, -41065, 83457, 0};
        moveZeroes3(n5);
        System.out.println(Arrays.toString(n5));
        int[] n1 = new int[]{0, 1, 0, 3, 12};
        moveZeroes3(n1);
        System.out.println(Arrays.toString(n1));
        int[] n4 = new int[]{0, 0, 1};
        moveZeroes3(n4);
        System.out.println(Arrays.toString(n4));
        int[] n3 = new int[]{0, 1};
        moveZeroes3(n3);
        System.out.println(Arrays.toString(n3));
        int[] n2 = new int[]{0};
        moveZeroes3(n2);
        System.out.println(Arrays.toString(n2));
    }

    private static void moveZeroes(int[] nums) {
        // 1ms 43MB
        int k = nums.length;
        if (k == 1) {
            return;
        }
        int t = 0, j = 0;
        for (int num : nums) {
            if (num != 0) {
                t++;
            }
        }
        int[] tmp = new int[t];
        for (int num : nums) {
            if (num != 0) {
                tmp[j++] = num;
            }
        }
        for (int i = 0; i < k; i++) {
            if (i < t) {
                nums[i] = tmp[i];
            } else {
                nums[i] = 0;
            }
        }
    }

    private static void moveZeroes2(int[] nums) {
        // 60ms 42.8MB
        int k = nums.length;
        if (k == 1) {
            return;
        }

        int p = k - 1;
        for (int i = p; i >= 0; i--) {
            if (nums[i] == 0 && i < p) {
                for (int j = i; j < p; j++) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
                p--;
            }
        }

    }

    /**
     * 设置一个index，表示非0数的个数，循环遍历数组，
     * 如果不是0，将非0值移动到第index位置,然后index + 1
     * 遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
     */
    private static void moveZeroes3(int[] nums) {
        // 1ms 42.7MB
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
