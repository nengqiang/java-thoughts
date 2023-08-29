package com.hnq.study.everyday.quarter202303;

import com.hnq.study.everyday.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 二叉搜索树的最小绝对差
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 *
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 *
 * 提示：
 * 树中节点的数目范围是 [2, 10^4]
 * 0 <= Node.val <= 10^5
 *
 * @author henengqiang
 * @date 2023/8/29
 * @see <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/">链接</a>
 */
public class GetMinimumDifference {

    public static void main(String[] args) {
        GetMinimumDifference g = new GetMinimumDifference();
        TreeNode t4 = new TreeNode(236, new TreeNode(104, null, new TreeNode(227)), new TreeNode(701, null, new TreeNode(911)));
        System.out.println(g.getMinimumDifference2(t4));

        TreeNode t3 = new TreeNode(543, new TreeNode(384, null, new TreeNode(445)), new TreeNode(652, null, new TreeNode(699)));
        System.out.println(g.getMinimumDifference2(t3));
        TreeNode t1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        System.out.println(g.getMinimumDifference2(t1));
        TreeNode t2 = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        System.out.println(g.getMinimumDifference2(t2));
    }

    public int getMinimumDifference(TreeNode root) {
        // 5ms
        List<Integer> list = new ArrayList<>();
        find(root, list);
        list.sort(Comparator.naturalOrder());
        int min = 100000;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    public void find(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) {
            find(root.left, list);
        }
        if (root.right != null) {
            find(root.right, list);
        }
    }

    int pre;
    int ans;
    /**
     * 中序遍历
     */
    public int getMinimumDifference2(TreeNode root) {
        // 0ms
        ans = 100000;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }

}
