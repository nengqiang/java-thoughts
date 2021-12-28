package com.hnq.study.everyday.earlier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数numRows，生成「杨辉三角」的前numRows行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 提示:
 * 1 <= numRows <= 30
 *
 * @author henengqiang
 * @date 2021/08/04
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle">链接</a>
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(5));
    }

    private static List<List<Integer>> generate(int numRows) {
        // 0ms
        if (numRows == 1) {
            return Collections.singletonList(Collections.singletonList(1));
        }
        List<List<Integer>> tr = new ArrayList<>();
        tr.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();

            tmp.add(1);
            List<Integer> lastTmp = tr.get(i - 1);
            for (int j = 1; j < lastTmp.size(); j++) {
                tmp.add(lastTmp.get(j) + lastTmp.get(j - 1));
            }
            tmp.add(1);
            tr.add(tmp);
        }
        return tr;
    }

}
