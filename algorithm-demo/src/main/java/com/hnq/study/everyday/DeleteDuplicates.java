package com.hnq.study.everyday;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.LinkedList;
import java.util.List;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * @author henengqiang
 * @date 2021/07/19
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list">链接</a>
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        ListNode res1 = deleteDuplicates3(head1);
        System.out.println(res1);

        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        ListNode res2 = deleteDuplicates3(head2);
        System.out.println(res2);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    private static ListNode deleteDuplicates(ListNode head) {
        // 4ms
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> l = new LinkedList<>();
        ListNode node = head;
        while (node.next != null) {
            if (!l.contains(node.val)) {
                l.add(node.val);
            }
            node = node.next;
        }
        if (!l.contains(node.val)) {
            l.add(node.val);
        }
        ListNode res = new ListNode(l.get(l.size() - 1), null);
        for (int i = l.size() - 2; i >= 0; i--) {
            res = new ListNode(l.get(i), res);
        }
        return res;
    }

    /**
     * 递归套路解决链表问题：
     *
     * 找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
     * 想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
     * 每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，而根据第二步，我应该返回一个去重的链表的头节点。
     * 因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head
     */
    private static ListNode deleteDuplicates2(ListNode head) {
        // 0ms
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates2(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    private static ListNode deleteDuplicates3(ListNode head) {
        // 0ms
        // 定义指针指向头部
        ListNode p = head;
        // 当前有值、且下一节点有值
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                // 如果当前值等于下一节点的值，删除下一节点
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
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
