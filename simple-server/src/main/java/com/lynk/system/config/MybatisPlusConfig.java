package com.lynk.system.config;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lynk
 * Date: 2017/8/5
 * Time: 22:20
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
        return paginationInterceptor;
    }

//    @Bean
//    public GlobalConfiguration globalConfiguration() {
//        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
//        conf.setLogicDeleteValue("0");
//        conf.setLogicNotDeleteValue("1");
//        conf.setIdType(IdType.ID_WORKER.getKey());
//        conf.setDbColumnUnderline(true);
//        conf.setRefresh(true);
//        conf.setMetaObjectHandler(new TimeMetaObjectHandler());
//        return conf;
//    }
}
