package com.hnq.study.interview;

import com.hnq.study.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author henengqiang
 * @since 2026/4/16
 * @see <a href="https://leetcode.cn/problems/path-sum-iii/?envType=study-plan-v2&envId=leetcode-75">路径总和 III</a>
 */
public class PathSum {

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode r2 = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        );
        System.out.println(pathSum.pathSum2(r2, 22));

        TreeNode root = new TreeNode(10,
                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11))
        );
        System.out.println(pathSum.pathSum2(root, 8));
    }

    /**
     * 双重递归：首先先序遍历每个节点，再以每个节点作为起始节点递归寻找满足条件的路径
     */
    public int pathSum(TreeNode root, int targetSum) {
        // 36ms
        if (root == null) {
            return 0;
        }
        int ret = dfs(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    private int dfs(TreeNode root, long targetSum) {
        int ret = 0;
        if (root == null) {
            return ret;
        }
        targetSum -= root.val;
        if (targetSum == 0) {
            ret++;
        }
        ret += dfs(root.left, targetSum);
        ret += dfs(root.right, targetSum);
        return ret;
    }

    /**
     * 前缀和
     */
    public int pathSum2(TreeNode root, int targetSum) {
        // 3ms
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs2(root, prefix, 0L, targetSum);
    }

    private int dfs2(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs2(root.left, prefix, curr, targetSum);
        ret += dfs2(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return ret;

    }

}
