package com.hnq.study.everyday.quarter202401;

import com.hnq.study.everyday.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表的中间结点
 * <p>
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 * <p>
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 * <p>
 *
 * 提示：
 * 链表的结点数范围是 [1, 100]
 * 1 <= Node.val <= 100
 *
 * @author henengqiang
 * @date 2024/2/21
 * @see <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">链接</a>
 */
public class MiddleNode {

    public static void main(String[] args) {
        MiddleNode m = new MiddleNode();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(m.middleNode2(l1));

        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(m.middleNode2(l2));
    }

    public ListNode middleNode(ListNode head) {
        // 0ms
        List<ListNode> list = new ArrayList<>();
        ListNode next = head;
        while (next != null) {
            list.add(next);
            next = next.next;
        }
        return list.get(list.size() / 2);
    }

    /**
     * 快慢指针:
     * 快指针和慢指针有恒定步数差，就可以达到倍数的效果
     */
    public ListNode middleNode2(ListNode head) {
        // 0ms
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
