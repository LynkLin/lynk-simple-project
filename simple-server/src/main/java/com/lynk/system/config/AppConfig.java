package com.lynk.system.config;

import com.lynk.system.tool.AppManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lynk
 * Date: 2017/8/19
 * Time: 14:32
 */
@Configuration
public class AppConfig {
    @Bean
    public AppManager appManager() {
        return new AppManager();
    }
}
