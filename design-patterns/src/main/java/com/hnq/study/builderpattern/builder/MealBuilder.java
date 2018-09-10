package com.hnq.study.builderpattern.builder;

import com.hnq.study.builderpattern.bean.*;

/**
 * @author henengqiang
 * @date 2018/9/10
 */
public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareAwkwardMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
