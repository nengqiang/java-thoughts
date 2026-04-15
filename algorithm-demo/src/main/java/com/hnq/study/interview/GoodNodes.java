package com.hnq.study.interview;

import com.hnq.study.TreeNode;

/**
 * @author henengqiang
 * @since 2026/4/15
 * @see <a href="https://leetcode.cn/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75">统计二叉树中好节点的数目</a>
 */
public class GoodNodes {

    public static void main(String[] args) {
        GoodNodes g = new GoodNodes();
        System.out.println(g.goodNodes(new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null)));
        System.out.println(g.goodNodes(new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)))));
        System.out.println(g.goodNodes(new TreeNode(3, new TreeNode(3, null, new TreeNode(4)), new TreeNode(2))));
        System.out.println(g.goodNodes(new TreeNode(1)));
    }

    private static int count = 0;

    public int goodNodes(TreeNode root) {
        // 3ms
        count = 0;
        dfs(root, root.val);
        return count;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            count++;
        }
        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
    }

}
