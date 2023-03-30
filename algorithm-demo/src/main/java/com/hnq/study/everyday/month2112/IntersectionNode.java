package com.hnq.study.everyday.month2112;

import com.hnq.study.everyday.ListNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 自定义评测：
 *
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 *
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。
 * 如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 *
 * 
 *
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例2：
 * 输入：intersectVal= 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 示例3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *
 * 提示：
 *
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 1 <= m, n <= 3 * 10^4
 * 1 <= Node.val <= 10^5
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 * 
 *
 * 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
 *
 * @author henengqiang
 * @date 2022/01/20
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists">链接</a>
 */
public class IntersectionNode {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1, new ListNode(9, new ListNode(1, new ListNode(2, new ListNode(4, null)))));
        ListNode b1 = new ListNode(3, new ListNode(2, new ListNode(4, null)));
        ListNode res1 = getIntersectionNode2(a1, b1);
        System.out.println(res1);

        ListNode a2 = new ListNode(2, new ListNode(6, new ListNode(4, null)));
        ListNode b2 = new ListNode(1, new ListNode(5, null));
        ListNode res2 = getIntersectionNode2(a2, b2);
        System.out.println(res2);
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        List<Integer> listA = new LinkedList<>();
        List<Integer> listB = new LinkedList<>();
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        do {
            listA.add(tmpA.val);
            tmpA = tmpA.next;
        } while (tmpA != null);
        do {
            listB.add(tmpB.val);
            tmpB = tmpB.next;
        } while (tmpB != null);
        Collections.reverse(listA);
        Collections.reverse(listB);

        int length = Math.min(listA.size(), listB.size());
        List<Integer> intersectionNodeValues = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (listA.get(i).equals(listB.get(i))) {
                intersectionNodeValues.add(listA.get(i));
            }
        }
        if (intersectionNodeValues.size() <= 0) {
            return null;
        }
        ListNode res = new ListNode(intersectionNodeValues.get(0));
        for (int i = 1; i < intersectionNodeValues.size(); i++) {
            ListNode head = new ListNode(intersectionNodeValues.get(i));
            head.next = res;
            res = head;
        }
        return res;
    }

    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 1ms
        if (headA == null || headB == null) {
            return null;
        }
        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }

}
