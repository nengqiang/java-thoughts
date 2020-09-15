package com.hnq.study;

import com.hnq.study.function.MyFunctionInterface;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author henengqiang
 * @date 2020/09/14
 */
public class FunctionTests {

    @Test
    void testMyFunctionInterface() {
        doSomething(() -> System.out.println("execute lambda!"));
    }

    void doSomething(MyFunctionInterface functionInterface) {
        functionInterface.func();
    }


    @Test
    void testSupplier() {
        System.out.println(supplierTester(() -> "产生数据"));
        System.out.println((Supplier<String>) () -> "数据产生");
    }

    String supplierTester(Supplier<String> supplier) {
        // 供应者接口
        return supplier.get();
    }

    @Test
    void testUseSupplierGetMaxValue() {
        Integer[] data = {1, 3, 5, 7, 89};
        int res = getMaxValue(() -> Arrays.stream(data).max(Comparator.comparingInt(a -> a)).get());
        System.out.println("Max=" + res);
    }

    int getMaxValue(Supplier<Integer> supplier) {
        return supplier.get();
    }


    @Test
    void testConsumer() {
        String input = "DATA";
        consumeX(System.out::println, input);
    }

    void consumeX(Consumer<String> consumer, String input) {
        consumer.accept(input);
    }

    @Test
    void testPrintWithConsumer() {
        String[] input = new String[] {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        formatPersonMsg(
                c1 -> Arrays.stream(input).forEach(p -> System.out.println(Arrays.toString(p.split(",")))),
                c2 -> Arrays.stream(input).forEach(System.out::println),
                input);
        printInfo(
                c1 -> Arrays.stream(input).forEach(p -> System.out.println(Arrays.toString(p.split(",")))),
                c2 -> Arrays.stream(input).forEach(System.out::println),
                input);
    }

    void formatPersonMsg(Consumer<String[]> c1, Consumer<String[]> c2, String[] input) {
        c1.andThen(c2).accept(input);
    }

    void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        Arrays.stream(array).forEach(s -> one.andThen(two).accept(s));
    }


    @Test
    void testPredicate() {
        // 判断字符串是否存在O  既是生产者 又是消费者接口
        methodTest(s -> s.contains("O"));
        // 判断字符串是否同时存在O H
        methodAnd(s -> s.contains("O"), s -> s.contains("H"));
        // 判断字符串是否一方存在O H
        methodOr(s -> s.contains("O"), s -> s.contains("H"));
        // 判断字符串不存在O
        methodNegative(s -> s.contains("O"));
        // 使用静态方法判断是否为同一个对象
        methodIsEqual(s -> s.contains("O"));
    }

    void methodTest(Predicate<String> predicate) {
        System.out.println(predicate.test("OOM SOF"));
    }

    void methodAnd(Predicate<String> p1, Predicate<String> p2) {
        System.out.println(p1.and(p2).test("OOM SOF"));
    }

    void methodOr(Predicate<String> p1, Predicate<String> p2) {
        System.out.println(p1.or(p2).test("OOM SOF"));
    }

    void methodNegative(Predicate<String> predicate) {
        System.out.println(predicate.negate().test("OOM SOF"));
    }

    void methodIsEqual(Predicate<String> predicate) {
        System.out.println(Predicate.isEqual(predicate).test(predicate));
    }

    @Test
    void testFilterWithPredicate() {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        getFemaleAndName(
                s -> s.split(",")[0].length() == 4,
                s -> s.split(",")[1].equals("女"), array);
    }

    void getFemaleAndName(Predicate<String> one, Predicate<String> two, String[] arr) {
        Arrays.stream(arr).forEach(s -> {
            if (one.and(two).test(s)) {
                System.out.println(s);
            }
        });
    }


    @Test
    void testFunction() {
        int n = 2;
        String res = integerToString(String::valueOf, n);
        System.out.println("转换结果：" + res);

        Integer result = methodAndThen(k -> ++k, k -> k * 2, n);
        System.out.println("MethodAndThen:" + result);
        result = methodCompose(k -> ++k, k -> k * 2, n);
        System.out.println("MethodCompose:" + result);
    }

    String integerToString(Function<Integer, String> function, Integer num) {
        return function.apply(num);
    }

    Integer methodAndThen(Function<Integer, Integer> f1, Function<Integer, Integer> f2, Integer n) {
        return f1.andThen(f2).apply(n);
    }

    Integer methodCompose(Function<Integer, Integer> f1, Function<Integer, Integer> f2, Integer n) {
        return f1.compose(f2).apply(n);
    }

}
