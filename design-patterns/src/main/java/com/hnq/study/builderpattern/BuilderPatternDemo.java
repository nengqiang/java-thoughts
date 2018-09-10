package com.hnq.study.builderpattern;

import com.hnq.study.builderpattern.bean.Meal;
import com.hnq.study.builderpattern.builder.MealBuilder;

/**
 *  假设一个快餐店的商业案例，其中，一个典型的套餐可以是一个汉堡（Burger）和一杯冷饮（Cold drink）。汉堡（Burger）可以是
 * 素食汉堡（Veg Burger）或鸡肉汉堡（Chicken Burger），它们是包在纸盒中。冷饮（Cold drink）可以是可口可乐（coke）或
 * 百事可乐（pepsi），它们是装在瓶子中。
 *  我们将创建一个表示食物条目（比如汉堡和冷饮）的 Item 接口和实现 Item 接口的实体类，以及一个表示食物包装的 Packing 接口
 * 和实现 Packing 接口的实体类，汉堡是包在纸盒中，冷饮是装在瓶子中。
 *  然后我们创建一个 Meal 类，带有 Item 的 ArrayList 和一个通过结合 Item 来创建不同类型的 Meal 对象的 MealBuilder。
 * BuilderPatternDemo，我们的演示类使用 MealBuilder 来创建一个 Meal。
 *
 * BuilderPatternDemo 使用 MealBuilder 来演示建造者模式（Builder Pattern）
 *
 * @author henengqiang
 * @date 2018/9/10
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        show();
    }

    private static void show() {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg meal: ");
        vegMeal.showItems();
        System.out.println("Total cost: " + vegMeal.getCost());

        Meal awkwardMeal = mealBuilder.prepareAwkwardMeal();
        System.out.println("Awkward Meal: ");
        awkwardMeal.showItems();
        System.out.println("Total Cost: " + awkwardMeal.getCost());
    }

}
