package com.saj.adv.api.config;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
        		.directModelSubstitute(LocalDate.class, Date.class)
        		.select()
        		.apis(RequestHandlerSelectors.basePackage("com.saj.adv.api.controller"))
        		.paths(PathSelectors.any())
        		.build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Microserviço SAJ ADV")
                .description("Microserviço responsável por gerenciar processos judiciais")
                .version("1.0")
                .build();
    }
    
}