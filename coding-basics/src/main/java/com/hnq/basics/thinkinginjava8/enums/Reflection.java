package com.hnq.basics.thinkinginjava8.enums;

import com.hnq.basics.thinkinginjava8.onjava.OSExecute;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author henengqiang
 * @date 2021/1/25
 */
public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("____Analyzing " + enumClass + " ____");
        System.out.println("Interfaces:");
        Arrays.stream(enumClass.getGenericInterfaces()).forEach(System.out::println);
        System.out.println("Base:" + enumClass.getSuperclass());
        System.out.println("Methods:");
        Set<String> methods = new TreeSet<>();
        Arrays.stream(enumClass.getMethods()).forEach(m -> methods.add(m.getName()));
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum):");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
        OSExecute.command("javap -cp target/classes/com/hnq/basics/thinkinginjava8/enums/main Reflection.Explore");
    }

    public static enum Explore {/***/ HERE, THERE}
}
