package com.hnq.study.optimizetheexample.factory;

import com.hnq.study.optimizetheexample.bean.Player;
import com.hnq.study.optimizetheexample.service.ICalPrice;
import com.hnq.study.optimizetheexample.service.PriceRegion;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @author henengqiang
 * @date 2018/8/21
 */
public class CalPriceFactory {

    /**
     * 表示扫描策略的包
     */
    private static final String CAL_PRICE_PACKAGE = "com.hnq.study.optimizetheexample.service.impl";

    private ClassLoader classLoader = getClass().getClassLoader();

    /**
     * 策略列表
     */
    private List<Class<? extends ICalPrice>> calPriceList;

    /**
     * 根据玩家的总金额产生相应的策略
     * @param player    玩家对象
     * @return          不同的策略
     */
    public ICalPrice createCalPrice(Player player) {
        // 在策略列表查找策略
        for (Class<? extends ICalPrice> clazz : calPriceList) {
            // 获取该策略的注解
            PriceRegion validRegion = handleAnnotation(clazz);
            // 判断金额是否在注解的区间
            if (validRegion != null
                    && player.getTotalAmount() >= validRegion.min()
                    && player.getTotalAmount() < validRegion.max()) {
                try {
                    // 是的话返回一个当前策略的实例
                    return clazz.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("策略获取失败");
                }
            }
        }
        throw new RuntimeException("策略获取失败");
    }

    /**
     * 获取注解
     * @param clazz 传入一个策略类
     * @return      返回其注解
     */
    private PriceRegion handleAnnotation(Class<? extends ICalPrice> clazz) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (Annotation annotation : annotations) {
            if (annotation instanceof PriceRegion) {
                return (PriceRegion)annotation;
            }
        }
        return null;
    }

    /**
     * 单例
     */
    private CalPriceFactory() {
        init();
    }

    /**
     * 在工厂初始化时要初始化策略列表
     */
    @SuppressWarnings("unchecked")
    private void init() {
        calPriceList = new ArrayList<Class<? extends ICalPrice>>();
        // 获取到包下的所有class文件
        File[] resources = getResources();
        Class<ICalPrice> calPriceClazz;
        try {
            // 使用相同的加载器加载策略接口
            calPriceClazz = (Class<ICalPrice>)classLoader.loadClass(ICalPrice.class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("未找到策略接口");
        }
        for (File resource : resources) {
            try {
                // 载入包下的类
                Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE + "." +
                        resource.getName().replace(".class", ""));
                // 判断是否是 ICalPrice 的实现类并且不是 ICalPrice 它本身，满足的话加入到策略列表
                if (ICalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz) {
                    calPriceList.add((Class<? extends ICalPrice>)clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 扫描获取包下面的所有class文件
     * @return {@link File}
     */
    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    // 只扫描 .class 文件
                    return pathname.getName().endsWith(".class");
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

    public static CalPriceFactory getInstance() {
        return CalPriceFactoryInstance.instance;
    }

    private static class CalPriceFactoryInstance {
        private static CalPriceFactory instance = new CalPriceFactory();
    }

}
