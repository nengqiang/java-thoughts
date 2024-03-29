package com.hnq.study.everyday.quarter202303;

import com.hnq.study.everyday.TreeNode;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 *
 * 示例 1：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * <p>
 *
 * 示例 2：
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 * <p>
 *
 * 提示：
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -10^4 <= Node.val <= 10^4
 *
 * @author henengqiang
 * @date 2023/8/14
 * @see <a href="https://leetcode.cn/problems/merge-two-binary-trees/">链接</a>
 */
public class MergeTrees {

    public static void main(String[] args) {
        MergeTrees m = new MergeTrees();
        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        System.out.println(m.mergeTrees(t1, t2));

        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(m.mergeTrees(t3, t4));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 0ms
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

}
