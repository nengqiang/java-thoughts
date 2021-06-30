package com.hnq.study.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 *
 * 
 *
 * 示例1:
 *
 * 输入:"III"
 * 输出: 3
 * 示例2:
 *
 * 输入:"IV"
 * 输出: 4
 * 示例3:
 *
 * 输入:"IX"
 * 输出: 9
 * 示例4:
 *
 * 输入:"LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例5:
 *
 * 输入:"MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author henengqiang
 * @date 2021/6/23
 */
public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt2("III"));
        System.out.println(romanToInt2("IV"));
        System.out.println(romanToInt2("IX"));
        System.out.println(romanToInt2("LVIII"));
        System.out.println(romanToInt2("MCMXCIV"));

        System.out.println(romanToInt2("XLIX"));
        System.out.println(romanToInt2("CMXCIX"));
    }

    private static int romanToInt(String s) {
        // 19ms
        Map<Character, Integer> romanMap = new HashMap<>(10);
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        Map<String, Integer> speRomMap = new HashMap<>(8);
        speRomMap.put("IV", 4);
        speRomMap.put("IX", 9);
        speRomMap.put("XL", 40);
        speRomMap.put("XC", 90);
        speRomMap.put("CD", 400);
        speRomMap.put("CM", 900);
        if (speRomMap.containsKey(s)) {
            return speRomMap.get(s);
        }
        int res = 0;
        int len = s.length();
        int i = 0;
        while (i < len) {
            char l = s.charAt(i);
            if (i >= len - 1) {
                res += romanMap.get(l);
                break;
            }
            char r = s.charAt(i + 1);
            if (romanMap.get(l) < romanMap.get(r)) {
                res += speRomMap.get(String.valueOf(l) + r);
                i += 1;
            } else {
                res += romanMap.get(l);
            }
            i++;
        }

        return res;
    }

    private static int romanToInt2(String s) {
        // 11ms
        Map<Character, Integer> romanMap = new HashMap<>(10);
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int res = 0;
        int len = s.length();
        int i = 0;
        while (i < len) {
            char l = s.charAt(i);
            if (i >= len - 1) {
                res += romanMap.get(l);
                break;
            }
            char r = s.charAt(i + 1);
            if (romanMap.get(l) < romanMap.get(r)) {
                res -= romanMap.get(l);
            } else {
                res += romanMap.get(l);
            }
            i++;
        }

        return res;
    }

}
