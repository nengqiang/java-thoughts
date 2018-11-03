package com.hnq.study.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author henengqiang
 * @date 2018/11/1
 */
public class BeanUtil {

    private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>();

    /**
     * 基于 CGLIB 的 bean properties 的拷贝，性能要远优于{@code org.springframework.beans.BeanUtils.copyProperties}
     *
     * @param source    包含数据的原始对象
     * @param target    被塞入数据的目标对象
     */
    public static void copyProperties(Object source, Object target) {
        if (Objects.isNull(source) || Objects.isNull(target)) {
            return;
        }
        String key = String.format("%s:%s", source.getClass().getName(), target.getClass().getName());
        if (!BEAN_COPIER_MAP.containsKey(key)) {
            BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
            BEAN_COPIER_MAP.putIfAbsent(key, beanCopier);
        }
        BeanCopier beanCopier = BEAN_COPIER_MAP.get(key);
        beanCopier.copy(source, target, null);
    }

}
