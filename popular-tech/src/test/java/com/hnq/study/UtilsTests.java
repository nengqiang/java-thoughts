package com.hnq.study;

import com.hnq.study.utils.BeanUtil;

/**
 * @author henengqiang
 * @date 2018/11/2
 */
public class UtilsTests {

    public static void main(String[] args) {
        new UtilsTests().beanUtilTest1();
    }

    private void beanUtilTest1() {
        Person person1 = new Person("alice", 28);
        Person person2 = new Person();
        System.out.println("Person1: " + person1);
        System.out.println("Person2: " + person2);
        BeanUtil.copyProperties(person1, person2);
        System.out.println("Person2 after copy: " + person2);
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
