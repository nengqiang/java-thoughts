package com.hnq.study.everyday.quarter202303;

import com.google.common.collect.Lists;
import com.hnq.study.everyday.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * N 叉树的最大深度
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 *
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 * <p>
 *
 * 提示：
 * 树的深度不会超过 1000 。
 * 树的节点数目位于 [0, 10^4] 之间。
 *
 * @author henengqiang
 * @date 2023/9/6
 * @see <a href="https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/">链接</a>
 */
public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth m = new MaxDepth();
        Node n1 = new Node(1,
                Lists.newArrayList(
                        new Node(3, Lists.newArrayList(new Node(5), new Node(6))),
                        new Node(2),
                        new Node(4))
        );
        System.out.println(m.maxDepth2(n1));

        Node n2 = new Node(1,
                Lists.newArrayList(
                        new Node(2),
                        new Node(3,
                                Lists.newArrayList(new Node(6),
                                        new Node(7,
                                                Lists.newArrayList(
                                                        new Node(11,
                                                                Lists.newArrayList(new Node(14))
                                                        )
                                                )
                                        )
                                )
                        ),
                        new Node(4,
                                Lists.newArrayList(
                                        new Node(8,
                                                Lists.newArrayList(new Node(12)))
                                )
                        ),
                        new Node(5,
                                Lists.newArrayList(
                                        new Node(9,
                                                Lists.newArrayList(new Node(13))
                                        ),
                                        new Node(10)
                                )
                        )
                )
        );
        System.out.println(m.maxDepth2(n2));
    }

    /**
     * 深度优先
     */
    public int maxDepth(Node root) {
        // 0ms
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        int maxDepth = 0;
        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }
        return maxDepth + 1;
    }

    /**
     * 广度优先
     */
    public int maxDepth2(Node root) {
        // 2ms
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                if (node != null && node.children != null) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

}
