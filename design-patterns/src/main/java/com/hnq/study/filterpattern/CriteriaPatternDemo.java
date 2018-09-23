package com.hnq.study.filterpattern;

import com.hnq.study.filterpattern.bean.Person;
import com.hnq.study.filterpattern.service.ICriteria;
import com.hnq.study.filterpattern.service.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 *  创建一个 Person 对象、Criteria 接口和实现了该接口的实体类，来过滤 Person 对象的列表。CriteriaPatternDemo，
 * 我们的演示类使用 Criteria 对象，基于各种标准和它们的结合来过滤 Person 对象的列表。
 *
 * @author henengqiang
 * @date 2018/9/21
 */
public class CriteriaPatternDemo {

    public static void main(String[] args) {
        filterPerson();
    }

    private static void filterPerson() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Robert", "Male", "Single"));
        personList.add(new Person("John", "male", "Married"));
        personList.add(new Person("Laura", "Female", "married"));
        personList.add(new Person("Diana", "Female", "Single"));
        personList.add(new Person("Mike", "Male", "Single"));
        personList.add(new Person("Bobby", "Male", "Single"));

        ICriteria male = new CriteriaMaleImpl();
        ICriteria female = new CriteriaFemaleImpl();
        ICriteria single = new CriteriaSingleImpl();
        ICriteria singleMale = new AndCriteriaImpl(single, male);
        ICriteria singleOrFemale = new OrCriteriaImpl(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(personList));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(personList));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(personList));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(personList));
    }

    private static void printPersons(List<Person> personList) {
        for (Person person : personList) {
            System.out.println(person);
        }
    }

}
