package com.hnq.study.everyday.quarter202401;

/**
 * 有效的山脉数组
 *
 * @author henengqiang
 * @date 2024/3/25
 * @see <a href="https://leetcode.cn/problems/valid-mountain-array/">链接</a>
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        ValidMountainArray v = new ValidMountainArray();
        System.out.println(v.validMountainArray(new int[]{1, 1, 1, 1, 1, 1, 1, 2, 1}));

        System.out.println(v.validMountainArray(new int[]{4, 4, 3, 2, 1}));

        System.out.println(v.validMountainArray(new int[]{1, 3, 1}));
        System.out.println(v.validMountainArray(new int[]{3, 1, 3}));

        System.out.println(v.validMountainArray(new int[]{2, 1}));
        System.out.println(v.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(v.validMountainArray(new int[]{0, 3, 2, 1}));

        System.out.println(v.validMountainArray(new int[]{3, 3}));
        System.out.println(v.validMountainArray(new int[]{3, 1}));
    }

    public boolean validMountainArray(int[] arr) {
        // 2ms
        boolean top = false;
        int upCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            if (top) {
                if (arr[i] < arr[i + 1]) {
                    return false;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    top = true;
                } else {
                    upCount++;
                }
            }
        }
        return upCount > 0 && top;
    }

    /**
     * 线性扫描
     */
    public boolean validMountainArray2(int[] arr) {
        // 1ms
        int n = arr.length, i = 0;

        // 递增扫描
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == n - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }


}
