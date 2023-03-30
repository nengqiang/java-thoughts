package com.hnq.study.everyday.quarter202301;

import com.hnq.study.everyday.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 
 * 示例 1：
 * <p>
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * <p>
 *
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 *
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 按 严格递增 顺序排列
 *
 * @author henengqiang
 * @date 2023/1/31
 * @see <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree">链接</a>
 */
public class SortedArrayToBst {

    public static void main(String[] args) {
        int[] n2 = new int[]{-1, 0, 1, 2};
        System.out.println(sortedArrayToBst(n2));
        System.out.println(sortedArrayToBst2(n2));

        int[] n1 = new int[]{-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBst(n1));
        System.out.println(sortedArrayToBst2(n1));
    }

    private static TreeNode sortedArrayToBst(int[] nums) {
        // 0ms 41.4MB
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] ln = new int[mid], rn = new int[nums.length - mid - 1];
        System.arraycopy(nums, 0, ln, 0, mid);
        System.arraycopy(nums, mid + 1, rn, 0, nums.length - mid - 1);
        root.left = sortedArrayToBst(ln);
        root.right = sortedArrayToBst(rn);
        return root;
    }

    private static TreeNode sortedArrayToBst2(int[] nums) {
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }

}
