package com.hnq.study.everyday.quarter202302;

/**
 * 给你一个整数columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 *
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 * <p>
 *
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 * <p>
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 * <p>
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 * <p>
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * <p>
 * 提示：
 * 1 <= columnNumber <= 2^31 - 1
 * 
 * @author henengqiang
 * @date 2023/5/6
 * @see <a href="https://leetcode.cn/problems/excel-sheet-column-title">链接</a>
 */
public class ConvertToTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(Integer.MAX_VALUE));
    }

    /**
     * 1对应A，26对应Z，看起来像是27进位，似乎应该每次余27，每次除以27。
     * 但是，因为1对应A，而27对应的也是A，1%27=1, 27%27=0，同一个A余数不同，构成矛盾。
     * 那么除以26行不行？
     * 1%26=1,27%26=1，看起来这样似乎可以保持一致。
     * 但是当26%26的时候，为0，可是实际的值却为Z，又构成了新的矛盾。
     *
     * 所以，我们调整对应关系，让0对应A，25对应Z，26对应AA，这样就构成了一个正常的26进位。
     * 这样对于A：0%26=0， 对于AA：26%26=0，在余数这里可以保持一致。
     * 新的对应关系是原先对应关系-1得到，所以在每次操作的时候，都要让columnNumber-1，得到新的对应关系。
     */
    private static String convertToTitle(int columnNumber) {
        // 0ms
        int p = 26, t = columnNumber;
        StringBuilder res = new StringBuilder();
        while (t > 0) {
            int cur = (t - 1) % p;
            t = (t - 1) / p;
            res.insert(0, (char) ('A' + cur));
        }
        return res.toString();
    }

}
