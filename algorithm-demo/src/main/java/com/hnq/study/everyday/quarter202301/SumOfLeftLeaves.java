package com.hnq.study.everyday.quarter202301;

import com.hnq.study.everyday.TreeNode;

/**
 * 给定二叉树的根节点root，返回所有左叶子之和。
 * <p>
 * 示例 1：
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24 
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 示例2:
 * 输入: root = [1]
 * 输出: 0
 * <p>
 * 提示:
 * 节点数在[1, 1000]范围内
 * -1000 <= Node.val <= 1000
 *
 * @author henengqiang
 * @date 2023/3/22
 * @see <a href="https://leetcode.cn/problems/sum-of-left-leaves">链接</a>
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(sumOfLeftLeaves(n1));
        TreeNode n2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(sumOfLeftLeaves(n2));
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        // 0ms
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        return sum(root.left, true) + sum(root.right, false);
    }

    private static int sum(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            }
            return 0;
        }
        return sum(root.left, true) + sum(root.right, false);
    }

    public static int sumOfLeftLeaves2(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private static int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            if (isLeft) {
                return root.val;
            }
            return 0;
        }

        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static int sumOfLeftLeaves3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int res = 0;
        // 判断节点是否是左叶子节点，如果是则将它的和累计起来
        if(root.left != null && root.left.left == null && root.left.right == null){
            res += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + res;
    }

}
