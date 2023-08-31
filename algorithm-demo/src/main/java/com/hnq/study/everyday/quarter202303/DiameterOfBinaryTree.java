package com.hnq.study.everyday.quarter202303;

import com.hnq.study.everyday.TreeNode;

/**
 * 二叉树的直径
 * <p>
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 * <p>
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,2]
 * 输出：1
 * <p>
 *
 * 提示：
 * 树中节点数目在范围 [1, 10^4] 内
 * -100 <= Node.val <= 100
 *
 * @author henengqiang
 * @date 2023/8/31
 * @see <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">链接</a>
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        TreeNode t1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(d.diameterOfBinaryTree(t1));
    }

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // 0ms
        depth(root);
        return ans;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左儿子为根的子树的深度
        int l = depth(root.left);
        // 右儿子为根的子树的深度
        int r = depth(root.right);
        // 计算d_n 即 L + R 并更新ans
        ans = Math.max(ans, l + r);
        // 返回该节点为根的子树的深度
        return Math.max(l, r) + 1;
    }

}
