package com.hnq.study.patpracticegradeb;
import	java.util.regex.Pattern;

import java.util.Scanner;

/**
 * 得到“答案正确”的条件是：
 *
 * 字符串中必须仅有 P、 A、 T这三种字符，不可以包含其它字符；
 * 任意形如 xPATx 的字符串都可以获得“答案正确”，其中 x 或者是空字符串，或者是仅由字母 A 组成的字符串；
 * 如果 aPbTc 是正确的，那么 aPbATca 也是正确的，其中 a、 b、 c 均或者是空字符串，或者是仅由字母 A 组成的字符串。
 *
 * 输入：
 * 每个测试输入包含 1 个测试用例。第 1 行给出一个正整数 n (<10)，是需要检测的字符串个数。接下来每个字符串占一行，字符串长度不超过 100，且不包含空格。
 *
 * 输出：
 * 每个字符串的检测结果占一行，如果该字符串可以获得“答案正确”，则输出 YES，否则输出 NO。
 *
 * 输入：
 * 8
 * PAT
 * PAAT
 * AAPATAA
 * AAPAATAAAA
 * xPATx
 * PT
 * Whatever
 * APAAATAA
 *
 * 输出：
 * YES
 * YES
 * YES
 * YES
 * NO
 * NO
 * NO
 * NO
 *
 * 时间限制: 400 ms
 * 内存限制: 64 MB
 * 代码长度限制: 16 KB
 *
 * @author henengqiang
 * @date 2019/08/22
 */
public class AnswerIsRight {

    private static Scanner sc = new Scanner(System.in);

    /**
     * // TODO: 2019-08-22 henengqiang 有情况没考虑完全 
     */
    private static Pattern pattern = Pattern.compile("[\\sA]*PA{1,2}T[A\\s]*");

    private static final String YES = "YES";

    private static final String NO = "NO";

    public static void main(String[] args) {
        checkAnswer();
    }

    private static void checkAnswer() {
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }
        for (String word : words) {
            System.out.println(pattern.matcher(word).matches() ? YES : NO);
        }
    }

}
