package com.hnq.study.everyday.earlier;

import com.hnq.study.everyday.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序遍历。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author henengqiang
 * @date 2021/7/23
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal">链接</a>
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
        System.out.println(inorderTraversal(r1));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        // 没看懂题目
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

}
