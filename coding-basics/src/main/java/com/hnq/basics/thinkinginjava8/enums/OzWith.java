package com.hnq.basics.thinkinginjava8.enums;

/**
 * 方法添加
 *
 * @author henengqiang
 * @date 2021/1/25
 */
public enum OzWith {

    /***/
    WEST("Miss Gulch, aka the Wicked Witch of the west"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private final String description;

    OzWith(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWith value : OzWith.values()) {
            System.out.println(value + ":" + value.getDescription());
        }
    }
}
