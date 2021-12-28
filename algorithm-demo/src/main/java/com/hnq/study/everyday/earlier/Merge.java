package com.hnq.study.everyday.earlier;

import java.util.Arrays;

/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * @author henengqiang
 * @date 2021/07/21
 * @see <a href="https://leetcode-cn.com/problems/merge-sorted-array">链接</a>
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = new int[] {0};
        int[] nums2 = new int[] {1};
        merge2(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[] {1, 2, 3, 0, 0, 0};
        nums2 = new int[] {2, 5, 6};
        merge2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[] {1};
        nums2 = new int[] {};
        merge2(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 0ms
        int k = m + n - 1;
        for (int i = n - 1; i >= 0; i--) {
            nums1[k--] = nums2[i];
        }
        quickSort(nums1, 0, nums1.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end, baseVal = arr[start];
        while (i < j) {
            while (i < j && arr[j] >= baseVal) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < baseVal) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = baseVal;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 0ms
        int len = m + n;
        for (int i = len - 1; i >= 0; i--) {
            if (m > 0 && n > 0) {
                nums1[i] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
            } else if (m > 0) {
                nums1[i] = nums1[--m];
            } else if (n > 0) {
                nums1[i] = nums2[--n];
            }
        }
    }

}
