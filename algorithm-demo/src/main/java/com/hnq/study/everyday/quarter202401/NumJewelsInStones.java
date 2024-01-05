package com.hnq.study.everyday.quarter202401;

/**
 * 宝石与石头
 * <p>
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 * stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * <p>
 *
 * 示例 1：
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * <p>
 *
 * 示例 2：
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 * <p>
 *
 * 提示：
 * 1 <= jewels.length, stones.length <= 50
 * jewels 和 stones 仅由英文字母组成
 * jewels 中的所有字符都是 唯一的
 *
 * @author henengqiang
 * @date 2024/1/5
 * @see <a href="https://leetcode.cn/problems/jewels-and-stones/">链接</a>
 */
public class NumJewelsInStones {

    public static void main(String[] args) {
        NumJewelsInStones n = new NumJewelsInStones();
        System.out.println(n.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(n.numJewelsInStones("z", "ZZ"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        // 0ms
        int count = 0;
        for (int i = 0, k = stones.length(); i < k; i++) {
            if (jewels.indexOf(stones.charAt(i)) >= 0) {
                count++;
            }
        }
        return count;
    }

}
