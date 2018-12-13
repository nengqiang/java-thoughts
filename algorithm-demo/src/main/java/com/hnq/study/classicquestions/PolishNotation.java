package com.hnq.study.classicquestions;

import java.util.Arrays;
import java.util.Stack;

/**
 *  逆波兰表达式就是把操作数放前面，把操作符后置的一种写法，我们通过观察可以发现，第一个出现的运算符，其前面必有两个数字，
 * 当这个运算符和之前两个数字完成运算后从原数组中删去，把得到一个新的数字插入到原来的位置，继续做相同运算，直至整个数组变为一个数字。
 * 仔细想想，这道题果然应该是栈的完美应用啊，从前往后遍历数组，遇到数字则压入栈中，遇到符号，则把栈顶的两个数字拿出来运算，
 * 把结果再压入栈中，直到遍历完整个数组，栈顶数字即为最终答案。
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.Valid operators are +, -, *, /.
 * Each operand may be an integer or another expression. For example:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * @author henengqiang
 * @date 2018/12/12
 */
public class PolishNotation {

    public static void main(String[] args) {
        String[] tokens = new String[] {"2", "3", "5", "7", "9", "+", "-", "*", "/"};
        int result1 = evalRPN1(tokens);
        System.out.println("Calculate " + Arrays.toString(tokens) + " by method 1, The result is " + result1);
        int result2 = evalRPN2(tokens);
        System.out.println("Calculate " + Arrays.toString(tokens) + " by method 2, The result is " + result2);
    }

    /**
     * 1.Native Approach
     * This problem can be solved by using a stack. We can loop through each element in the given array. When it is a
     * number, push it to the stack. When it is an operator, pop two numbers from the stack, do the calculation, and
     * push back the result.
     * The following is the code.
     *
     * @param tokens    given array
     * @return          the result of calculation
     */
    private static int evalRPN1(String[] tokens) {
        String operators = "+-*/";

        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (!operators.contains(token)) {
                // push it to stack if it is a number
                stack.push(token);
            } else {
                // pop numbers from stack if it is an operator
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(a / b));
                        break;
                    default:
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

    /*
     * The problem is that switch statement is only available from JDK1.7
     */

    /**
     * 2.Accepted Solution
     * If you want to use switch statement, you can convert the above by using the following code which use
     * the index of a string "+ - * /".
     *
     * @param tokens    given array
     * @return          the result of calculation
     */
    private static int evalRPN2(String[] tokens) {
        String operators = "+-*/";

        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (!operators.contains(token)) {
                // push it to stack if it is a number
                stack.push(token);
            } else {
                // pop numbers from stack if it is an operator
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(token);
                switch (index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(a - b));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        stack.push(String.valueOf(a / b));
                        break;
                    default:
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

}
