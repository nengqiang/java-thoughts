package com.hnq.study.everyday.quarter202303;

import com.hnq.study.everyday.TreeNode;

/**
 * 二叉树的坡度
 * <p>
 * 给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
 * <p>
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
 * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * <p>
 * 整个树 的坡度就是其所有节点的坡度之和。
 * <p>
 *
 *
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：1
 * 解释：
 * 节点 2 的坡度：|0-0| = 0（没有子节点）
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
 * 坡度总和：0 + 0 + 1 = 1
 * <p>
 *
 * 示例 2：
 * 输入：root = [4,2,9,3,5,null,7]
 * 输出：15
 * 解释：
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 5 的坡度：|0-0| = 0（没有子节点）
 * 节点 7 的坡度：|0-0| = 0（没有子节点）
 * 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
 * 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
 * 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 16 ）
 * 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
 * <p>
 *
 * 示例 3：
 * 输入：root = [21,7,14,1,1,2,2,3,3]
 * 输出：9
 * <p>
 *
 * 提示：
 * 树中节点数目的范围在 [0, 10^4] 内
 * -1000 <= Node.val <= 1000
 *
 * @author henengqiang
 * @date 2023/9/8
 * @see <a href="https://leetcode.cn/problems/binary-tree-tilt/">链接</a>
 */
public class FindTilt {

    public static void main(String[] args) {
        FindTilt f = new FindTilt();
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(f.findTilt2(t1));

        TreeNode t2 = new TreeNode(
                4,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(5)),
                new TreeNode(9,
                        null,
                        new TreeNode(7)));
        System.out.println(f.findTilt2(t2));

        TreeNode t3 = new TreeNode(
                21,
                new TreeNode(7,
                        new TreeNode(1,
                                new TreeNode(3),
                                new TreeNode(3)),
                        new TreeNode(1)
                ),
                new TreeNode(14,
                        new TreeNode(2),
                        new TreeNode(2)
                )
        );
        System.out.println(f.findTilt2(t3));
    }

    public int findTilt(TreeNode root) {
        // 12ms
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int sum = 0;
        sum += Math.abs(sumTree(root.left) - sumTree(root.right));
        sum += findTilt(root.left);
        sum += findTilt(root.right);
        return sum;
    }

    public int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumTree(root.left) + sumTree(root.right);
    }

    /**
     * 方法一：深度优先搜索
     * 思路和算法
     *
     * 根据题意，我们需要累计二叉树中所有结点的左子树结点之和与右子树结点之和的差的绝对值。
     * 因此，我们可以使用深度优先搜索，在遍历每个结点时，累加其左子树结点之和与右子树结点之和的差的绝对值，
     * 并返回以其为根结点的树的结点之和。
     *
     * 具体地，我们实现算法如下：
     *
     * 从根结点开始遍历，设当前遍历的结点为 node；
     * 遍历 node 的左子结点，得到左子树结点之和 sum_left；遍历 node 的右子结点，得到右子树结点之和 sum_right；
     * 将左子树结点之和与右子树结点之和的差的绝对值累加到结果变量 ans；
     * 返回以 node 作为根结点的树的结点之和 sum_left + sum_right + node.val 。
     */
    int ans = 0;
    public int findTilt2(TreeNode root) {
        // 0ms
        ans = 0;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;
    }

}
