package com.hnq.study.everyday.quarter202403;

import java.util.Arrays;

/**
 * @author henengqiang
 * @date 2024/9/24
 */
public class LargestPerimeter {

    public static void main(String[] args) {
        LargestPerimeter l = new LargestPerimeter();
        System.out.println(l.largestPerimeter2(new int[]{2, 1, 2}));
        System.out.println(l.largestPerimeter2(new int[]{1, 2, 1, 10}));
    }

    public int largestPerimeter(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            for (int j = i + 1; j <= nums.length - 2; j++) {
                for (int k = j + 1; k <= nums.length - 1; k++) {
                    boolean a = nums[i] >= nums[j] && nums[i] >= nums[k] && nums[i] < nums[j] + nums[k];
                    boolean b = nums[j] >= nums[i] && nums[j] >= nums[k] && nums[j] < nums[i] + nums[k];
                    boolean c = nums[k] >= nums[i] && nums[k] >= nums[j] && nums[k] < nums[i] + nums[j];
                    if (a || b || c) {
                        maxLength = Math.max(maxLength, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return maxLength;
    }

    public int largestPerimeter2(int[] nums) {
        // 8ms
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }

}
