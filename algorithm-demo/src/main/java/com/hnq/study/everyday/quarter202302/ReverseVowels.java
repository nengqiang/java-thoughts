package com.hnq.study.everyday.quarter202302;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * <p>
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 10^5
 * s 由 可打印的 ASCII 字符组成
 * 
 * @author henengqiang
 * @date 2023/6/1
 * @see <a href="https://leetcode.cn/problems/reverse-vowels-of-a-string">链接</a>
 */
public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("Euston saw I was not Sue."));
        System.out.println(reverseVowels("aA"));
        System.out.println(reverseVowels("ai"));
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

    private static String reverseVowels(String s) {
        // 7ms
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        char[] tmp = s.toCharArray();
        int l = 0, r = s.length() - 1, lp = -1, rp = -1;
        while (l < r) {
            if (list.contains(tmp[l]) && lp < 0) {
                lp = l;
            }
            if (list.contains(tmp[r]) && rp < 0) {
                rp = r;
            }
            if (lp >= 0 && rp >= 0) {
               tmp[lp] ^= tmp[rp];
               tmp[rp] ^= tmp[lp];
               tmp[lp] ^= tmp[rp];
               lp = -1;
               rp = -1;
            }
            if (lp < 0) {
                l++;
            }
            if (rp < 0) {
                r--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : tmp) {
            res.append(c);
        }
        return res.toString();
    }

    private static String reverseVowels2(String s) {
        // 3ms
        int len = s.length();
        // 将字符串转为字符数组，原因字符串是不可变的
        char[] chars = s.toCharArray();
        int i = 0, j = len - 1;
        // 只要左指针小于右指针，就进入循环
        while (i < j) {
            //左指针从左向右遍历，/并判断下遍历的每一个字符是否是元音字符，不是就继续移动
            while(i < len && notVowel(chars[i])){
                i++;
            }
            //右指针从右向左遍历，/并判断遍历的每一个字符是否有元音，不是就继续移动
            while(j > 0 && notVowel(chars[j])){
                j--;
            }
            //此时左右指针都停在了元音字符的位置，
            if (i < j) {
                //将两个字符的位置进交换
                swap(chars, i, j);
                //并同时将两个指针向右和向左移动
                i++;
                j--;
            }
        }
        //将字符数组转为字符串输出
        return new String(chars);
    }

    public static boolean notVowel(char ch){
        // 调用方法，判断这个字符在这个字符串里面的下标，
        // 如果存在，就返回该字符的第一次出现的下标，如果不存在，就返回-1
        return "aeiouAEIOU".indexOf(ch) < 0;
    }

    public static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
