package com.hnq.study.everyday.quarter202403;

/**
 * @author henengqiang
 * @date 2024/11/12
 */
public class CountKConstraintSubstrings {

    public static void main(String[] args) {
        CountKConstraintSubstrings c = new CountKConstraintSubstrings();
        System.out.println(c.countKConstraintSubstrings2("10101", 1));
        System.out.println(c.countKConstraintSubstrings2("1010101", 2));
        System.out.println(c.countKConstraintSubstrings2("11111", 1));
    }

    public int countKConstraintSubstrings(String s, int k) {
        // 36ms
        int len = s.length();
        if (len == 1 && len <= k) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len + 1; j++) {
                String tmp = s.substring(i, j);
                int c0 = 0, c1 = 0;
                for (char c : tmp.toCharArray()) {
                    if (c == '0') {
                        c0++;
                    }
                    if (c == '1') {
                        c1++;
                    }
                }
                if (c0 <= k || c1 <= k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 滑动窗口
     */
    public int countKConstraintSubstrings2(String s, int k) {
        // 1ms
        int left = 0, count0 = 0, count1 = 0, count = 0;
        for (int right = 0; right < s.length(); right++) {
            // 更新窗口的数据
            if (s.charAt(right) == '0') {
                count0++;
            } else {
                count1++;
            }

            // 窗口内0和1都超过k，左指针右移
            while (count0 > k && count1 > k) {
                if (s.charAt(left) == '0') {
                    count0--;
                } else {
                    count1--;
                }
                left++;
            }

            // 计算当前窗口内的有效字符串个数
            count += (right - left + 1);
        }
        return count;
    }

}
