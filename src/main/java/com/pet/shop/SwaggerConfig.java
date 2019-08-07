package com.pet.shop;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.pet.shop
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/8/7 5:14 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */


//加载该类配置
@Configuration
//启用Swagger2
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

}