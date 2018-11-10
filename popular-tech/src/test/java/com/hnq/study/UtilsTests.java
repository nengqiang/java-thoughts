package com.hnq.study;

import com.hnq.study.bean.ObjectFields;
import com.hnq.study.utils.BeanUtil;
import com.hnq.study.utils.ReflectUtil;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/11/2
 */
public class UtilsTests {

    public static void main(String[] args) {
        new UtilsTests().reflectUtilTest1();
    }

    private void beanUtilTest1() {
        Person person1 = new Person("alice", 28);
        Person person2 = new Person();
        System.out.println("Person1: " + person1);
        System.out.println("Person2: " + person2);
        BeanUtil.copyProperties(person1, person2);
        System.out.println("Person2 after copy: " + person2);
    }

    private void reflectUtilTest1() {
        Person person = new Person("alice", 25);
        try {
            List<ObjectFields> objectFieldsList = ReflectUtil.reflectToGetFields(person);
            objectFieldsList.forEach(System.out::println);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    class Person {
        private String name;
        private Integer age;

        public Person() {}

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}
