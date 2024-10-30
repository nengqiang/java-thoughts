package com.hnq.study.everyday.quarter202403;

/**
 * @author henengqiang
 * @date 2024/10/30
 */
public class GetSmallestString {

    public static void main(String[] args) {
        GetSmallestString g = new GetSmallestString();
        System.out.println(g.getSmallestString("45320"));
        System.out.println(g.getSmallestString("001"));
    }

    public String getSmallestString(String s) {
        // 1ms
        char[] arr = s.toCharArray();
        for (int i = 0; i + 1 < arr.length; i++) {
            if (arr[i] > arr[i + 1] && arr[i] % 2 == arr[i + 1] % 2) {
                char tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
                break;
            }
        }
        return new String(arr);
    }

}
