package com.hnq.study.builderpattern.bean;

import com.hnq.study.builderpattern.service.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/10
 */
public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0F;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("Item: " + item.name());
            System.out.println("Packing: " + item.packing().pack());
            System.out.println("Price: " + item.price());
        }
    }

}
