package com.hnq.study.everyday.quarter202401;

/**
 * 仅仅反转字母
 *
 * @author henengqiang
 * @date 2024/3/15
 * @see <a href="https://leetcode.cn/problems/reverse-only-letters/">链接</a>
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        System.out.println(r.reverseOnlyLetters2("7_28]"));
        System.out.println(r.reverseOnlyLetters2("ab-cd"));
        System.out.println(r.reverseOnlyLetters2("a-bC-dEf-ghIj"));
        System.out.println(r.reverseOnlyLetters2("Test1ng-Leet=code-Q!"));
    }

    public String reverseOnlyLetters(String s) {
        // 0ms
        int p = 0, q = s.length() - 1;
        char[] arr = s.toCharArray();
        while (p < q) {
            if (isCa(arr[p])) {
                if (isCa(arr[q])) {
                    char tmp = arr[p];
                    arr[p] = arr[q];
                    arr[q] = tmp;
                    p++;
                }
                q--;
            } else {
                p++;
            }
        }
        return new String(arr);
    }

    private boolean isCa(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }

    public String reverseOnlyLetters2(String s) {
        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (true) {
            while (left < right && !Character.isLetter(s.charAt(left))) {
                left++;
            }
            while (right > left && !Character.isLetter(s.charAt(right))) {
                right--;
            }
            if (left >= right) {
                break;
            }
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return new String(arr);
    }

}
