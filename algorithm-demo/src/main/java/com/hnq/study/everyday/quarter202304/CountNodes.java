package com.hnq.study.everyday.quarter202304;

import com.hnq.study.everyday.TreeNode;

/**
 * 完全二叉树的节点个数
 * <p>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2^h 个节点。
 * <p>
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * <p>
 *
 * 示例 2：
 * 输入：root = []
 * 输出：0
 * <p>
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 * <p>
 *
 * 提示：
 * 树中节点的数目范围是[0, 5 * 10^4]
 * 0 <= Node.val <= 5 * 10^4
 * 题目数据保证输入的树是 完全二叉树
 * <p>
 *
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 *
 * @author henengqiang
 * @date 2023/10/24
 * @see <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">链接</a>
 */
public class CountNodes {

    public static void main(String[] args) {
        CountNodes c = new CountNodes();
        TreeNode t1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));
        System.out.println(c.countNodes2(t1));
    }

    public int countNodes(TreeNode root) {
        // 0ms
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 二分查找 + 位运算
     */
    public int countNodes2(TreeNode root) {
        // 0ms
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

}
