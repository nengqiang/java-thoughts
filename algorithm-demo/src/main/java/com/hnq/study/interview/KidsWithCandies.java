package com.hnq.study.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author henengqiang
 * @date 2026/2/26
 * @see <a href="https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75">拥有最多糖果的孩子</a>
 */
public class KidsWithCandies {

    public static void main(String[] args) {
        KidsWithCandies k = new KidsWithCandies();
        System.out.println(k.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(k.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(k.kidsWithCandies(new int[]{12, 1, 12}, 10));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        List<Boolean> res = new ArrayList<>(candies.length);
        for (int candy : candies) {
            res.add(candy + extraCandies >= maxCandies);
        }

        return res;
    }

}
