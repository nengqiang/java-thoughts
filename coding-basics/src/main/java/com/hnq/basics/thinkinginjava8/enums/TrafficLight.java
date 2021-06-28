package com.hnq.basics.thinkinginjava8.enums;

import java.util.stream.IntStream;

/**
 * switch中的enum
 *
 * @author henengqiang
 * @date 2021/1/25
 */
public class TrafficLight {

    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        IntStream.range(0, 7).forEach(x -> {
            System.out.println(t);
            t.change();
        });
    }

    public static enum Signal {/***/ GREEN, YELLOW, RED}

}
