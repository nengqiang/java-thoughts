package com.hnq.study.everyday.quarter202401;

import com.hnq.study.everyday.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树节点最小距离
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 *
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 *
 * 提示：
 * 树中节点的数目范围是 [2, 100]
 * 0 <= Node.val <= 10^5
 *
 * @author henengqiang
 * @date 2024/1/5
 * @see <a href="https://leetcode.cn/problems/minimum-distance-between-bst-nodes/">链接</a>
 */
public class MinDiffInBST {

    public static void main(String[] args) {
        MinDiffInBST m = new MinDiffInBST();
        TreeNode t3 = new TreeNode(90,
                new TreeNode(69,
                        new TreeNode(49, null, new TreeNode(52)),
                        new TreeNode(89)),
                null);
        System.out.println(m.minDiffInBST2(t3));

        TreeNode t2 = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(48,
                        new TreeNode(12),
                        new TreeNode(49)));
        System.out.println(m.minDiffInBST2(t2));

        TreeNode t1 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(6));
        System.out.println(m.minDiffInBST2(t1));

    }

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1, k = list.size(); i < k; i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
            if (min == 1) {
                break;
            }
        }
        return min;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        // 0ms
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    int pre, min;
    public int minDiffInBST2(TreeNode root) {
        // 0ms
        pre = -1;
        min = Integer.MAX_VALUE;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }

}
