package com.hnq.study.interview;

/**
 * @author henengqiang
 * @since 2026/3/6
 * @see <a href="https://leetcode.cn/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75">压缩字符串</a>
 */
public class Compress {

    public static void main(String[] args) {
        Compress c = new Compress();
        System.out.println(c.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(c.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(c.compress(new char[]{'a'}));
    }

    public int compress(char[] chars) {
        // 1ms
        int len = chars.length;
        if (len == 1) {
            return 1;
        }
        char last = chars[0];
        int res = 0, count = 1, k = 0;
        for (int i = 1; i < len; i++) {
            if (chars[i] == last) {
                count++;
            } else {
                if (count == 1) {
                    chars[k++] = last;
                    res++;
                } else {
                    chars[k++] = last;
                    String countStr = String.valueOf(count);
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[k++] = countStr.charAt(j);
                    }
                    res += 1 + countStr.length();
                }
                last = chars[i];
                count = 1;
            }
        }
        if (count == 1) {
            chars[k++] = last;
            res++;
        } else {
            chars[k++] = last;
            String countStr = String.valueOf(count);
            for (int j = 0; j < countStr.length(); j++) {
                chars[k++] = countStr.charAt(j);
            }
            res += 1 + countStr.length();
        }
        return res;
    }

    // 双指针：写指针在后 读指针在前，最后返回写指针的位置即可

}
