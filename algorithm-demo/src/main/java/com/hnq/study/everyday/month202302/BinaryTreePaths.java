package com.hnq.study.everyday.month202302;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 *
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：["1"]
 * <p>
 *
 * 提示：
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author henengqiang
 * @date 2023/2/7
 * @see <a href="https://leetcode.cn/problems/binary-tree-paths">链接</a>
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3));
        System.out.println(binaryTreePaths(t1));

        TreeNode t2 = new TreeNode(1);
        System.out.println(binaryTreePaths(t2));
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        // 6ms 42MB
        List<String> res = new ArrayList<>();
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        if (root.left != null) {
            String lp = root.val + "->";
            List<String> lList = binaryTreePaths(root.left);
            for (String s : lList) {
                res.add(lp + s);
            }
        }
        if (root.right != null) {
            String rp = root.val + "->";
            List<String> rList = binaryTreePaths(root.right);
            for (String s : rList) {
                res.add(rp + s);
            }
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", "{", "}")
                    .add("\"val\":" + val)
                    .add("\"left\":" + left)
                    .add("\"right\":" + right)
                    .toString();
        }
    }
    
}
