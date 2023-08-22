package com.hnq.study.everyday.quarter202303;

import com.hnq.study.everyday.TreeNode;

import java.util.*;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 *
 * 示例 1：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * <p>
 *
 * 示例 2：
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 *
 * 提示：
 * 树中节点的数目在范围 [1, 10^4] 内
 * -10^5 <= Node.val <= 10^5
 *
 * @author henengqiang
 * @date 2023/8/18
 * @see <a href="https://leetcode.cn/problems/find-mode-in-binary-search-tree/">链接</a>
 */
public class FindMode {

    public static void main(String[] args) {
        FindMode f = new FindMode();
        TreeNode t4 = new TreeNode(2, new TreeNode(1, null, new TreeNode(2, new TreeNode(1, null, new TreeNode(2)), null)), null);
        System.out.println(Arrays.toString(f.findMode(t4)));


        TreeNode t3 = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
        System.out.println(Arrays.toString(f.findMode(t3)));

        TreeNode t1 = new TreeNode(0);
        System.out.println(Arrays.toString(f.findMode(t1)));
        TreeNode t2 = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        System.out.println(Arrays.toString(f.findMode(t2)));
    }

    public int[] findMode(TreeNode root) {
        // 6ms
        Map<Integer, Integer> valCount = new HashMap<>();
        parseNode(root, valCount);
        int max = 0, j = 0;
        Map<Integer, Integer> cc = new HashMap<>();
        for (Integer val : valCount.values()) {
            max = Integer.max(max, val);
            cc.merge(val, 1, Integer::sum);
        }
        int[] ans = new int[cc.get(max)];
        for (Map.Entry<Integer, Integer> kv : valCount.entrySet()) {
            if (kv.getValue() == max) {
                ans[j++] = kv.getKey();
                if (j >= cc.get(max)) {
                    break;
                }
            }
        }
        return ans;
    }

    public void parseNode(TreeNode root, Map<Integer, Integer> valCount) {
        if (root == null) {
            return;
        }
        valCount.merge(root.val, 1, Integer::sum);
        parseNode(root.left, valCount);
        parseNode(root.right, valCount);
    }


    List<Integer> answer = new ArrayList<Integer>();
    int base, count, maxCount;

    /**
     * 中序遍历
     */
    public int[] findMode2(TreeNode root) {
        // 0ms
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode o) {
        if (o == null) {
            return;
        }
        dfs(o.left);
        update(o.val);
        dfs(o.right);
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

}
