package com.lynk.system.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Lynk
 * @since 2018/01/02
 */
@Component
public class SysRedisHandle implements BaseRedisHandle<String, Object> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Object get(String key) {
        return redisTemplate.boundValueOps(key).get();
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.boundValueOps(key).set(value);
    }

    @Override
    public void set(String key, Object value, long timeout, TimeUnit timeUnit) {
        redisTemplate.boundValueOps(key).set(value, timeout, timeUnit);
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public void remove(String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }
}
