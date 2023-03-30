package com.hnq.study.everyday.quarter202301;

import com.hnq.study.everyday.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 *
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * <p>
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * <p>
 *
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author henengqiang
 * @date 2023/2/3
 * @see <a href="https://leetcode.cn/problems/invert-binary-tree">链接</a>
 */
public class InvertTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(invertTree(t1));

        TreeNode t2 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(invertTree(t2));
    }

    public static TreeNode invertTree(TreeNode root) {
        // 0ms 39MB
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
