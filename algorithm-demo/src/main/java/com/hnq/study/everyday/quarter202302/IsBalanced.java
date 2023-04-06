package com.hnq.study.everyday.quarter202302;

import com.hnq.study.everyday.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * <p>
 *
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -10^4 <= Node.val <= 10^4
 *
 * @author henengqiang
 * @date 2023/4/4
 * @see <a href="https://leetcode.cn/problems/balanced-binary-tree">链接</a>
 */
public class IsBalanced {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(isBalanced(t1));

        TreeNode t2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(
                        3,
                        new TreeNode(4), new TreeNode(4)),
                        new TreeNode(3)),
                new TreeNode(2));

        System.out.println(isBalanced(t2));
        System.out.println(isBalanced(null));
    }

    private static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private static int height(TreeNode root) {
        // 0ms
        if (root == null) {
            return 0;
        }
        int lh = height(root.left), rh = height(root.right);
        if (lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }

}
