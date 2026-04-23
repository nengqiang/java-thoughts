package com.hnq.study.interview;

import com.hnq.study.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author henengqiang
 * @since 2026/4/23
 * @see <a href="https://leetcode.cn/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=leetcode-75">二叉树的右视图</a>
 */
public class RightSideView {

    public static void main(String[] args) {
        RightSideView r = new RightSideView();
        TreeNode t1 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(4)));
        System.out.println(r.rightSideView(t1));

        TreeNode t2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null),
                new TreeNode(3));
        System.out.println(r.rightSideView(t2));

        TreeNode t3 = new TreeNode(1, null, new TreeNode(3));
        System.out.println(r.rightSideView(t3));

        TreeNode t4 = null;
        System.out.println(r.rightSideView(t4));
    }

    public List<Integer> rightSideView(TreeNode root) {
        // 1ms
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean first = true;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (first) {
                    ans.add(node.val);
                    first = false;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                size--;
            }
        }
        return ans;
    }


}
