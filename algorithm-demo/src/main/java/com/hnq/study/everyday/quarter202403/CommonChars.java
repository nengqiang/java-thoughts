package com.hnq.study.everyday.quarter202403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author henengqiang
 * @date 2024/10/21
 */
public class CommonChars {

    public static void main(String[] args) {
        CommonChars c = new CommonChars();
        System.out.println(c.commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"}));
        System.out.println(c.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(c.commonChars(new String[]{"cool", "lock", "cook"}));
    }

    public List<String> commonChars(String[] words) {
        // 3ms
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; i++) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minfreq[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

}
