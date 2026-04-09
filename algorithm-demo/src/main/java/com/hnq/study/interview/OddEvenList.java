package com.hnq.study.interview;

import com.hnq.study.ListNode;

/**
 * @author henengqiang
 * @since 2026/4/8
 * @see <a href="https://leetcode.cn/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75">奇偶链表</a>
 */
public class OddEvenList {

    public static void main(String[] args) {
        OddEvenList o = new OddEvenList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(o.oddEvenList(head));
    }

    public ListNode oddEvenList(ListNode head) {
        // 0ms
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
