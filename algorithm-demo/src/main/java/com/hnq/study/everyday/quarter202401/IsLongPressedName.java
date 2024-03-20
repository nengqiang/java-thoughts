package com.hnq.study.everyday.quarter202401;

/**
 * 长按键入
 *
 * @author henengqiang
 * @date 2024/3/20
 * @see <a href="https://leetcode.cn/problems/long-pressed-name/">链接</a>
 */
public class IsLongPressedName {

    public static void main(String[] args) {
        IsLongPressedName i = new IsLongPressedName();
        System.out.println(i.isLongPressedName("alex", "aaleex"));
        System.out.println(i.isLongPressedName("saeed", "ssaaedd"));
    }

    public boolean isLongPressedName(String name, String typed) {
        // 1ms
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

}
