package com.hnq.study.function;

/**
 * @author henengqiang
 * @date 2020/09/14
 */
public class LazyLambda {

    private static final String MSG1 = "Hello ";
    private static final String MSG2 = "world ";
    private static final String MSG3 = "Java !";

    public static void main(String[] args) {
        l1();
        l2();
    }

    private static void log(int level, String msg) {
        if (level == 1) {
            System.out.println(msg);
        }
    }

    private static void l1() {
        log(1, MSG1 + MSG2 + MSG3);
        log(2, MSG1 + MSG2 + MSG3);
    }

    private static void log(int level, MessageBuilder builder) {
        if (level == 1) {
            System.out.println(builder.buildMessage());
        }
    }

    private static void l2() {
        log(1, () -> {
            System.out.println("lambda 是否执行了");
            return MSG1 + MSG2 + MSG3;
        });

        log(2, () -> {
            System.out.println("lambda 是否执行了");
            return MSG1 + MSG2 + MSG3;
        });
    }

}
