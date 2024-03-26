package com.hnq.study.everyday.quarter202401;

import java.util.Arrays;

/**
 * 增减字符串匹配
 *
 * @author henengqiang
 * @date 2024/3/26
 * @see <a href="https://leetcode.cn/problems/di-string-match/">链接</a>
 */
public class DiStringMatch {

    public static void main(String[] args) {
        DiStringMatch d = new DiStringMatch();
        System.out.println(Arrays.toString(d.diStringMatch("III")));
        System.out.println(Arrays.toString(d.diStringMatch("DDI")));
        System.out.println(Arrays.toString(d.diStringMatch("IDID")));
    }

    /**
     * 贪心
     */
    public int[] diStringMatch(String s) {
        // 2ms
        int len = s.length(), lo = 0, hi = len;
        int[] ans = new int[len + 1];
        for (int i = 0; i < len; i++) {
            ans[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        ans[len] = lo;
        return ans;
    }

}
