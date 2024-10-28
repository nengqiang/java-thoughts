package com.hnq.study.everyday.quarter202403;

import java.util.Arrays;

/**
 * @author henengqiang
 * @date 2024/10/28
 */
public class CanThreePartsEqualSum {

    public static void main(String[] args) {
        CanThreePartsEqualSum c = new CanThreePartsEqualSum();
        System.out.println(c.canThreePartsEqualSum(new int[]{10, -10, 10, -10, 10, -10, 10, -10}));
        System.out.println(c.canThreePartsEqualSum(new int[]{0, 0, 0, 0}));
        System.out.println(c.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(c.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(c.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
    }

    public boolean canThreePartsEqualSum(int[] arr) {
        // 5ms
        int s;
        s = Arrays.stream(arr).sum();
        if (s % 3 != 0) {
            return false;
        }
        int target = s / 3, n = arr.length, i = 0, cur = 0;
        while (i < n) {
            cur += arr[i];
            if (cur == target) {
                break;
            }
            ++i;
        }
        if (cur != target) {
            return false;
        }
        int j = i + 1;
        while (j + 1 < n) {
            cur += arr[j];
            if (cur == target * 2) {
                return true;
            }
            ++j;
        }
        return false;
    }

}
