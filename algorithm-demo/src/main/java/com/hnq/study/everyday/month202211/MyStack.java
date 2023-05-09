package com.hnq.study.everyday.month202211;

import java.util.ArrayList;
import java.util.List;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * 
 * 示例：
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 *
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 * 
 * 提示：
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 * 
 * 进阶：你能否仅用一个队列来实现栈。
 *
 * @author henengqiang
 * @date 2022/11/28
 * @see <a href="https://leetcode.cn/problems/implement-stack-using-queues">链接</a>
 */
public class MyStack {

    private final List<Integer> list;

    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        return list.remove(list.size() - 1);
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public boolean empty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param3 = obj.top();
        System.out.println(param3);
        int param2 = obj.pop();
        System.out.println(param2);
        boolean param4 = obj.empty();
        System.out.println(param4);
    }

    /*
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

}