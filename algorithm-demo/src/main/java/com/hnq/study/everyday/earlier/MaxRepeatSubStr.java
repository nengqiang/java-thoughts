package com.hnq.study.everyday.earlier;

/**
 * 最长重复字符串
 *
 * @author henengqiang
 * @date 2021/08/23
 */
public class MaxRepeatSubStr {

    public static void main(String[] args) {
        String str = "aabbbcddeeeeefff";
        System.out.println(maxRepeatSubStr(str));
    }

    private static String maxRepeatSubStr(String str) {
        int lastStart = 0, lastEnd = 0, start = 0, end;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                end = i;
                if (end - start > lastEnd - lastStart) {
                    lastStart = start;
                    lastEnd = end;
                }
                start = i;
            }
        }
        return str.substring(lastStart, lastEnd);
    }

}
