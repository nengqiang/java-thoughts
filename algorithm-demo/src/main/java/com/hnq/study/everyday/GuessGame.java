package com.hnq.study.everyday;

/**
 * @author henengqiang
 * @date 2023/6/6
 */
public class GuessGame {

    int x = 2;

    public int guess(int n) {
        return Integer.compare(x, n);
    }

}
