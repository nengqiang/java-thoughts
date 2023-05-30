package com.hnq.study.everyday.quarter202302;

import com.hnq.study.everyday.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给出二叉树的根节点root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在to_delete中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * <p>
 * 示例 2：
 * 输入：root = [1,2,4,null,3], to_delete = [3]
 * 输出：[[1,2,4]]
 * <p>
 * 提示：
 * 树中的节点数最大为1000。
 * 每个节点都有一个介于1 到1000之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从1 到1000、各不相同的值。
 *
 * @author henengqiang
 * @date 2023/5/30
 * @see <a href="https://leetcode.cn/problems/delete-nodes-and-return-forest">链接</a>
 */
public class DelNodes {

    private static final Set<Integer> SET = new HashSet<>();
    private static final List<TreeNode> ANS = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(delNodes(t1, new int[]{3, 5}));
    }

    /**
     * java 后序遍历（把需要删的点置空这样递归的时候就指向了空，同时把它的左右孩子加到list中，
     * 要判断下根节点需不需要删除）
     */
    private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // 1ms
        for (int d : to_delete) {
            SET.add(d);
        }
        if (!SET.contains(root.val)) {
            ANS.add(root);
        }
        dfs(root);
        return ANS;
    }

    private static TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if (SET.contains(root.val)) {
            if (root.left != null) {
                ANS.add(root.left);
            }
            if (root.right != null) {
                ANS.add(root.right);
            }
            root = null;
        }
        return root;
    }


}
