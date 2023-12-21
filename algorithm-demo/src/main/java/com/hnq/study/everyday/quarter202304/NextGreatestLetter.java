package com.hnq.study.everyday.quarter202304;

/**
 * 寻找比目标字母大的最小字母
 * <p>
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 * <p>
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 * <p>
 *
 * 示例 1：
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * 解释：letters 中字典上比 'a' 大的最小字符是 'c'。
 * <p>
 *
 * 示例 2:
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * 解释：letters 中字典顺序上大于 'c' 的最小字符是 'f'。
 * <p>
 *
 * 示例 3:
 * 输入: letters = ["x","x","y","y"], target = "z"
 * 输出: "x"
 * 解释：letters 中没有一个字符在字典上大于 'z'，所以我们返回 letters[0]。
 * <p>
 *
 * 提示：
 * 2 <= letters.length <= 10^4
 * letters[i] 是一个小写字母
 * letters 按非递减顺序排序
 * letters 最少包含两个不同的字母
 * target 是一个小写字母
 *
 * @author henengqiang
 * @date 2023/12/21
 * @see <a href="https://leetcode.cn/problems/find-smallest-letter-greater-than-target/">链接</a>
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        NextGreatestLetter n = new NextGreatestLetter();
        System.out.println(n.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(n.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(n.nextGreatestLetter2(new char[]{'x', 'x', 'y', 'y'}, 'z'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        // 0ms
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }

    /**
     * 二分查找
     */
    public char nextGreatestLetter2(char[] letters, char target) {
        // 0ms
        int len = letters.length;
        if (target >= letters[len - 1]) {
            return letters[0];
        }
        int low = 0, high = len - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }

}
