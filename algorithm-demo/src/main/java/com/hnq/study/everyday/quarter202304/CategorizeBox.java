package com.hnq.study.everyday.quarter202304;

/**
 * 根据规则将箱子分类
 * <p>
 * 给你四个整数 length ，width ，height 和 mass ，分别表示一个箱子的三个维度和质量，请你返回一个表示箱子 类别 的字符串。
 * <p>
 * 如果满足以下条件，那么箱子是 "Bulky" 的：
 *      箱子 至少有一个 维度大于等于 10^4 。
 *      或者箱子的 体积 大于等于 10^9 。
 * 如果箱子的质量大于等于 100 ，那么箱子是 "Heavy" 的。
 *
 * 如果箱子同时是 "Bulky" 和 "Heavy" ，那么返回类别为 "Both" 。
 * 如果箱子既不是 "Bulky" ，也不是 "Heavy" ，那么返回类别为 "Neither" 。
 * 如果箱子是 "Bulky" 但不是 "Heavy" ，那么返回类别为 "Bulky" 。
 * 如果箱子是 "Heavy" 但不是 "Bulky" ，那么返回类别为 "Heavy" 。
 * 注意，箱子的体积等于箱子的长度、宽度和高度的乘积。
 * <p>
 *
 * 示例 1：
 * 输入：length = 1000, width = 35, height = 700, mass = 300
 * 输出："Heavy"
 * 解释：
 * 箱子没有任何维度大于等于 10^4 。
 * 体积为 24500000 <= 10^9 。所以不能归类为 "Bulky" 。
 * 但是质量 >= 100 ，所以箱子是 "Heavy" 的。
 * 由于箱子不是 "Bulky" 但是是 "Heavy" ，所以我们返回 "Heavy" 。
 * <p>
 *
 * 示例 2：
 * 输入：length = 200, width = 50, height = 800, mass = 50
 * 输出："Neither"
 * 解释：
 * 箱子没有任何维度大于等于 10^4 。
 * 体积为 8 * 10^6 <= 10^9 。所以不能归类为 "Bulky" 。
 * 质量小于 100 ，所以不能归类为 "Heavy" 。
 * 由于不属于上述两者任何一类，所以我们返回 "Neither" 。
 * <p>
 *
 * 提示：
 * 1 <= length, width, height <= 10^5
 * 1 <= mass <= 10^3
 *
 * @author henengqiang
 * @date 2023/10/20
 * @see <a href="https://leetcode.cn/problems/categorize-box-according-to-criteria/?envType=daily-question&envId=2023-10-20">链接</a>
 */
public class CategorizeBox {

    public static void main(String[] args) {
        CategorizeBox c = new CategorizeBox();
        System.out.println(c.categorizeBox(1000, 1000, 1000, 1000));
        System.out.println(c.categorizeBox(1000, 35, 700, 300));
        System.out.println(c.categorizeBox(200, 50, 800, 50));
    }

    public String categorizeBox(int length, int width, int height, int mass) {
        // 0ms
        boolean anyDimensionGe10000 = length >= 10_000 || width >= 10_000 || height >= 10_000;
        boolean volumeGe1000_000_000 = (long) length * width * height >= 1000_000_000L;
        boolean b = anyDimensionGe10000 || volumeGe1000_000_000;
        boolean h = mass >= 100;
        if (b && h) {
            return "Both";
        }
        if (b) {
            return "Bulky";
        }
        if (h) {
            return "Heavy";
        }
        return "Neither";
    }

}
