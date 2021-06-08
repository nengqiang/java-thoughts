package com.hnq.basics.thinkinginjava8.enums;

import static com.hnq.basics.thinkinginjava8.enums.Burrito2.SpicinessEnum.*;

/**
 * @author henengqiang
 * @date 2021/1/25
 */
public class Burrito2 {

    SpicinessEnum degree;

    public Burrito2(SpicinessEnum degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito2(NOT));
        System.out.println(new Burrito2(MEDIUM));
        System.out.println(new Burrito2(HOT));
    }

    public static enum SpicinessEnum {

        /***/
        NOT, MILD, MEDIUM, HOT, FLAMING

    }

}
