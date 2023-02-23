package com.hnq.study.everyday.month202302;

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * <p>
 *
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 * <p>
 *
 * 示例 1：
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * <p>
 *
 * 示例 2：
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * <p>
 *
 * 提示：
 * 1 <= num < 2^31
 *
 * @author henengqiang
 * @date 2023/2/23
 * @see <a href="https://leetcode.cn/problems/number-complement">链接</a>
 */
public class FindComplement {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }

    public static int findComplement(int num) {
        // 1ms 38.4MB
        String biStr = Integer.toBinaryString(num);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < biStr.length(); i++) {
            s.append(biStr.charAt(i) == '1' ? "0" : "1");
        }
        return Integer.parseInt(s.toString(), 2);
    }

    /**
     * 参考hashmap获得hash值实现
     */
    public static int findComplement2(int num) {
        int n = num;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n ^ num;
    }

    /**
     * JDK11的改进，使用二分查找前置零
     */
    public static int findComplement3(int num) {
        int n = -1 >>> Integer.numberOfLeadingZeros(num);
        return n ^ num;
    }

}
