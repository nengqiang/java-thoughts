package com.hnq.study.everyday.quarter202302;

import com.hnq.study.everyday.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 *
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 *
 * 提示：
 * 树中节点数的范围在 [0, 10^5] 内
 * -1000 <= Node.val <= 1000
 *
 * @author henengqiang
 * @date 2023/4/7
 * @see <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree">链接</a>
 */
public class MinDepth {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(minDepth(t1));

        TreeNode t2 = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
        System.out.println(minDepth(t2));
    }

    private static int minDepth(TreeNode root) {
        // 9ms
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

}
