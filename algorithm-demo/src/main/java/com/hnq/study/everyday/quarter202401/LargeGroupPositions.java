package com.hnq.study.everyday.quarter202401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 较大分组的位置
 * <p>
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
 * 上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 *
 * 示例 1：
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * <p>
 *
 * 示例 2：
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * <p>
 *
 * 示例 3：
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * <p>
 *
 * 示例 4：
 * 输入：s = "aba"
 * 输出：[]
 * <p>
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅含小写英文字母
 *
 * @author henengqiang
 * @date 2024/1/30
 * @see <a href="https://leetcode.cn/problems/positions-of-large-groups/">链接</a>
 */
public class LargeGroupPositions {

    public static void main(String[] args) {
        LargeGroupPositions l = new LargeGroupPositions();
        System.out.println(l.largeGroupPositions2("aaa"));
        System.out.println(l.largeGroupPositions2("abbxxxxzzy"));
        System.out.println(l.largeGroupPositions2("abcdddeeeeaabbbcd"));
        System.out.println(l.largeGroupPositions2("abc"));
        System.out.println(l.largeGroupPositions2("aba"));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        // 1ms
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0, end;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            boolean flag = i == s.length() - 1;
            if (!flag && s.charAt(i) == c) {
                continue;
            }
            end = flag && s.charAt(i) == s.charAt(i - 1) ? i : i - 1;
            if (end - start >= 2) {
                List<Integer> t = new ArrayList<>();
                t.add(start);
                t.add(end);
                ans.add(t);
            }
            start = i;
            c = s.charAt(i);
        }
        return ans;
    }

    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length(), num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ans.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ans;
    }

}
