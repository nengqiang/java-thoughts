package com.hnq.basics.thinkinginjava8.onjava;

/**
 * @author henengqiang
 * @date 2020/11/19
 */
public class Range {

    private Range() {}

    /**
     * Produce a sequence [0..n)
     *
     * @param n the length of sequence
     * @return  a sequence of [0..n)
     */
    public static int[] range(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        return res;
    }

    /**
     * Produce a sequence [start..end)
     *
     * @param start the start of the sequence
     * @param end   the end of the sequence but excluded
     * @return      a sequence of [start..end)
     */
    public static int[] range(int start, int end) {
        int sz = end - start;
        int[] res = new int[sz];
        for (int i = 0; i < sz; i++) {
            res[i] = start + i;
        }
        return res;
    }

    /**
     * Produce a sequence [start..end) incrementing by step
     *
     * @param start the start of the sequence
     * @param end   the end of the sequence but excluded
     * @param step  the step of the sequence
     * @return      a sequence of [start..end) incrementing by {@code step}
     */
    public static int[] range(int start, int end, int step) {
        int sz = (end - start) / step;
        int[] res = new int[sz];
        for (int i = 0; i < sz; i++) {
            res[i] = start + (i * step);
        }
        return res;
    }

}
