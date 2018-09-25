package com.hnq.study.compositepattern;

import com.hnq.study.compositepattern.bean.Employee;

/**
 * 有一个类 Employee，该类被当作组合模型类。CompositePatternDemo，演示类使用 Employee 类来添加部门层次结构，并打印所有员工。
 *
 * 1、组合模式，就是在一个对象中包含其他对象，这些被包含的对象可能是终点对象（不再包含别的对象），也有可能是非终点对象（其内部还包含
 * 其他对象，或叫组对象），我们将对象称为节点，即一个根节点包含许多子节点，这些子节点有的不再包含子节点，而有的仍然包含子节点，以此类推。
 * 2、所谓组合模式，其实说的是对象包含对象的问题，通过组合的方式（在对象内部引用对象）来进行布局，我认为这种组合是区别于继承的，而另一层
 * 含义是指树形结构子节点的抽象（将叶子节点与数枝节点抽象为子节点），区别于普通的分别定义叶子节点与数枝节点的方式。
 *
 * @author henengqiang
 * @date 2018/9/25
 */
public class CompositePatternDemo {

    public static void main(String[] args) {
        Employee employee = addEmployee();
        printEmployee(employee);
    }

    private static Employee addEmployee() {
        Employee CEO = new Employee("John", "CEO", 30000D);
        Employee headSales = new Employee("Robert", "Head Sales", 20000D);
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000D);

        Employee clerk1 = new Employee("Laura", "Marketing", 10000D);
        Employee clerk2 = new Employee("Bob", "Marketing", 10000D);

        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000D);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000D);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);
        return CEO;
    }

    private static void printEmployee(Employee employee) {
        System.out.println(employee);
        for (Employee headEmployee : employee.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee singleEmployee : headEmployee.getSubordinates()) {
                System.out.println(singleEmployee);
            }
        }
    }

}
