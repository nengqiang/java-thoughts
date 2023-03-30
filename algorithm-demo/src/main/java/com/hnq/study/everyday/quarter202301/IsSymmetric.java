package com.hnq.study.everyday.quarter202301;

import com.hnq.study.everyday.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 *
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 * @author henengqiang
 * @date 2023/3/28
 * @see <a href="https://leetcode.cn/problems/symmetric-tree">链接</a>
 */
public class IsSymmetric {

    public static void main(String[] args) {
        // [2,3,3,4,5,5,4,null,null,8,9,9,8]
        TreeNode t3 = new TreeNode(2,
                new TreeNode(3,
                        new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(9))),
                new TreeNode(3,
                        new TreeNode(5, new TreeNode(9), new TreeNode(8)), new TreeNode(4)));
        System.out.println("[2,3,3,4,5,5,4,null,null,8,9,9,8] isSymmetric: " + isSymmetric2(t3));
        TreeNode t1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println("[1,2,2,3,4,4,3] isSymmetric: " + isSymmetric2(t1));
        TreeNode t2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));
        System.out.println("[1,2,2,null,3,null,3] isSymmetric: " + isSymmetric2(t2));
    }

    private static boolean isSymmetric(TreeNode root) {
        // 2ms
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        List<Integer> leftVals = iterate(root.left, true);
        leftVals.add(0, root.left.val);
        List<Integer> rightVals = iterate(root.right, false);
        rightVals.add(0, root.right.val);
        if (leftVals.size() != rightVals.size()) {
            return false;
        }
        for (int i = 0; i < leftVals.size(); i++) {
            if (!leftVals.get(i).equals(rightVals.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> iterate(TreeNode root, boolean leftIte) {
        List<Integer> iter = new ArrayList<>();
        if (root == null) {
            return iter;
        }

        if (leftIte) {
            iter.add(root.left == null ? 999 : root.left.val);
            iter.add(root.right == null ? 999 : root.right.val);
            iter.addAll(iterate(root.left, true));
            iter.addAll(iterate(root.right, true));
        } else {
            iter.add(root.right == null ? 999 : root.right.val);
            iter.add(root.left == null ? 999 : root.left.val);
            iter.addAll(iterate(root.right, false));
            iter.addAll(iterate(root.left, false));
        }
        return iter;
    }

    private static boolean isSymmetric2(TreeNode root) {
        // 0ms
        if (root == null) {
            return true;
        }
        return leftEqualRight(root.left, root.right);
    }

    /**
     * 递归点：我在尝试判断左树与右树对称的条件时，发现其跟两树的孩子的对称情况有关系。
     * 想到这里，你不必有太多疑问，上手去按思路写代码，函数A（左树，右树）功能是返回是否对称
     * def 函数A（左树，右树）：
     *  左树节点值等于右树节点值 且
     *  函数A（左树的左子树，右树的右子树），函数A（左树的右子树，右树的左子树）均为真 才返回真
     */
    private static boolean leftEqualRight(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val
                && leftEqualRight(left.left, right.right)
                && leftEqualRight(left.right, right.left);
    }

    private static boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }

}
