package com.hnq.study.everyday.month2112;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * @author henengqiang
 * @date 2021/12/27
 * @see <a href="https://leetcode-cn.com/problems/min-stack">链接</a>
 */
public class MinStack {

    private int[] stack;

    private static final int INIT_SIZE = 2;

    private int index;

    private int minIndex;

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public MinStack() {
        stack = new int[INIT_SIZE];
        index = -1;
        minIndex = index;
    }

    public void push(int val) {
        if (isFull()) {
            int[] tmp = stack;
            stack = new int[2 * stack.length];
            System.arraycopy(tmp, 0, stack, 0, tmp.length);
        }
        stack[++index] = val;
        if (minIndex == -1 || stack[minIndex] > val) {
            minIndex = index;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            index--;
            if (index <= (stack.length - 1) / 2 && stack.length > INIT_SIZE) {
                int[] tmp = stack;
                stack = new int[stack.length / 2];
                System.arraycopy(tmp, 0, stack, 0, stack.length);
            }
            if (minIndex > index) {
                minIndex = getMinIndex();
            }
        }
    }

    public int top() {
        if (!isEmpty()) {
            return stack[index];
        }
        return -999;
    }

    public int getMin() {
        if (!isEmpty()) {
            return stack[minIndex];
        }
        return -999;
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public boolean isFull() {
        return index >= stack.length - 1;
    }

    private int getMinIndex() {
        int min = this.top();
        minIndex = index;
        for (int i = 0; i <= index; i++) {
            if (stack[i] < min) {
                min = stack[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        // ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
        // [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
