package com.hnq.study.classicquestions;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Giving a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all possible sentences.
 *
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"],
 *
 * the solution is ["cats and dog", "cat sand dog"].
 *
 * @author henengqiang
 * @date 2018/12/18
 */
public class WordBreak2 {

    private static final String S = "catsanddog";

    private static final Set<String> DICT = Sets.newHashSet("cat", "cats", "and", "sand", "dog");

    private static final Integer DIVIDING_LINE_NUM = 30;

    public static void main(String[] args) {
        System.out.println(S + DICT);
        List<String> result1 = wordBreak1(S, DICT);
        System.out.println(result1);

        for (int i = 0; i < DIVIDING_LINE_NUM; i++) {
            if (i == DIVIDING_LINE_NUM - 1) {
                System.out.println("=");
            } else {
                System.out.print("=");
            }
        }

        List<String> result2 = wordBreak2(S, DICT);
        System.out.println(result2);
    }

    /**
     * Solution 1 - Dynamic Programming
     *
     * This problem is very similar to Word Break. Instead of using a boolean array to track the matched positions,
     * we need to track the actual matched words. Then we can use depth first search to get all the possible paths,
     * i.e., the list of strings.
     *
     * The following diagram shows the structure of the tracking array.
     *     index   Words
     *  c   0
     *  a   1
     *  t   2
     *  s   3       cat
     *  a   4       cats
     *  n   5
     *  d   6
     *  d   7       and,sand
     *  o   8
     *  g   9
     *      10      dog
     *
     * @param s     the giving string
     * @param dict  the giving dictionary of words dict
     * @return      a {@link List} of {@link String}
     */
    private static List<String> wordBreak1(String s, Set<String> dict) {
        // create an array of ArrayList<String>
        ArrayList<String>[] dp = new ArrayList[s.length() + 1];
        dp[0] = Lists.newArrayList();

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null) {
                continue;
            }

            for (String word : dict) {
                int len = word.length();
                int end = i + len;
                if (end > s.length()) {
                    continue;
                }

                if (s.substring(i, end).equals(word)) {
                    if (dp[end] == null) {
                        dp[end] = Lists.newArrayList();
                    }
                    dp[end].add(word);
                }
            }
        }

        List<String> result = Lists.newLinkedList();
        if (dp[s.length()] == null) {
            return result;
        }

        List<String> temp = Lists.newArrayList();
        dfs1(dp, s.length(), result, temp);

        return result;
    }

    private static void dfs1(List<String>[] dp, int end, List<String> result, List<String> tmp) {
        if (end < 0) {
            StringBuilder path = new StringBuilder(tmp.get(tmp.size() - 1));
            int theConst = 2;
            for (int i = tmp.size() - theConst; i >= 0; i--) {
                path.append(" ").append(tmp.get(i));
            }

            result.add(path.toString());
            return;
        }

        for (String str : dp[end]) {
            tmp.add(str);
            dfs1(dp, end - str.length(), result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * Solution 2 - simplified
     *
     * @param s         the giving string
     * @param wordDict  the giving dictionary of words dict
     * @return          a {@link List} of {@link String}
     */
    private static List<String> wordBreak2(String s, Set<String> wordDict) {
        ArrayList<String>[] pos = new ArrayList[s.length() + 1];
        pos[0] = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (pos[i] != null) {
                for (int j = i + 1; j < s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (wordDict.contains(sub)) {
                        if (pos[j] == null) {
                            ArrayList<String> list = Lists.newArrayList();
                            list.add(sub);
                            pos[j] = list;
                        } else {
                            pos[j].add(sub);
                        }
                    }
                }
            }
        }

        if (pos[s.length()] == null) {
            return Lists.newArrayList();
        } else {
            ArrayList<String> result = Lists.newArrayList();
            dfs2(pos, result, "", s.length());
            return result;
        }
    }

    private static void dfs2(ArrayList<String>[] pos, ArrayList<String> result, String curr, int i) {
        if (i == 0) {
            result.add(curr.trim());
            return;
        }
        for (String s : pos[i]) {
            String combined = s + " " + curr;
            dfs2(pos, result, combined, i - s.length());
        }
    }

    /*
     * This problem is also useful for solving real problems. Assuming you want to analyze the domain names of the
     * top 10k website. We can use this solution to break the main part of the domain into words and then get a
     * sense of what kinds of websites are popular. He did this a long time ago and found some interesting results.
     * For example, the most frequent words include "news", "tube", "porn", "etc".
     */

}
