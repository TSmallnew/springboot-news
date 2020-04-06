package com.puboot.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO
 *
 * @author pc
 * @date 2020/4/5
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            //生成api文档扫描路径
            .apis(RequestHandlerSelectors.basePackage("cn.wbnull.springbootdemo.controller"))
            .paths(PathSelectors.any())
            .build();
}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("SpringBootDemo Api")
                //作者
                .contact(new Contact("dukunbiao(null)", "http://121.40.176.67:8080/cms/login", ""))
                //版本号
                .version("1.0")
                //描述
                .description("Base Java 1.8")
                .build();
    }
}
