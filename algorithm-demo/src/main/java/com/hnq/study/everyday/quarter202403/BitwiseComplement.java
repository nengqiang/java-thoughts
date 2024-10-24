package com.hnq.study.everyday.quarter202403;

/**
 * @author henengqiang
 * @date 2024/10/24
 */
public class BitwiseComplement {

    public static void main(String[] args) {
        BitwiseComplement b = new BitwiseComplement();
        System.out.println(b.bitwiseComplement2(1234567891));
        System.out.println(b.bitwiseComplement2(10));
        System.out.println(b.bitwiseComplement2(5));
        System.out.println(b.bitwiseComplement2(7));
    }

    public int bitwiseComplement(int n) {
        // 0ms
        String bs = Integer.toBinaryString(n);
        int len = bs.length(), ans = 0;
        boolean firstOne = false;
        for (int i = 0; i < len; i++) {
            int k = len - i - 1;
            if (firstOne) {
                if (bs.charAt(i) == '0') {
                    int tmp = 1;
                    for (int j = 0; j < k; j++) {
                        tmp *= 2;
                    }
                    ans += tmp;
                }
            } else {
                if (bs.charAt(i) == '0') {
                    firstOne = true;
                    int tmp = 1;
                    for (int j = 0; j < k; j++) {
                        tmp *= 2;
                    }
                    ans += tmp;
                }
            }
        }
        return ans;
    }

    /**
     * 位运算
     */
    public int bitwiseComplement2(int n) {
        int highbit = 0;
        for (int i = 0; i <= 30; i++) {
            if (n >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return n ^ mask;
    }

}
