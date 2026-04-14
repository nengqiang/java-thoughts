package com.hnq.study.interview;

import com.hnq.study.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author henengqiang
 * @since 2026/4/14
 * @see <a href="https://leetcode.cn/problems/leaf-similar-trees/?envType=study-plan-v2&envId=leetcode-75">叶子相似的树</a>
 */
public class LeafSimilar {

    public static void main(String[] args) {
        LeafSimilar l = new LeafSimilar();
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(3);
        System.out.println(l.leafSimilar(root1, root2));

        TreeNode root3 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root4 = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        System.out.println(l.leafSimilar(root3, root4));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 1ms
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }

}
