package com.hnq.study.everyday;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 提示：
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * @author henengqiang
 * @date 2021/09/07
 * @see <a href="https://leetcode-cn.com/problems/remove-linked-list-elements">链接</a>
 */
public class RemoveElements {

    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(4, null)))));
        System.out.println(removeElements(a, 2));
    }

    private static ListNode removeElements(ListNode head, int val) {
        // 1ms
        if (head == null ) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }

    public static class ListNode {
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
