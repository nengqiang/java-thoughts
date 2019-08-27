package com.hnq.study.patpracticegradeb;

import java.util.Scanner;

/**
 * 给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。
 *
 * 输入：
 *  测试输入包含一个测试用例，在一行内给出总长度不超过 80 的字符串。字符串由若干单词和若干空格组成，其中单词是由英文字母（大小写有区分）
 *  组成的字符串，单词之间用 1 个空格分开，输入保证句子末尾没有多余的空格。
 *  Hello World Here I Come
 *
 * 输出：
 *  每个测试用例的输出占一行，输出倒序后的句子。
 *  Come I Here World Hello
 *
 * @author henengqiang
 * @date 2019/8/27 0027
 */
public class SpeakContrary {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String sentence = sc.nextLine();
        printContrary(sentence);
    }

    private static void printContrary(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        System.out.print(sb.substring(0, sb.length() - 1));
    }

}
