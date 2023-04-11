package com.hnq.study.everyday.quarter202302;

import com.hnq.study.everyday.TreeNode;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * <p>
 *
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * <p>
 *
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @author henengqiang
 * @date 2023/4/10
 * @see <a href="https://leetcode.cn/problems/path-sum">链接</a>
 */
public class HasPathSum {

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4))
        );
        System.out.println(hasPathSum2(t2, 22));

        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(hasPathSum2(t1, 5));
        System.out.println(hasPathSum2(t1, 3));
        System.out.println(hasPathSum2(t1, 4));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return sumOfParentPath(root, 0, targetSum);
    }

    private static boolean sumOfParentPath(TreeNode root, int sum, int targetSum) {
        // 0ms
        if (root == null) {
            return sum == targetSum;
        }
        if (root.left == null && root.right == null) {
            return (sum + root.val) == targetSum;
        }
        if (root.left == null) {
            return sumOfParentPath(root.right, sum + root.val, targetSum);
        }
        if (root.right == null) {
            return sumOfParentPath(root.left, sum + root.val, targetSum);
        }
        return sumOfParentPath(root.right, sum + root.val, targetSum)
                || sumOfParentPath(root.left, sum + root.val, targetSum);
    }

    private static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum2(root.left, targetSum - root.val)
                || hasPathSum2(root.right, targetSum - root.val);
    }

}
