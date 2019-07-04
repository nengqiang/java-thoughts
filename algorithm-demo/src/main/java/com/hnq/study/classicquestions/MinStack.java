package com.hnq.study.classicquestions;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * @author henengqiang
 * @date 2019/07/04
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);

        System.out.println("top=" + minStack.getTop());
        System.out.println("min=" + minStack.getMin());

        minStack.push(2);
        minStack.push(3);

        System.out.println("top=" + minStack.getTop());
        System.out.println("min=" + minStack.getMin());

        minStack.pop();

        System.out.println("top=" + minStack.getTop());
        System.out.println("min=" + minStack.getMin());
    }

    /*
     * Solution
     *
     * To make constant time of getMin(), we need to keep track of the minimum element for each element in the stack.
     * Define an element class that holds element value, min value, and pointer to elements below it.
     */

    private Elem top;

    public MinStack() {
    }

    public void push(int x) {
        if (top == null) {
            top = new Elem(x, x);
        } else {
            Elem e = new Elem(x, Math.min(x, top.min));
            e.next = top;
            top = e;
        }
    }

    public void pop() {
        if (top == null) {
            return;
        }
        Elem temp = top.next;
        top.next = null;
        top = temp;
    }

    public int getTop() {
        return top == null ? -1 : top.value;
    }

    public int getMin() {
        return top == null ? -1 : top.min;
    }
}

class Elem {
    int value;
    int min;
    Elem next;

    Elem(int value, int min) {
        this.value = value;
        this.min = min;
    }
}