package com.hnq.study.interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author henengqiang
 * @since 2026/4/1
 * @see <a href="https://leetcode.cn/problems/asteroid-collision/?envType=study-plan-v2&envId=leetcode-75">小行星碰撞</a>
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] asteroids = {-2, -1, 1, 2};
        int[] res = asteroidCollision.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
        asteroids = new int[]{8, -8};
        res = asteroidCollision.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
        asteroids = new int[]{10, 2, -5};
        res = asteroidCollision.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
        asteroids = new int[]{3, 5, -6, 2, -1, 4};
        res = asteroidCollision.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
    }

    public int[] asteroidCollision(int[] asteroids) {
        // 6ms
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            if (i > 0) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int top = stack.peek();
                    if (top < -i) {
                        stack.pop();
                    } else if (top == -i) {
                        stack.pop();
                        i = 0;
                        break;
                    } else {
                        i = 0;
                        break;
                    }
                }
                if (i != 0) {
                    stack.push(i);
                }
            }
        }
        int[] res = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[index--] = stack.pop();
        }
        return res;
    }

}
