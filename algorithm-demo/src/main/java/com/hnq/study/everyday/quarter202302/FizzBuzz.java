package com.hnq.study.everyday.quarter202302;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * <p>
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 * <p>
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * <p>
 * 示例 3：
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * <p>
 *
 * 提示：
 * 1 <= n <= 10^4
 * 
 * @author henengqiang
 * @date 2023/6/19
 * @see <a href="https://leetcode.cn/problems/fizz-buzz">链接</a>
 */
public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz f = new FizzBuzz();
        System.out.println(f.fizzBuzz(3));
        System.out.println(f.fizzBuzz(5));
        System.out.println(f.fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        // 1ms
        String f = "Fizz", b = "Buzz";
        List<String> ans = new ArrayList<>(n * 4 / 3);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                ans.add(f + b);
            } else if (i % 3 == 0) {
                ans.add(f);
            } else if ( i % 5 == 0) {
                ans.add(b);
            } else {
                ans.add(i + "");
            }
        }
        return ans;
    }

}
