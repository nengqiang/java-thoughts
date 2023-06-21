package com.hnq.study.everyday.quarter202302;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 *
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * @author henengqiang
 * @date 2023/6/21
 * @see <a href="https://leetcode.cn/problems/number-of-segments-in-a-string">链接</a>
 */
public class CountSegments {

    public static void main(String[] args) {
        CountSegments c = new CountSegments();
        System.out.println(c.countSegments(", , , ,        a, eaefa"));
        System.out.println(c.countSegments("The one-hour drama series Westworld is a dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged."));
        System.out.println(c.countSegments(""));
        System.out.println(c.countSegments("love live! mu'sic forever"));
        System.out.println(c.countSegments("Hello, my name is John"));
        System.out.println(c.countSegments("Hello, my name is "));
        System.out.println(c.countSegments("Hello, my name is ,"));
        System.out.println(c.countSegments("Hello, my name is ,a"));
        System.out.println(c.countSegments(" Hello, my name is ,a"));
        System.out.println(c.countSegments(" ,Hello, my name is ,a"));
        System.out.println(c.countSegments("a,Hello, my name is ,a"));
        System.out.println(c.countSegments("a ,Hello, my name is ,a"));
    }

    /**
     * 原地法
     * <p>
     * 计算字符串中单词的数量，就等同于计数单词的第一个下标的个数。
     * 因此，我们只需要遍历整个字符串，统计每个单词的第一个下标的数目即可。
     * <p>
     * 满足单词的第一个下标有以下两个条件：
     *  该下标对应的字符不为空格；
     *  该下标为初始下标或者该下标的前下标对应的字符为空格；
     */
    public int countSegments(String s) {
        // 0ms
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }

}
