package com.hnq.study.everyday.quarter202304;

import com.hnq.study.everyday.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 根据二叉树创建字符串
 * <p>
 * 给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
 * <p>
 * 空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 *
 * 示例 1：
 * 输入：root = [1,2,3,4]
 * 输出："1(2(4))(3)"
 * 解释：初步转化后得到 "1(2(4)())(3()())" ，但省略所有不必要的空括号对后，字符串应该是"1(2(4))(3)" 。
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,2,3,null,4]
 * 输出："1(2()(4))(3)"
 * 解释：和第一个示例类似，但是无法省略第一个空括号对，否则会破坏输入与输出一一映射的关系。
 * <p>
 *
 * 提示：
 * 树中节点的数目范围是 [1, 10^4]
 * -1000 <= Node.val <= 1000
 *
 * @author henengqiang
 * @date 2023/10/13
 * @see <a href="https://leetcode.cn/problems/construct-string-from-binary-tree/">链接</a>
 */
public class Tree2str {

    public static void main(String[] args) {
        Tree2str t = new Tree2str();
        TreeNode t1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3));
        System.out.println(t.tree2str2(t1));

        TreeNode t2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3));
        System.out.println(t.tree2str2(t2));
    }

    /**
     * 递归
     */
    public String tree2str(TreeNode root) {
        // 6ms
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left != null || root.right != null) {
            if (root.left == null) {
                sb.append("()");
            } else {
                sb.append("(").append(tree2str(root.left)).append(")");
            }
            if (root.right != null) {
                sb.append("(").append(tree2str(root.right)).append(")");
            }
        }
        return sb.toString();
    }

    /**
     * 迭代
     */
    public String tree2str2(TreeNode root) {
        // 5ms
        StringBuilder ans = new StringBuilder();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (!visited.add(node)) {
                if (node != root) {
                    ans.append(")");
                }
                stack.pop();
            } else {
                if (node != root) {
                    ans.append("(");
                }
                ans.append(node.val);
                if (node.left == null && node.right != null) {
                    ans.append("()");
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return ans.toString();
    }


}
