package com.hnq.study.everyday.earlier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 *
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 *
 * 示例 3:
 * 输入: rowIndex = 1
 *
 * 输出: [1,1]
 * 提示:
 * 0 <= rowIndex <= 33
 *
 * @author henengqiang
 * @date 2021/08/05
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle-ii">链接</a>
 */
public class PascalsTriangle2 {

    public static void main(String[] args) {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(3));
    }

    private static List<Integer> getRow(int rowIndex) {
        // 1ms
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }
        List<Integer> lastRow = new ArrayList<>(Collections.singletonList(1));
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < lastRow.size(); j++) {
                tmp.add(lastRow.get(j) + lastRow.get(j - 1));
            }
            tmp.add(1);
            lastRow = tmp;
        }
        return lastRow;
    }

}
