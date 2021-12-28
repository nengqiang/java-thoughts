package com.hnq.study.everyday.earlier;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]  
 *    1
 *     \
 *      2
 *     /
 *    3 
 *
 * 输出: [3,2,1]
 *
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author henengqiang
 * @date 2021/9/13
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-postorder-traversal">链接</a>
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(postorderTraversal(root));
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        // 0ms
        List<Integer> list = new ArrayList<>();
        postorder(root,list);
        return list;
    }

    private static void postorder(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
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
