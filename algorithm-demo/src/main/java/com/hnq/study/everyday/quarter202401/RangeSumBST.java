package com.hnq.study.everyday.quarter202401;

import com.hnq.study.everyday.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 *
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 *
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 *
 * 提示：
 * 树中节点数目在范围 [1, 2 * 10^4] 内
 * 1 <= Node.val <= 10^5
 * 1 <= low <= high <= 10^5
 * 所有 Node.val 互不相同
 *
 * @author henengqiang
 * @date 2024/2/26
 * @see <a href="https://leetcode.cn/problems/range-sum-of-bst/?envType=daily-question&envId=2024-02-26">链接</a>
 */
public class RangeSumBST {

    public static void main(String[] args) {
        RangeSumBST r = new RangeSumBST();
        TreeNode t1 = new TreeNode(10,
                new TreeNode(5, new TreeNode(3), new TreeNode(7)),
                new TreeNode(15, null, new TreeNode(18)));
        System.out.println(r.rangeSumBST(t1, 7, 15));

        TreeNode t2 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(1), null),
                        new TreeNode(7, new TreeNode(6), null)),
                new TreeNode(15, new TreeNode(13), new TreeNode(18)));
        System.out.println(r.rangeSumBST(t2, 6, 10));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        // 0ms
        if (root == null) {
            return 0;
        }
        int val = root.val, ans = 0;
        if (val >= low && val <= high) {
            ans += val;
        }
        if (val > low) {
            ans += rangeSumBST(root.left, low, high);
        }
        if (val < high) {
            ans += rangeSumBST(root.right, low, high);
        }
        return ans;
    }

    /**
     * 深度优先
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    /**
     * 广度优先
     */
    public int rangeSumBST3(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            if (node.val > high) {
                q.offer(node.left);
            } else if (node.val < low) {
                q.offer(node.right);
            } else {
                sum += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sum;
    }

}
