package com.hnq.study.everyday.quarter202301;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 *
 * 提示：
 * 链表中节点数目在范围[1, 10^5] 内
 * 0 <= Node.val <= 9
 *
 * @author henengqiang
 * @date 2023/3/27
 * @see <a href="https://leetcode.cn/problems/palindrome-linked-list">链接</a>
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println("1,2,2,1 isPalindrome: " + isPalindrome2(l1));

        ListNode l2 = new ListNode(1, new ListNode(2));
        System.out.println("i,2 isPalindrome: " + isPalindrome2(l2));
    }

    private static boolean isPalindrome(ListNode head) {
        // 8ms
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        do {
            list.add(p.val);
            p = p.next;
        } while (p != null);
        int len  = list.size();
        if (len == 1) {
            return true;
        }
        for (int i = 0; i < len / 2; i++) {
            if (!list.get(i).equals(list.get(len - i - 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断头节点，空 or 单个直接返回 true
     * <p>
     *
     * 1. 定义快慢指针，快指针是慢指针后移速度的两倍，遍历链表，
     * 2. 遍历的同时反转链表前半部分，
     * 3. 遍历结束后，慢指针位于链表中间位置，
     * 4. 根据链表长度调整慢指针位置使得其对准链表后半部分第一个位置
     * 5. 遍历链表后半部分和已经反转的前半部分，如不一致则非回文链表
     */
    private static boolean isPalindrome2(ListNode head) {
        // 3ms
        // 判断头节点，空 or 单个直接返回 true
        if (head == null || head.next == null ) {
            return true;
        }

        // 定义快慢指针
        ListNode slow = head, fast = head;
        // 定义指针 cur 记录当前位置 & pre 记录前一位置
        ListNode cur = head, pre = null;
        /*
         * 1. 非空判断，注意 fast.next.next 要保证 fast != null && fast.next != null
         * 2. 快指针是慢指针后移速度的两倍，使得循环结束后，慢指针位于链表中间位置
         * 3. 在后移过程中反转链表前半部分
         */
        while (fast != null && fast.next != null) {
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur;
        }
        /* 如果链表长度为单数，慢指针后移
         * 0 1 2 3 4 5 ^; 0 1 2 3 4 5 6 ^
         *       s     f        s     f
         */
        if (fast != null) {
            slow = slow.next;
        }
        // 遍历链表后半部分和已经反转的前半部分
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x, ListNode node) {
            val = x;
            next = node;
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
