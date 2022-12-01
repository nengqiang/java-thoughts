package com.hnq.study.everyday.month202212;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2 小，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author henengqiang
 * @date 2022/12/1
 * @see <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii">链接</a>
 */
public class Intersect {

    public static void main(String[] args) {
        int[] n5 = new int[]{8, 0, 3}, n6 = new int[]{0, 0};
        System.out.println(Arrays.toString(intersect(n5, n6)));

        int[] n1 = new int[]{1, 2, 2, 1}, n2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersect(n1, n2)));

        int[] n3 = new int[]{4, 9, 5}, n4 = new int[]{9, 4, 9, 4, 8, 4};
        System.out.println(Arrays.toString(intersect(n3, n4)));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        // 3ms
        int st = 1001;
        int[] a = new int[st];
        for (int i : nums1) {
            a[i] += 1;
        }

        int[] b = new int[st];
        for (int i : nums2) {
            b[i] += 1;
        }
        int[] c = new int[Math.min(nums1.length, nums2.length)];
        Arrays.fill(c, -1);
        int k = 0;
        for (int i = 0; i < st; i++) {
            if (a[i] > 0 && b[i] > 0) {
                int l = Math.min(a[i], b[i]);
                for (int m = 0; m < l; m++) {
                    c[k++] = i;
                }
            }
        }

        int l = (int) IntStream.range(0, c.length).filter(i -> c[i] >= 0).count();
        int[] d = new int[l];
        System.arraycopy(c, 0, d, 0, d.length);
        return d;
    }

    private static int[] intersect2(int[] nums1, int[] nums2) {
        int[] arr = new int[1002];
        // 先遍历nums1记录各个数的个数
        for (int j : nums1) {
            arr[j]++;
        }
        int size = 0;
        List<Integer> list = new LinkedList<>();
        // 遍历nums2，从arr中查找和nums1有无相同数字，若存在则用list暂存一下，并且将该数字的计数减一，用size记录最后的数组大小
        for (int j : nums2) {
            if (arr[j] != 0) {
                size++;
                arr[j]--;
                list.add(j);
            }
        }
        int[] ans = new int[size];
        int in = 0;
        for (Integer n : list) {
            ans[in++] = n;
        }
        return ans;
    }
}