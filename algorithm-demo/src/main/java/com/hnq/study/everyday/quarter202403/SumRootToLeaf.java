package com.hnq.study.everyday.quarter202403;

import com.hnq.study.everyday.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author henengqiang
 * @date 2024/11/1
 */
public class SumRootToLeaf {

    public static void main(String[] args) {
        SumRootToLeaf s = new SumRootToLeaf();
        TreeNode t1 = new TreeNode(1,
                new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1))
        );
        System.out.println(s.sumRootToLeaf(t1));
        System.out.println(s.sumRootToLeaf2(t1));

    }

    /**
     * 后续遍历
     */
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        // 0ms
        if (root == null) {
            return 0;
        }
        val = (val << 1) | root.val;
        if (root.left == null && root .right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }

    public int sumRootToLeaf2(TreeNode root) {
        // 1ms
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        int val = 0, ret = 0;
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                val = (val << 1) | root.val;
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == prev) {
                if (root.left == null && root.right == null) {
                    ret += val;
                }
                val >>= 1;
                stack.pop();
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return ret;
    }

}
