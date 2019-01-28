package com.hnq.study.classicquestions;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string(not partial).
 *
 * The function prototype should be:
 * bool is Match(const char *s, const char *p)
 *
 * Some examples:
 * isMatch1("aa", "a")           return false
 * isMatch1("aa", "aa")          return true
 * isMatch1("aaa", "aa")         return false
 * isMatch1("aa", "a*")          return true
 * isMatch1("aa", ".*")          return true
 * isMatch1("ab", ".*")          return true
 * isMatch1("aab", "c*a*b*")     return true
 *
 * @author henengqiang
 * @date 2019/01/28
 */
public class RegularExpression {

    public static void main(String[] args) {
        System.out.println(isMatch1("aa", "a"));
        System.out.println(isMatch1("aa", "aa"));
        System.out.println(isMatch1("aaa", "aa"));
        System.out.println(isMatch1("aa", "a*"));
        System.out.println(isMatch1("aa", ".*"));
        System.out.println(isMatch1("ab", ".*"));
        System.out.println(isMatch1("aab", "c*a*b*"));

        int separatorNum = 30;
        for (int i = 0; i < separatorNum; i++) {
            if (i == separatorNum - 1) {
                System.out.println("=");
            } else {
                System.out.print("=");
            }
        }

        System.out.println(isMatch2("aa", "a"));
        System.out.println(isMatch2("aa", "aa"));
        System.out.println(isMatch2("aaa", "aa"));
        System.out.println(isMatch2("aa", "a*"));
        System.out.println(isMatch2("aa", ".*"));
        System.out.println(isMatch2("ab", ".*"));
        System.out.println(isMatch2("aab", "c*a*b*"));
    }

    /*
     * First of all, this is one of the most difficulty problems. It is hard to think through all different cases.
     * The problem should be simplified to handle 2 basic cases:
     *
     * -> the second char of pattern is "*"
     * -> the second char of pattern is not "*"
     *
     * For the 1st case, if the first char of pattern is not ".", the first char of pattern and string should be
     * the same. Then continue to match the remaining part.
     *
     * For the 2nd case, if the first char of pattern is "." or first char of pattern == the first i char of string,
     * continue to match the remaining part.
     *
     */

    /**
     * The following Java solution is accepted.
     *
     * @param str       the string to be matched
     * @param regular   the regular to match string
     * @return          is match
     */
    private static boolean isMatch1(String str, String regular) {
        char reg1 = '*';
        char reg2 = '.';
        if (regular.length() == 0) {
            return str.length() == 0;
        }

        // regular's length 1 is special case
        if (regular.length() == 1 || regular.charAt(1) != reg1) {
            boolean isFirstCharOfStrMatchesRegular = regular.charAt(0) != reg2 && str.charAt(0) != regular.charAt(0);
            if (str.length() < 1 || isFirstCharOfStrMatchesRegular) {
                return false;
            }
            return isMatch1(str.substring(1), regular.substring(1));
        } else {
            int len = str.length();
            int i = -1;
            while (i < len && (i < 0 || regular.charAt(0) == reg2 || regular.charAt(0) == str.charAt(i))) {
                if (isMatch1(str.substring(i + 1), regular.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    /**
     * More Readable
     *
     * @param str       the string to be matched
     * @param regular   the regular to match string
     * @return          is match
     */
    private static boolean isMatch2(String str, String regular) {
        char star = '*';
        char point = '.';
        // base case
        if (regular.length() == 0) {
            return str.length() == 0;
        }

        boolean isFirstCharOfStrMatchesRegular
                = str.length() > 0 && regular.charAt(0) != str.charAt(0) && regular.charAt(0) != point;

        // special case
        if (regular.length() == 1) {
            // if the length of str is 0, return false
            if (str.length() < 1) {
                return false;
            }

            // if the first dose not match, return false
            else if (isFirstCharOfStrMatchesRegular) {
                return false;
            }

            // otherwise, compare the rest of the string of str and regular.
            else {
                return isMatch2(str.substring(1), regular.substring(1));
            }
        }

        // case 1: when the second char of regular is not '*'
        if (regular.charAt(1) != star) {
            if (str.length() < 1) {
                return false;
            }
            if (isFirstCharOfStrMatchesRegular) {
                return false;
            } else {
                return isMatch2(str.substring(1), regular.substring(1));
            }
        }

        // case 2: when the second char of regular is '*', complex case.
        else {
            // case 2.1: a char & '*' can stand for 0 element
            if (isMatch2(str, regular.substring(2))) {
                return true;
            }

            // case 2.2: a char & '*' can stand for 1 or more preceding element, so try every substring
            int i = 0;
            while (i < str.length() && (str.charAt(i) == regular.charAt(0) || regular.charAt(0) == point)) {
                if (isMatch2(str.substring(i + 1), regular.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }

    }

}
