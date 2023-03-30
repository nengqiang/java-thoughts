package com.hnq.study.everyday.earlier;

import com.hnq.study.everyday.TreeNode;

import java.util.Stack;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 *
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 *
 * @author henengqiang
 * @date 2021/07/26
 * @see <a href="https://leetcode-cn.com/problems/same-tree">链接</a>
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode p3 = new TreeNode(1, null, null);
        TreeNode q3 = new TreeNode(1, null, new TreeNode(2, null, null));
        System.out.println(isSameTree(p3, q3));
        TreeNode p2 = new TreeNode(1, new TreeNode(2, null, null), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2, null, null));
        System.out.println(isSameTree(p2, q2));
        TreeNode p1 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        TreeNode q1 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        System.out.println(isSameTree(p1, q1));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        // 0ms
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        Stack<TreeNode> sp = new Stack<>();
        Stack<TreeNode> sq = new Stack<>();
        TreeNode p1 = p;
        TreeNode q1 = q;
        while (p1 != null || !sp.isEmpty() || q1 != null || !sq.isEmpty()) {
            if (p1 != null && q1 != null) {
                sp.push(p1);
                sq.push(q1);
                p1 = p1.left;
                q1 = q1.left;
            } else if (p1 == null && q1 == null) {
                if (sp.size() != sq.size()) {
                    return false;
                }
                q1 = sq.pop();
                p1 = sp.pop();
                if (p1.val != q1.val) {
                    return false;
                }
                p1 = p1.right;
                q1 = q1.right;
            } else {
                return false;
            }
        }
        return true;
    }

}
