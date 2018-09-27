package com.hnq.study.commandpattern.bean;

/**
 * @author henengqiang
 * @date 2018/9/27
 */
public class Stock {

    private String name = "alice";

    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + " Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + " Quantity: " + quantity + " ] sold");
    }

}
