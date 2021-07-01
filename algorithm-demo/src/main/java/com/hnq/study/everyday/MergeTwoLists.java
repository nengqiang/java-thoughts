package com.hnq.study.everyday;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * @author henengqiang
 * @date 2021/06/30
 * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists">链接</a>
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(7, null)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(9, null))));
        ListNode res = mergeTwoLists2(l1, l2);
        System.out.println(res);
    }

    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 0ms
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 小的排在前面
        ListNode res = l1.val < l2.val ? l1 : l2;
        // 小的的剩余部分和另一个链表继续合并
        res.next = mergeTwoLists2(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1ms
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int size = 0;
        ListNode tmp1 = l1;
        while (tmp1 != null) {
            size++;
            tmp1 = tmp1.next;
        }
        ListNode tmp2 = l2;
        while (tmp2 != null) {
            size++;
            tmp2 = tmp2.next;
        }
        ListNode[] nodes = new ListNode[size];
        int i = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                nodes[i] = new ListNode(l1.val, null);
                i++;
                l1 = l1.next;
            }
            if (l2 != null) {
                nodes[i] = new ListNode(l2.val, null);
                i++;
                l2 = l2.next;
            }
        }
        insertionSortNodes(nodes);
        ListNode res = nodes[size - 1];
        for (int j = nodes.length - 2; j >= 0; j--) {
            res = new ListNode(nodes[j].val, res);
        }
        return res;
    }

    private static void insertionSortNodes(ListNode[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            int j = i;
            while (j > 0 && nodes[j - 1].val > nodes[j].val) {
                ListNode tmp = nodes[j - 1];
                nodes[j - 1] = nodes[j];
                nodes[j] = tmp;
                j--;
            }
        }
    }


    /*
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("val", val)
                    .append("next", next)
                    .toString();
        }
    }
}
























