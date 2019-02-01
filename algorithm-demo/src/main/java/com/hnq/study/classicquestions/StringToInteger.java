package com.hnq.study.classicquestions;

import org.apache.commons.lang.StringUtils;

import static com.hnq.study.utils.Constants.*;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases.
 *
 * @author henengqiang
 * @date 2019/01/31
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(stringToInteger(null));
        System.out.println(stringToInteger(""));
        System.out.println(stringToInteger(" "));
        System.out.println(stringToInteger("+2"));
        System.out.println(stringToInteger("123456789"));
        System.out.println(stringToInteger("21474836482147483648"));
        System.out.println(stringToInteger("-2147483648"));
    }

    /*
     * Analysis
     * The following cases should be considered for this problem:
     *
     * 1. null or empty string
     * 2. white spaces
     * 3. +/- sign
     * 4. calculate real value
     * 5. handle min & max
     */

    /**
     * Solution
     *
     * @param str   Given string
     * @return      Integer of String
     */
    private static Integer stringToInteger(String str) {
        if (StringUtils.isBlank(str)) {
            return 0;
        }

        // trim white spaces
        str = str.trim();

        char flag = ADD;

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == MINUS) {
            flag = MINUS;
            i++;
        } else if (str.charAt(0) == ADD) {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= ZERO && str.charAt(i) <= NINE) {
            result = result * 10 + (str.charAt(i) - ZERO);
            i++;
        }

        if (flag == MINUS) {
            result = -result;
        }

        // handle max and min
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

}
