package com.hnq.study.everyday.quarter202304;

import com.hnq.study.everyday.TreeNode;

/**
 * 二叉树中第二小的节点
 * <p>
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 * <p>
 * 如果第二小的值不存在的话，输出 -1 。
 * <p>
 *
 * 示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * <p>
 *
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 * <p>
 *
 * 提示：
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 2^31 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 *
 * @author henengqiang
 * @date 2023/11/6
 * @see <a href="https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/">链接</a>
 */
public class FindSecondMinimumValue {

    public static void main(String[] args) {
        FindSecondMinimumValue f = new FindSecondMinimumValue();

        TreeNode t2 = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        System.out.println(f.findSecondMinimumValue(t2));

        TreeNode t1 = new TreeNode(2,
                new TreeNode(2),
                new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        System.out.println(f.findSecondMinimumValue(t1));
    }

    int ans, rootVal;

    public int findSecondMinimumValue(TreeNode root) {
        // 0ms
        ans = -1;
        rootVal = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (ans != -1 && node.val >= ans) {
            return;
        }
        if (node.val > rootVal) {
            ans = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }



}
