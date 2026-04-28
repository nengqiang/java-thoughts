package com.hnq.study.interview;

import com.hnq.study.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author henengqiang
 * @since 2026/4/28
 * @see <a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75">最大层内元素和</a>
 */
public class MaxLevelSum {

    public static void main(String[] args) {
        MaxLevelSum m = new MaxLevelSum();

        TreeNode t4 = new TreeNode(-1,
                new TreeNode(-1, new TreeNode(0), new TreeNode(0)),
                new TreeNode(1));
        System.out.println(m.maxLevelSum2(t4));

        TreeNode t3 = new TreeNode(-100,
                new TreeNode(-200, new TreeNode(-20), new TreeNode(-5)),
                new TreeNode(-300, new TreeNode(-10), null));
        System.out.println(m.maxLevelSum2(t3));

        TreeNode t1 = new TreeNode(1,
                new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
                new TreeNode(0));
        System.out.println(m.maxLevelSum2(t1));

        TreeNode t2 = new TreeNode(989,
                null,
                new TreeNode(10250, new TreeNode(98693), new TreeNode(-89388, null, new TreeNode(-32127))));
        System.out.println(m.maxLevelSum2(t2));
    }

    public int maxLevelSum(TreeNode root) {
        // 9ms
        int max = Integer.MIN_VALUE, lev = 0, minLev = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            lev++;
            int size = queue.size(), sum = 0;
            while (size > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            if (sum > max) {
                minLev = lev;
                max = sum;
            }
        }

        return minLev;
    }

    /**
     * 深度优先遍历
     */
    public int maxLevelSum2(TreeNode root) {
        // 13ms
        Map<Integer, Integer> levSumMap = new HashMap<>();
        dfs(root, 1, levSumMap);
        int minLev = 1;
        for (Map.Entry<Integer, Integer> en : levSumMap.entrySet()) {
            if (en.getValue() > levSumMap.get(minLev) || (en.getValue() == levSumMap.get(minLev) && en.getKey() < minLev)) {
                minLev = en.getKey();
            }
        }
        return minLev;
    }

    private void dfs(TreeNode node, int lev, Map<Integer, Integer> levSumMap) {
        levSumMap.merge(lev, node.val, Integer::sum);
        if (node.left != null) {
            dfs(node.left, lev + 1, levSumMap);
        }
        if (node.right != null) {
            dfs(node.right, lev + 1, levSumMap);
        }
    }

}
