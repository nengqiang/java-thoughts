package com.hnq.study.singleton;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.hnq.study.singleton.bean.SingleObject;

import java.util.concurrent.*;

/**
 * 从 singleton 类获取唯一的对象
 *
 * @author henengqiang
 * @date 2018/9/6
 */
public class SingletonPatternDemo {

    /** 创建线程池 */
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        // 获取唯一可用对象
        SingleObject object = SingleObject.getInstance();

        // 显示消息
        object.showMessage("00");

        singleThreadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            object.showMessage("01");
        });

        singleThreadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            object.showMessage("02");
        });

        singleThreadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            object.showMessage("03");
        });

        singleThreadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            object.showMessage("04");
        });

        singleThreadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            object.showMessage("05");
        });

        singleThreadPool.shutdown();
    }




}
