package com.hnq.study.everyday.quarter202401;

import com.hnq.study.everyday.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序搜索树
 * <p>
 * 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 *
 * 示例 1：
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 *
 * 示例 2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * <p>
 *
 * 提示：
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 *
 * @author henengqiang
 * @date 2024/3/5
 * @see <a href="https://leetcode.cn/problems/increasing-order-search-tree/">链接</a>
 */
public class IncreasingBST {

    public static void main(String[] args) {
        IncreasingBST i = new IncreasingBST();
        TreeNode t3 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), null));
        System.out.println(i.increasingBST(t3));

        TreeNode t1 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4)),
                new TreeNode(6,
                        null,
                        new TreeNode(8,
                                new TreeNode(7),
                                new TreeNode(9)))
        );
        System.out.println(i.increasingBST(t1));

        TreeNode t2 = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        System.out.println(i.increasingBST(t2));
    }

    public TreeNode increasingBST(TreeNode root) {
        // 0ms
        List<TreeNode> nodes = new ArrayList<>();
        incBst(root, nodes);
        TreeNode ans = null;
        for (int i = nodes.size() - 1; i >= 0; i--) {
            TreeNode node = nodes.get(i);
            if (ans != null) {
                node.right = ans;
            }
            node.left = null;
            ans = node;
        }
        return ans;
    }

    public void incBst(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        incBst(root.left, nodes);
        nodes.add(root);
        incBst(root.right, nodes);
    }

    private TreeNode ans;
    public TreeNode increasingBST2(TreeNode root) {
        // 0ms
        TreeNode dn = new TreeNode(-1);
        ans = dn;
        inorder(root);
        return dn.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        // 在中序遍历的过程中修改节点指向
        ans.right = node;
        node.left = null;
        ans = node;
        inorder(node.right);
    }

}
