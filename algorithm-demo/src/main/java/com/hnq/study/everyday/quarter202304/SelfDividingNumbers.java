package com.hnq.study.everyday.quarter202304;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数
 * <p>
 * 自除数 是指可以被它包含的每一位数整除的数。
 * <p>
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 * <p>
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 * <p>
 *
 * 示例 1：
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * <p>
 *
 * 示例 2:
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 * <p>
 *
 * 提示：
 * 1 <= left <= right <= 10^4
 *
 * @author henengqiang
 * @date 2023/12/18
 * @see <a href="https://leetcode.cn/problems/self-dividing-numbers/">链接</a>
 */
public class SelfDividingNumbers {

    public static void main(String[] args) {
        SelfDividingNumbers s = new SelfDividingNumbers();
        System.out.println(s.selfDividingNumbers(13, 13));
        System.out.println(s.selfDividingNumbers(128, 128));
        System.out.println(s.selfDividingNumbers(1, 22));
        System.out.println(s.selfDividingNumbers(47, 85));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        // 2ms
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int t = i;
            boolean f = true;
            while (t > 0) {
                int p = t % 10;
                if (p == 0 || i % p != 0) {
                    f = false;
                    break;
                }
                t /= 10;
            }
            if (f) {
                list.add(i);
            }
        }
        return list;
    }

}
