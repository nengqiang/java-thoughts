package com.hnq.study.everyday.quarter202303;

import com.google.common.collect.Lists;
import com.hnq.study.everyday.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N 叉树的前序遍历
 * <p>
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 *
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 *
 * 提示：
 * 节点总数在范围 [0, 10^4]内
 * 0 <= Node.val <= 10^4
 * n 叉树的高度小于或等于 1000
 *
 * @author henengqiang
 * @date 2023/9/25
 * @see <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/">链接</a>
 */
public class Preorder {

    public static void main(String[] args) {
        Preorder p = new Preorder();
        Node n1 = new Node(1,
                Lists.newArrayList(
                        new Node(3,
                        Lists.newArrayList(
                                new Node(5),
                                new Node(6))
                        ),
                        new Node(2),
                        new Node(4))
        );
        System.out.println(p.preorder2(n1));

        Node n2 = new Node(1, Lists.newArrayList(
                        new Node(2),
                        new Node(3, Lists.newArrayList(
                                        new Node(6),
                                        new Node(7, Lists.newArrayList(
                                                        new Node(11,
                                                                Lists.newArrayList(
                                                                        new Node(14))))
                                        )
                                )
                        ),
                        new Node(4, Lists.newArrayList(new Node(8, Lists.newArrayList(new Node(12))))),
                        new Node(5, Lists.newArrayList(new Node(9, Lists.newArrayList(new Node(13))), new Node(10)))
                )
        );
        System.out.println(p.preorder2(n2));
    }

    public List<Integer> preorder(Node root) {
        // 2ms
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.children != null && root.children.size() > 0) {
            for (Node child : root.children) {
                list.addAll(preorder(child));
            }
        }
        return list;
    }

    /**
     * 迭代优化
     */
    public List<Integer> preorder2(Node root) {
        // 2ms
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return res;
    }

}
