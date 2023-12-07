package com.hnq.study.everyday.quarter202304;

/**
 * 1 比特与 2 比特字符
 * <p>
 * 有两种特殊字符：
 * <p>
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特（10 或 11）表示
 * 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
 * <p>
 *
 * 示例 1:
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * <p>
 *
 * 示例 2:
 * 输入：bits = [1,1,1,0]
 * 输出：false
 * 解释：唯一的解码方式是将其解析为两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 * <p>
 *
 * 提示:
 * 1 <= bits.length <= 1000
 * bits[i] 为 0 或 1
 *
 * @author henengqiang
 * @date 2023/12/7
 * @see <a href="https://leetcode.cn/problems/1-bit-and-2-bit-characters/">链接</a>
 */
public class IsOneBitCharacter {

    public static void main(String[] args) {
        IsOneBitCharacter i = new IsOneBitCharacter();
        System.out.println(i.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(i.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

    public boolean isOneBitCharacter(int[] bits) {
        // 0ms
        int k = 0, len = bits.length;
        while (k < len) {
            if (k >= len - 1 && bits[k] == 0) {
                return true;
            }
            if (bits[k] == 1) {
                k += 2;
                continue;
            }
            k++;
        }
        return false;
    }

    public boolean isOneBitCharacter2(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            i += bits[i] + 1;
        }
        return i == n - 1;
    }

    public boolean isOneBitCharacter3(int[] bits) {
        int n = bits.length, i = n - 2;
        while (i >= 0 && bits[i] == 1) {
            --i;
        }
        return (n - i) % 2 == 0;
    }

}
