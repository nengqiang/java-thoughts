package com.hnq.study.everyday;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * @author henengqiang
 * @date 2021/10/06
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list">链接</a>
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(reverseList3(l1));
        ListNode l2 = new ListNode(2, new ListNode(1, null));
        System.out.println(reverseList3(l2));
        ListNode l3 = new ListNode();
        System.out.println(reverseList3(l3));
    }

    private static ListNode reverseList(ListNode head) {
        // 0ms 38.4M
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = new ListNode(head.val);
        while (head.next != null) {
            head = head.next;
            ListNode q = new ListNode(head.val);
            q.next = p;
            p = q;
        }
        return p;
    }

    private static ListNode reverseList2(ListNode head) {
        // 0ms 37.9M
        ListNode pre = null, cur = head, tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static ListNode reverseList3(ListNode head) {
        return reverse3(null, head);
    }

    private static ListNode reverse3(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp;
        // 先保存下一个节点
        temp = cur.next;
        // 反转
        cur.next = prev;
        // 更新prev、cur位置
        prev = cur;
        cur = temp;
        return reverse3(prev, cur);
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
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("val", val)
                    .append("next", next)
                    .toString();
        }
    }

}
