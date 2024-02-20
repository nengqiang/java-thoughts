package com.hnq.study.everyday.quarter202401;

import com.hnq.study.everyday.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 叶子相似的树
 * <p>
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 *
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 *
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * <p>
 *
 * 提示：
 * 给定的两棵树结点数在 [1, 200] 范围内
 * 给定的两棵树上的值在 [0, 200] 范围内
 *
 * @author henengqiang
 * @date 2024/2/20
 * @see <a href="https://leetcode.cn/problems/leaf-similar-trees/">链接</a>
 */
public class LeafSimilar {

    public static void main(String[] args) {
        LeafSimilar l = new LeafSimilar();
        TreeNode t1 = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(9),
                        new TreeNode(8))
        );
        TreeNode t2 = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(7)),
                new TreeNode(1,
                        new TreeNode(4),
                        new TreeNode(2,
                                new TreeNode(9),
                                new TreeNode(8)))
        );
        System.out.println(l.leafSimilar(t1, t2));

        TreeNode t3 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t4 = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        System.out.println(l.leafSimilar(t3, t4));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 0ms
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        listLeavesFromLeft(root1, l1);
        listLeavesFromLeft(root2, l2);
        return l1.equals(l2);
    }

    /**
     * 不要每次递归去new一个list速度能更快
     */
    private void listLeavesFromLeft(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.left != null) {
            listLeavesFromLeft(root.left, list);
        }
        if (root.right != null) {
            listLeavesFromLeft(root.right, list);
        }
    }

}
