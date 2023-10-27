package com.hnq.study.everyday.quarter202304;

import com.hnq.study.everyday.TreeNode;

import java.util.*;

/**
 * 两数之和 IV - 输入二叉搜索树
 * <p>
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 *
 * 示例 1：
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * <p>
 *
 * 示例 2：
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * <p>
 *
 * 提示:
 * 二叉树的节点个数的范围是  [1, 10^4]
 * -10^4 <= Node.val <= 10^4
 * 题目数据保证，输入的 root 是一棵 有效 的二叉搜索树
 * -10^5 <= k <= 10^5
 *
 * @author henengqiang
 * @date 2023/10/27
 * @see <a href="https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/">链接</a>
 */
public class FindTarget {

    public static void main(String[] args) {
        FindTarget f = new FindTarget();
        TreeNode t2 = new TreeNode(1,
                new TreeNode(0, new TreeNode(-2), null),
                new TreeNode(4, new TreeNode(3), null));
        System.out.println(f.findTarget(t2, 7));

        TreeNode t1 = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7))
        );
        System.out.println(f.findTarget(t1, 9));
        System.out.println(f.findTarget(t1, 28));
    }

    public boolean findTarget(TreeNode root, int k) {
        // 21ms
        List<Integer> ints = ite(root);
        for (int i = 0, len = ints.size(); i < len; i++) {
            Integer anInt = ints.get(i);
            int x = k - anInt;
            if (x != anInt && ints.contains(x)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> ite(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(ite(root.left));
        res.add(root.val);
        res.addAll(ite(root.right));
        return res;
    }


    Set<Integer> set = new HashSet<>();

    /**
     * 深度优先搜索 + 哈希表
     */
    public boolean findTarget2(TreeNode root, int k) {
        // 3ms
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    /**
     * 广度优先搜索 +哈希表
     */
    public boolean findTarget3(TreeNode root, int k) {
        // 3ms
        Set<Integer> set1 = new HashSet<>();
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (set1.contains(k - node.val)) {
                return true;
            }
            set1.add(node.val);
            if (node.left != null) {
                queue1.offer(node.left);
            }
            if (node.right != null) {
                queue1.offer(node.right);
            }
        }
        return false;
    }

    /**
     * 深度优先搜索 + 中序遍历 + 双指针
     */
    public boolean findTarget4(TreeNode root, int k) {
        // 2ms
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left) + list.get(right) == k) {
                return true;
            }
            if (list.get(left) + list.get(right) < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    /**
     * 迭代 + 中序遍历 +双指针
     */
    public boolean findTarget5(TreeNode root, int k) {
        // 1ms
        TreeNode left = root, right = root;
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        leftStack.push(left);
        while (left.left != null) {
            leftStack.push(left.left);
            left = left.left;
        }
        rightStack.push(right);
        while (right.right != null) {
            rightStack.push(right.right);
            right = right.right;
        }
        while (left != right) {
            if (left.val + right.val == k) {
                return true;
            }
            if (left.val + right.val < k) {
                left = getLeft(leftStack);
            } else {
                right = getRight(rightStack);
            }
        }
        return false;
    }

    public TreeNode getLeft(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode node = root.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return root;
    }

    public TreeNode getRight(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode node = root.left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
        return root;
    }

}
