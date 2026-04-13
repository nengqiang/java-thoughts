package com.hnq.study.interview;

import com.hnq.study.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author henengqiang
 * @since 2026/4/13
 * @see <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=leetcode-75">二叉树的最大深度</a>
 */
public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth m = new MaxDepth();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(m.maxDepth2(root));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(m.maxDepth2(root2));
    }

    public int maxDepth(TreeNode root) {
        // 0ms
        if (root == null) {
            return 0;
        }
        // if (root.left != null && root.right != null) {
        //     return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
        // }
        // if (root.left != null) {
        //     return 1 + maxDepth(root.left);
        // }
        // if (root.right != null) {
        //     return 1 + maxDepth(root.right);
        // }
        // return 1;
        int leftDepth = maxDepth(root.left);
        int rightDept = maxDepth(root.right);
        return Math.max(leftDepth, rightDept) + 1;
    }

    /**
     * 广度优先搜索
     */
    public int maxDepth2(TreeNode root) {
        // 1ms
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

}
