package com.hnq.study.interview;

import com.hnq.study.TreeNode;

/**
 * @author henengqiang
 * @since 2026/4/21
 * @see <a href="https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75">二叉树中的最长交错路径</a>
 */
public class LongestZigZag {

    public static void main(String[] args) {
        LongestZigZag l = new LongestZigZag();
        TreeNode t = new TreeNode(1,
                null,
                new TreeNode(1,
                        new TreeNode(1), new TreeNode(1, new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1))),
                        new TreeNode(1))));
        System.out.println(l.longestZigZag(t));

        TreeNode t2 = new TreeNode(1,
                new TreeNode(1, null, new TreeNode(1, new TreeNode(1, null, new TreeNode(1)), new TreeNode(1))),
                new TreeNode(1));
        System.out.println(l.longestZigZag(t2));
    }

    private int ans = 0;

    public int longestZigZag(TreeNode root) {
        // 10ms
       dfs(root, false);
       dfs(root, true);
       return ans;
    }

    private int dfs(TreeNode root, boolean turnRight) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, false);
        int right = dfs(root.right, true);
        ans = Math.max(ans, Math.max(left, right));
        if (turnRight) {
            return left + 1;
        }
        return right + 1;
    }

}
