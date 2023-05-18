package com.hnq.study.everyday.quarter202302;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一种规律 pattern和一个字符串s，判断 s是否遵循相同的规律。
 * <p>
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串s中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 *
 * 示例1:
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * <p>
 *
 * 示例 2:
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * <p>
 *
 * 示例 3:
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 *
 * 提示:
 * 1 <= pattern.length <= 300
 * pattern只包含小写英文字母
 * 1 <= s.length <= 3000
 * s只包含小写英文字母和' '
 * s不包含任何前导或尾随对空格
 * s中每个单词都被 单个空格 分隔
 *
 * @author henengqiang
 * @date 2023/5/18
 * @see <a href="https://leetcode.cn/problems/word-pattern">链接</a>
 */
public class WordPattern {

    public static void main(String[] args) {
        String p4 = "abba", s4 = "dog dog dog dog";
        System.out.println(wordPattern3(p4, s4));
        String p1 = "abba", s1 = "dog cat cat dog";
        System.out.println(wordPattern3(p1, s1));
        String p2 = "abba", s2 = "dog cat cat fish";
        System.out.println(wordPattern3(p2, s2));
        String p3 = "aaaa", s3 = "dog cat cat dog";
        System.out.println(wordPattern3(p3, s3));
    }

    private static boolean wordPattern(String pattern, String s) {
        // 3ms
        String[] k = pattern.split("");
        String[] v = s.split("\\s");
        if (k.length != v.length) {
            return false;
        }
        Map<String, String> m = new HashMap<>(k.length * 3 / 2);
        for (int i = 0; i < k.length; i++) {
            // 失败有两种情况：
            // 1.key存在，经过查找字母对应的单词和这个单词不匹配；
            // 2.key不存在，但是这个单词已经被存了；
            if (m.containsKey(k[i]) && !m.get(k[i]).equals(v[i])) {
                return false;
            }
            if(!m.containsKey(k[i]) && m.containsValue(v[i])) {
                return false;
            }
            m.put(k[i], v[i]);
        }
        return true;
    }

    private static boolean wordPattern2(String pattern, String s) {
        String[] k = pattern.split("");
        String[] v = s.split("\\s");
        if (k.length != v.length) {
            return false;
        }
        Map<String, String> m1 = new HashMap<>(k.length * 3 / 2);
        Map<String, String> m2 = new HashMap<>(k.length * 3 / 2);
        for (int i = 0; i < k.length; i++) {
            // 失败有两种情况：
            // 1.key存在，经过查找字母对应的单词和这个单词不匹配；
            // 2.key不存在，但是这个单词已经被存了；
            if (m1.containsKey(k[i]) && !m1.get(k[i]).equals(v[i])) {
                return false;
            }
            if(!m1.containsKey(k[i]) && m2.containsKey(v[i])) {
                return false;
            }
            m1.put(k[i], v[i]);
            m2.put(v[i], k[i]);
        }
        return true;
    }

    private static boolean wordPattern3(String pattern, String s) {
        // 0ms
        String[] words = s.split(" ");
        //字符和单词是互相映射，数量必须相等
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            /*
                如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。

                以pattern = "abba", str = "dog cat cat dog"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("dog",3)返回0，两者相等，
                结果为 true。

                以pattern = "abba", str = "dog cat cat fish"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("fish",3)返回null，两者不相等，
                结果为 false。
            */
            if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(words[i], i))) {
                return false;
            }
        }
        return true;
    }

}
