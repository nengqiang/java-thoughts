package com.hnq.study.everyday.month202207;

/**
 * 给你一个字符串columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号。
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 * 
 * 示例 1:
 * 输入: columnTitle = "A"
 * 输出: 1
 *
 * 示例2:
 * 输入: columnTitle = "AB"
 * 输出: 28
 *
 * 示例3:
 * 输入: columnTitle = "ZY"
 * 输出: 701
 *
 * 提示：
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 *
 * @author henengqiang
 * @date 2022/7/8
 * @see <a href="https://leetcode.cn/problems/excel-sheet-column-number">链接</a>
 */
public class TitleToNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("FXSHRXW"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("AAA"));
    }

    private static int titleToNumber(String columnTitle) {
        // 0ms
        if (columnTitle == null || "".equals(columnTitle)) {
            return 0;
        }
        int len = columnTitle.length();
        int st = 1, val = 0;
        for (int i = len - 1; i >= 0; i--) {
            int n = (columnTitle.charAt(i) - 'A') + 1;
            val += n * st;
            st *= 26;
        }
        return val;
    }

}
