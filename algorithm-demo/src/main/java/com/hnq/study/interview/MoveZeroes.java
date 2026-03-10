package com.hnq.study.interview;

import java.util.Arrays;

/**
 * @author henengqiang
 * @since 2026/3/9
 * @see <a href="https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75">移动零</a>
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        int[] n1 = new int[]{1};
        m.moveZeroes2(n1);
        System.out.println(Arrays.toString(n1));
        int[] n2 = new int[]{0, 1, 0, 3, 12};
        m.moveZeroes2(n2);
        System.out.println(Arrays.toString(n2));
    }

    public void moveZeroes(int[] nums) {
        // 2ms
        int len = nums.length, iter = 0, pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pointer = i;
                break;
            }
        }
        while (iter < len) {
            if (nums[iter] == 0) {
                if (iter <= pointer) {
                    nums[iter] = nums[pointer];
                    nums[pointer] = 0;
                    pointer = iter;
                }
            } else if (pointer < iter) {
                nums[pointer + 1] = nums[iter];
                pointer++;
            }
            iter++;
        }
        for (int i = pointer + 1; i < len; i++) {
            nums[i] = 0;
        }
    }

    // 如果数组没有0，那么快慢指针始终指向同一个位置，每个位置自己和自己交换；如果数组有0，快指针先走一步，此时慢指针对应的就是0，所以要交换。
    public void moveZeroes2(int[] nums) {
        int len = nums.length, left = 0, right = 0;
        while (right < len) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }

    // 或者只要一个慢指针，用!=0的nums[i]覆盖慢指针的值，最后补零

}
