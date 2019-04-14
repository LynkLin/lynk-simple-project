package com.lynk.system.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Lynk
 */
@Component
public class TimeMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        LocalDateTime currentTime = LocalDateTime.now();
        setFieldValByName("gmtCreate", currentTime, metaObject);
        setFieldValByName("gmtModified", currentTime, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime currentTime = LocalDateTime.now();
        setFieldValByName("gmtModified", currentTime, metaObject);
    }
}
