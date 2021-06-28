package com.hnq.basics.thinkinginjava8.enums;

import java.util.stream.Stream;

/**
 * 覆盖enum的方法
 *
 * @author henengqiang
 * @date 2021/1/25
 */
public enum SpaceShip {
    /***/
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;


    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        Stream.of(values()).forEach(System.out::println);
    }
}
