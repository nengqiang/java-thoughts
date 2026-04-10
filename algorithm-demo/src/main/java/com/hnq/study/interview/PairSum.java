package com.hnq.study.interview;

import com.hnq.study.ListNode;

/**
 * @author henengqiang
 * @since 2026/4/10
 * @see <a href="https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75">链表最大孪生和</a>
 */
public class PairSum {

    public static void main(String[] args) {
        PairSum p = new PairSum();
        ListNode head3= new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));
        System.out.println(p.pairSum(head3));
        ListNode head2= new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))));
        System.out.println(p.pairSum(head2));
        ListNode head4= new ListNode(1, new ListNode(10000));
        System.out.println(p.pairSum(head4));
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(p.pairSum(head1));
    }

    public int pairSum(ListNode head) {
        // 4ms
        // 拆分链表
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode secondPart = p1.next;
        p1.next = null;
        ListNode firstPart = head;

        // 反转链表
        ListNode pre = null;
        ListNode cur = secondPart;
        ListNode next = secondPart.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        secondPart = cur;

        // 求最大值
        int max = 0;
        while (firstPart != null && secondPart != null) {
            max = Math.max(max, firstPart.val + secondPart.val);
            firstPart = firstPart.next;
            secondPart = secondPart.next;
        }

        return max;
    }

}
