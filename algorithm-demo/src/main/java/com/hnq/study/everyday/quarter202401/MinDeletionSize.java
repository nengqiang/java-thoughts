package com.hnq.study.everyday.quarter202401;

/**
 * 删列造序
 *
 * @author henengqiang
 * @date 2024/3/27
 * @see <a href="https://leetcode.cn/problems/delete-columns-to-make-sorted/">链接</a>
 */
public class MinDeletionSize {

    public static void main(String[] args) {
        MinDeletionSize m = new MinDeletionSize();
        System.out.println(m.minDeletionSize(new String[]{"rrjk","furt","guzm"}));
        System.out.println(m.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(m.minDeletionSize(new String[]{"a", "b"}));
        System.out.println(m.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }

    public int minDeletionSize(String[] strs) {
        // 7ms
        int row = strs.length;
        int col = strs[0].length();
        int ans = 0;
        for (int j = 0; j < col; ++j) {
            for (int i = 1; i < row; ++i) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

}
