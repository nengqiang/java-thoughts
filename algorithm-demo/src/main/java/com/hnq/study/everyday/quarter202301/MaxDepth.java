package com.hnq.study.everyday.quarter202301;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 * 
 * @author henengqiang
 * @date 2023/1/30
 * @see <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree">链接</a>
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7,
                                null,
                                new TreeNode(1, null, null))));
        System.out.println(maxDepth(n1));
    }

    private static int maxDepth(TreeNode root) {
        // 0ms 41.4 MB
        if (root == null) {
            return 0;
        }
        int lMax = maxDepth(root.left) + 1;
        int rMax = maxDepth(root.right) + 1;
        return Math.max(lMax, rMax);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
