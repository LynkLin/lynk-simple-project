package com.lynk.system.cache;

import java.util.concurrent.TimeUnit;

/**
 * Redis缓存操作基类
 * @author Lynk
 * @since 2018/01/02
 */
public interface BaseRedisHandle<K, V> {
    /**
     * 取值
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 设置值
     * @param key
     * @param value
     */
    void set(K key, V value);

    /**
     * 设置值
     * @param key
     * @param value
     * @param timeout 失效时间
     * @param timeUnit 时间单位
     */
    void set(K key, V value, long timeout, TimeUnit timeUnit);

    /**
     * 是否存在
     * @param key
     * @return
     */
    boolean exists(K key);

    /**
     * 删除缓存
     * @param key
     */
    void remove(K key);
}
