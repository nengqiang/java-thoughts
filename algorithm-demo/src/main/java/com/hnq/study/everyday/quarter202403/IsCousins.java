package com.hnq.study.everyday.quarter202403;

import com.hnq.study.everyday.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author henengqiang
 * @date 2024/10/14
 */
public class IsCousins {

    public static void main(String[] args) {
        IsCousins i = new IsCousins();
        TreeNode t2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(5))
        );
        System.out.println(i.isCousins2(t2, 5, 4));
        i.clear();
        TreeNode t1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println(i.isCousins2(t1, 4, 3));
        i.clear();
        TreeNode t3 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        System.out.println(i.isCousins2(t3, 2, 3));
    }

    private void clear() {
        this.xDepth = 0;
        this.yDepth = 0;
        this.xFound = false;
        this.yFound = false;
        this.xParent = null;
        this.yParent = null;
    }

    int x, xDepth;
    TreeNode xParent;
    boolean xFound = false;

    int y, yDepth;
    TreeNode yParent;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    /**
     * 深度优先遍历
     */
    public void dfs(TreeNode node, int depth, TreeNode parent) {
        // 0ms
        if (node == null) {
            return;
        }

        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }

        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth + 1, node);

        if (xFound && yFound) {
            return;
        }

        dfs(node.right, depth + 1, node);
    }

    /**
     * 广度优先搜索
     */
    public boolean isCousins2(TreeNode root, int x, int y) {
        // 1ms
        this.x = x;
        this.y = y;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        update(root, null, 0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();
            if (node.left != null) {
                nodeQueue.offer(node.left);
                depthQueue.offer(depth + 1);
                update(node.left, node, depth + 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
                update(node.right, node, depth + 1);
            }
            if (xFound && yFound) {
                break;
            }
        }
        return xDepth == yDepth && xParent != yParent;
    }

    /**
     * 用来判断是否遍历到 x 或 y 的辅助函数
     */
    public void update(TreeNode node, TreeNode parent, int depth) {
        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }
    }

}
