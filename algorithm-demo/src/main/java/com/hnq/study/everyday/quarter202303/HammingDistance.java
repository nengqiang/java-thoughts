package com.hnq.study.everyday.quarter202303;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * 
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 *
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 *
 * 提示：
 * 0 <=x, y <= 2^31 - 1
 *
 * @author henengqiang
 * @date 2023/7/4
 * @see <a href="https://leetcode.cn/problems/hamming-distance">链接</a>
 */
public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance h = new HammingDistance();
        System.out.println(h.hammingDistance(1, 4));
        System.out.println(h.hammingDistance(3, 1));
    }

    public int hammingDistance(int x, int y) {
        // 0ms
        int z = x ^ y;
        return getOneOfInt2(z);
    }

    public int getOneOfInt1(int x) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >> i) & 1) == 1) {
                cnt ++;
            }
        }
        return cnt;
    }

    public int getOneOfInt2(int x) {
        int cnt = 0;
        while (x > 0) {
            cnt++;
            x &= (x - 1);
        }
        return cnt;
    }

    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
