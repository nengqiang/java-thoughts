package com.hnq.study.everyday.quarter202302;

/**
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
 * <p>
 * 
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：n = 45
 * 输出：false
 * <p>
 *
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * 进阶：你能不使用循环或者递归来完成本题吗？
 *
 * @author henengqiang
 * @date 2023/5/23
 * @see <a href="https://leetcode.cn/problems/power-of-three">链接</>
 */
public class IsPowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree4(19684));
        System.out.println(isPowerOfThree4(-1));
        System.out.println(isPowerOfThree4(27));
        System.out.println(isPowerOfThree4(0));
        System.out.println(isPowerOfThree4(9));
        System.out.println(isPowerOfThree4(45));
    }

    private static boolean isPowerOfThree(int n) {
        // 8ms
        if (n == 1) {
            return true;
        }
        if (n == 0 || n % 3 != 0) {
            return false;
        }
        int p = n / 3;
        if (p == 1) {
            return true;
        } else if (p >= 3) {
            return isPowerOfThree(p);
        } else {
            return false;
        }
    }

    private static boolean isPowerOfThree2(int n) {
        // 8ms
        if (n == 1) {
            return true;
        }
        if (n == 0 || n % 3 != 0) {
            return false;
        }
        n /= 3;
        while (n >= 1) {
            if (n == 1) {
                return true;
            }
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return false;
    }

    private static boolean isPowerOfThree3(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    private static boolean isPowerOfThree4(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
