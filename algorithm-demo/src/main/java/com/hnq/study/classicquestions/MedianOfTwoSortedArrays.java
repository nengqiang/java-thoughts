package com.hnq.study.classicquestions;

import java.util.Arrays;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted
 * arrays. The overall run time complexity should be O(log (m+n)).
 *
 * @author henengqiang
 * @date 2019/01/28
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{6, 7, 8, 9};
        findMedianSortedArrays(nums1, nums2);
        nums2 = new int[]{6, 7, 8, 9, 9};
        findMedianSortedArrays(nums1, nums2);
    }

    private static void findMedianSortedArrays(int[] nums1, int[] nums2) {
        System.out.println(String.format("The median of array %s and array %s is",
                Arrays.toString(nums1), Arrays.toString(nums2)));
        System.out.println("By method A: " + findMedianSortedArrays1(nums1, nums2));
        System.out.println("By method B: " + findMedianSortedArrays2(nums1, nums2));
    }

    /**
     * Solution1
     * This problem can be converted to the problem of finding kth element, k is (A's length + B's length) / 2.
     *
     * If any of the two arrays is empty, then the kth element is the non-empty array's kth element.
     * If k == 0, the kth element is the first element of A or B.
     *
     * For normal cases(all other cases), we need to move the pointer at the pace of half of the array size
     * to get log(n) time.
     *
     * Time is O(log(k))
     *
     * @param nums1 sorted array 1
     * @param nums2 sorted array 2
     * @return      the median of the two sorted arrays
     */
    private static Double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int odd = 2;
        if (total % odd == 0) {
            return (findKth1(total / 2 + 1, nums1, nums2, 0, 0)
                    + findKth1(total / 2, nums1, nums2, 0, 0)) / 2.0;
        } else {
            return (double) findKth1(total / 2 + 1, nums1, nums2, 0, 0);
        }
    }

    private static int findKth1(int k, int[] nums1, int[] nums2, int s1, int s2) {
        if (s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }
        if (s2 > nums2.length) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }

        int m1 = s1 + k / 2 - 1;
        int m2 = s2 + k / 2 - 1;

        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findKth1(k - k / 2, nums1, nums2, m1 + 1, s2);
        } else {
            return findKth1(k - k / 2, nums1, nums2, s1, m2 + 1);
        }
    }

    /**
     * Solution 2
     * Actually, we can write the binary search solution in multiple different ways, the following is one of them.
     *
     * @param a sorted array 1
     * @param b sorted array 2
     * @return  the median of the two sorted arrays
     */
    private static Double findMedianSortedArrays2(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int odd = 2;

        if ((m + n) % odd != 0) {
            return (double) findKth2(a, b, (m + n) / 2, 0, m - 1, 0, n - 1);
        } else {
            // even
            return (findKth2(a, b, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth2(a, b, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) / 2.0;
        }
    }

    private static int findKth2(int[] a, int[] b, int k, int aStart, int aEnd, int bStart, int bEnd) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0) {
            return b[bStart + k];
        }
        if (bLen == 0) {
            return a[aStart + k];
        }
        if (k == 0) {
            return a[aStart] < b[bStart] ? a[aStart] : b[bStart];
        }

        // a's middle count
        int aMid = aLen * k / (aLen + bLen);
        // b's middle count
        int bMid = k - aMid - 1;

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (a[aMid] > b[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth2(a, b, k, aStart, aEnd, bStart, bEnd);
    }

}
