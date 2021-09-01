package com.hnq.study.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的前序遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author henengqiang
 * @date 2021/09/01
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-preorder-traversal">链接</a>
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode t4 = null;
        System.out.println(preorderTraversal2(t4));
        TreeNode t1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(preorderTraversal2(t1));
        TreeNode t2 = new TreeNode(1, new TreeNode(2, null, null), null);
        System.out.println(preorderTraversal2(t2));
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    private static List<Integer> preorderTraversal(TreeNode root) {
        // 0ms
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    private static void preorder(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    private static List<Integer> preorderTraversal2(TreeNode root) {
        // 0ms
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }

    private static void pre(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
