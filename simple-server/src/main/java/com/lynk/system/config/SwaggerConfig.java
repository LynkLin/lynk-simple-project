package com.lynk.system.config;

import com.google.common.base.Predicates;
import com.lynk.system.security.common.SecurityConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Lynk
 * Date: 2017/9/18
 * Time: 21:21
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket sysAuthApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("system-auth-api")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/v1/system/auth/*"))
                .build();
    }

    @Bean
    public Docket systemApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("system-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lynk.system.controller"))
                .paths(Predicates.not(regex("/v1/system/auth/*")))
                .build()
                .globalOperationParameters(createGlobalOperationParameters());
    }

    private List<Parameter> createGlobalOperationParameters() {
        List<Parameter> parameters = new ArrayList<>(1);

        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(SecurityConstants.JWT_HEADER).description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        parameters.add(tokenPar.build());

        return parameters;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("lynk-sys APIs")
                .description("lynk-sys api")
                .contact(new Contact("Lynk", "https://weibo.com/lynkkk", "lynklin@gmail.com"))
                .license("Apache License Version 2.0")
                .version("1.0")
                .build();
    }
}
