package com.hnq.study.strategy.optimizetheexample.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这是有效价格区间注解，可以给策略添加有效区间的设置
 * @author henengqiang
 * @date 2018/8/21
 */
// 表示只能给类添加该注解
@Target(ElementType.TYPE)
// 这个必须要将注解保留在运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceRegion {

    int max() default Integer.MAX_VALUE;

    int min() default Integer.MIN_VALUE;

}
