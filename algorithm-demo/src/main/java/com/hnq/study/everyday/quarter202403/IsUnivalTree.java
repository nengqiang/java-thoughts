package com.hnq.study.everyday.quarter202403;

import com.hnq.study.everyday.TreeNode;

/**
 * @author henengqiang
 * @date 2024/9/23
 */
public class IsUnivalTree {

    public static void main(String[] args) {
        IsUnivalTree i = new IsUnivalTree();

        TreeNode t3 = new TreeNode(0);
        System.out.println(i.isUnivalTree(t3));

        TreeNode t1 = new TreeNode(1,
                new TreeNode(1, new TreeNode(1), new TreeNode(1)),
                new TreeNode(1, null, new TreeNode(1)));
        System.out.println(i.isUnivalTree(t1));

        TreeNode t2 = new TreeNode(2,
                new TreeNode(2, new TreeNode(5), new TreeNode(2)),
                new TreeNode(2));
        System.out.println(i.isUnivalTree(t2));
    }

    public boolean isUnivalTree(TreeNode root) {
        // 0ms
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.val != root.left.val || !isUnivalTree(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val != root.right.val || !isUnivalTree(root.right)) {
                return false;
            }
        }
        return true;
    }

}
