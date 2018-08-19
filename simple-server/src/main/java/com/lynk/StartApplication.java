package com.lynk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Lynk
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.lynk.system.dao", "com.lynk.business.dao"})
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}