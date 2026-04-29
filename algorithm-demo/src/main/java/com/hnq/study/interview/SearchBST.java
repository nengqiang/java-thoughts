package com.hnq.study.interview;

import com.hnq.study.TreeNode;

/**
 * @author henengqiang
 * @since 2026/4/29
 * @see <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/submissions/721971701/?envType=study-plan-v2&envId=leetcode-75">二叉搜索树中的搜索</a>
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
        return search(root, val);
    }

    private TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val ? search(root.left, val) : search(root.right, val);
    }

    /**
     * 迭代
     */
    private TreeNode searchBST2(TreeNode root, int val) {
        // 0ms
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

}
