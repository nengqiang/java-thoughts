package com.hnq.study.everyday.quarter202304;

import com.hnq.study.everyday.TreeNode;

/**
 * 二叉搜索树中的搜索
 * <p>
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * <p>
 *
 * 示例 1:
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * <p>
 *
 * 示例 2:
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 * <p>
 *
 * 提示：
 * 树中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 10^7
 * root 是二叉搜索树
 * 1 <= val <= 10^7
 *
 * @author henengqiang
 * @date 2023/11/28
 * @see <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/">链接</a>
 */
public class SearchBST {

    public static void main(String[] args) {
        SearchBST s = new SearchBST();
        TreeNode t1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));
        System.out.println(s.searchBST2(t1, 2));
        System.out.println(s.searchBST2(t1, 5));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        // 0ms
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * 迭代
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

}
