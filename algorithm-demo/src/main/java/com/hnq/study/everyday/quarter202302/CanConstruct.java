package com.hnq.study.everyday.quarter202302;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 *
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote 和 magazine 由小写英文字母组成
 * 
 * @author henengqiang
 * @date 2023/6/7
 * @see <a href="https://leetcode.cn/problems/ransom-note">链接</a>
 */
public class CanConstruct {

    public static void main(String[] args) {
        CanConstruct c =  new CanConstruct();
        System.out.println(c.canConstruct2("a", "b"));
        System.out.println(c.canConstruct2("aa", "ab"));
        System.out.println(c.canConstruct2("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // 10ms
        Map<Character, Integer> m = new HashMap<>(magazine.length() * 3 / 2);
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            m.merge(c, 1, Integer::sum);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer ex = m.get(c);
            if (ex == null || ex <= 0) {
                return false;
            } else {
                m.put(c, ex - 1);
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        // 2ms
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            arr[idx]--;
            if (arr[idx] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct3(String ransomNote, String magazine) {
        // 1ms
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
