package com.hnq.study.interview;

import com.hnq.study.TreeNode;

/**
 * @author henengqiang
 * @since 2026/5/18
 * @see <a href="https://leetcode.cn/problems/delete-node-in-a-bst/?envType=study-plan-v2&envId=leetcode-75">删除二叉搜索树中的节点</a>
 */
public class DeleteNode {

    public static void main(String[] args) {
        DeleteNode d = new DeleteNode();
        TreeNode t1 = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));
        System.out.println(d.deleteNode2(t1, 3));

        System.out.println(d.deleteNode2(t1, 0));
        System.out.println(d.deleteNode2(null, 0));
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // 0ms
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.right == null) {
            return root.left;
        }
        if (root.left == null) {
            return root.right;
        }
        TreeNode successor = root.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        root.right = deleteNode(root.right, successor.val);
        successor.right = root.right;
        successor.left = root.left;
        return successor;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        // 0ms
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = curParent.left;
            } else {
                cur = cur.right;
            }
        }

        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.right == null) {
            cur = cur.left;
        } else if (cur.left == null) {
            cur = cur.right;
        } else {
            TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }

        if (curParent == null) {
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
    }

}
