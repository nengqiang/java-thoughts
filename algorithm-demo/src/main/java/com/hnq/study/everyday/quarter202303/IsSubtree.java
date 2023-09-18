package com.hnq.study.everyday.quarter202303;

import com.hnq.study.everyday.TreeNode;

/**
 * 另一棵树的子树
 * <p>
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 *
 * 示例 1：
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 * <p>
 *
 * 提示：
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 10^4
 * -104 <= subRoot.val <= 10^4
 *
 * @author henengqiang
 * @date 2023/9/18
 * @see <a href="https://leetcode.cn/problems/subtree-of-another-tree/">链接</a>
 */
public class IsSubtree {

    public static void main(String[] args) {
        IsSubtree i = new IsSubtree();
        TreeNode r3 = new TreeNode(1);
        TreeNode s3 = new TreeNode(1);
        System.out.println(i.isSubtree(r3, s3));

        TreeNode r1 = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(5));
        TreeNode s1 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(i.isSubtree(r1, s1));

        TreeNode r2 = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)),
                new TreeNode(5));
        System.out.println(i.isSubtree(r2, s1));
    }

    /**
     * 方法一：深度优先搜索暴力匹配
     * 这是一种最朴素的方法——深度优先搜索枚举 s 中的每一个节点，判断这个点的子树是否和 t 相等。
     * 如何判断一个节点的子树是否和 t 相等呢，我们又需要做一次深度优先搜索来检查，
     * 即让两个指针一开始先指向该节点和 t 的根，然后「同步移动」两根指针来「同步遍历」这两棵树，判断对应位置是否相等。
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 3ms
        return dfs(root, subRoot);
    }
    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t ) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

}
