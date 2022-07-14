package com.mashang.xiaomi.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 类 名: SwaggerConfig
 * 描 述:
 * 作 者: binglong180
 * 创 建: 2020-07-08 12:22
 * 邮 箱: binglong172@163.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // 定义分隔符
    private static final String splitor = ";";
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost:8080")
                .pathMapping("/")
                .select()
              /*  .apis(RequestHandlerSelectors.basePackage("com.cn.binglong.controller"))*/
                .apis(basePackage("com.mashang.xiaomi.controller"
                        + splitor +
                        "com.cn.binglong.controller2"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("小米商店")
                        .description("小米商店")
                        .version("9.0")
                        .contact(new Contact("binglong180","www.binglong180.com","binglong172@163.com"))
                        .license("Swagger文档")
                        .licenseUrl("https://swagger.io/docs/specification/2-0/basic-structure/")
                        .build());
    }


    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
