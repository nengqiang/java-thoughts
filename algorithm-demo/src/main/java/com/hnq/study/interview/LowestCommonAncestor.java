package com.hnq.study.interview;

import com.hnq.study.TreeNode;

/**
 * @author henengqiang
 * @since 2026/4/22
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75">二叉树的最近公共祖先</a>
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor l = new LowestCommonAncestor();
        TreeNode t1 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(l.lowestCommonAncestor(t1, new TreeNode(5), new TreeNode(1)));

        TreeNode t2 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(l.lowestCommonAncestor(t2, new TreeNode(5), new TreeNode(4)));

        TreeNode t3 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(l.lowestCommonAncestor(t3, new TreeNode(1), new TreeNode(2)));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 7ms
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode r = lowestCommonAncestor(root.right , p , q);
        TreeNode l = lowestCommonAncestor(root.left , p , q);
        return l == null ? r : (r == null ? l : root);
    }


}
