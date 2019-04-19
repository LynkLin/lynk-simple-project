package com.lynk.system.tool;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lynk on 2019/4/19
 */
public class BeanCopierManager {
    private static final String COMBINE = "-";
    private static final String NULL = "NULL";

    private static BeanCopierManager beanCopierManager;

    private static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

    public static BeanCopierManager getInstance() {
        if (beanCopierManager == null) {
            beanCopierManager = new BeanCopierManager();
        }
        return beanCopierManager;
    }

    private BeanCopierManager() {
    }

    public void init() {
        beanCopierMap = new HashMap<>(16);
    }

    public void copy(Object source, Object target) {
        copy(source, target, null);
    }

    public void copy(Object source, Object target, Converter converter) {
        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass(), converter);
        beanCopier.copy(source, target, converter);
        System.out.println("5555");
    }

    private BeanCopier getBeanCopier(Class sourceClass, Class targetClass, Converter converter) {
        String key = genKey(sourceClass, targetClass, converter);
        if (beanCopierMap.containsKey(key)) {
            return beanCopierMap.get(key);
        } else {
            BeanCopier beanCopier = BeanCopier.create(sourceClass, targetClass, converter != null);
            beanCopierMap.put(key, beanCopier);
            return beanCopier;
        }
    }

    private String genKey(Class sourceClass, Class targetClass, Converter converter) {
        String converterClassName = converter == null? NULL: converter.getClass().getName();
        return sourceClass.getName() + COMBINE + targetClass.getName() + COMBINE + converterClassName;
    }
}
