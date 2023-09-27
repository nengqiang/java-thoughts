package com.hnq.study.everyday.quarter202303;

import com.google.common.collect.Lists;
import com.hnq.study.everyday.Node;

import java.util.*;

/**
 * N 叉树的后序遍历
 * <p>
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 *
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 * <p>
 *
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 *
 * 提示：
 * 节点总数在范围 [0, 10^4] 内
 * 0 <= Node.val <= 10^4
 * n 叉树的高度小于或等于 1000
 *
 * @author henengqiang
 * @date 2023/9/27
 * @see <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/">链接</a>
 */
public class Postorder {

    public static void main(String[] args) {
        Postorder p = new Postorder();
        Node n1 = new Node(1, Lists.newArrayList(
                new Node(3, Lists.newArrayList(new Node(5), new Node(6))),
                new Node(2),
                new Node(4))
        );
        System.out.println(p.postorder(n1));
        System.out.println(p.postorder2(n1));
        System.out.println(p.postorder3(n1));
    }

    public List<Integer> postorder(Node root) {
        // 2ms
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.children != null && root.children.size() > 0) {
            for (Node child : root.children) {
                list.addAll(postorder(child));
            }
        }
        list.add(root.val);
        return list;
    }

    /**
     * 迭代优化
     */
    public List<Integer> postorder2(Node root) {
        // 6ms
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<Node> stack = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.children == null || node.children.size() == 0 || visited.contains(node)) {
                stack.pop();
                list.add(node.val);
                continue;
            }
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
            visited.add(node);
        }
        return list;
    }

    /**
     * 利用前序遍历反转
     */
    public List<Integer> postorder3(Node root) {
        // 3ms
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        Collections.reverse(list);
        return list;
    }

}
