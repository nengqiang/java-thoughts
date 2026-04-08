package com.hnq.study.interview;

import com.hnq.study.ListNode;

/**
 * @author henengqiang
 * @since 2026/4/8
 * @see <a href="http://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75">删除链表的中间节点</a>
 */
public class DeleteMiddle {

    public static void main(String[] args) {
        DeleteMiddle d = new DeleteMiddle();
        System.out.println(d.deleteMiddle(new ListNode(1)));
        System.out.println(d.deleteMiddle(new ListNode(1, new ListNode(2))));
        System.out.println(d.deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3)))));
        System.out.println(d.deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
        System.out.println(d.deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
        System.out.println(d.deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
        System.out.println(d.deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))))));
    }

    /**
     * 双指针
     * 快指针走两步，慢指针走一步，遍历结束后慢指针就指向中间节点的前一个节点，
     * 前提是从虚拟头节点开始，不然链表长度为奇数时慢指针最后会刚好到中间节点，后续处理会比较麻烦
     */
    public ListNode deleteMiddle(ListNode head) {
        // 5ms
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = slow.next;
        } else {
            return null;
        }
        return head;
    }

}
