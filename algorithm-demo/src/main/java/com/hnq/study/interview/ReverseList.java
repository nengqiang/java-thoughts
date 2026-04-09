package com.hnq.study.interview;

import com.hnq.study.ListNode;

/**
 * @author henengqiang
 * @since 2026/4/9
 * @see <a href="https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75">反转链表</a>
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseList r = new ReverseList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(r.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        // 0ms
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;

        return cur;
    }

    /**
     * 递归
     */

}
