package com.hnq.study.everyday.quarter202302;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 *
 * 示例 1：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * <p>
 * 解释：
 * <pre>
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * </pre>
 * <p>
 *
 * 提示：
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * <p>
 *
 * 进阶：
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，
 * 即使其中一个操作可能花费较长时间。
 *
 * <pre>
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 * </pre>
 *
 * @author henengqiang
 * @date 2023/5/12
 * @see <a href="https://leetcode.cn/problems/implement-queue-using-stacks">链接</a>
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    private static Stack<Integer> qs, tp;

    public MyQueue() {
        qs = new Stack<>();
        tp = new Stack<>();
    }

    public void push(int x) {
        // 0ms
       while (!qs.empty()) {
           tp.push(qs.pop());
       }
       qs.push(x);
       while (!tp.empty()) {
           qs.push(tp.pop());
       }
    }

    public int pop() {
        return qs.pop();
    }

    public int peek() {
        return qs.peek();
    }

    public boolean empty() {
        return qs.empty();
    }

    /**
     * 进阶
     */
    private static class MyQueue2 {
        private static Stack<Integer> in, out;
        public MyQueue2() {
            in = new Stack<>();
            out = new Stack<>();
        }
        public void push(int x) {
            in.push(x);
        }
        public int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }
        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

}
