package top.jasonkayzk.swaggerDemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * A config file for swagger
 *
 * @author zk
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.switch}")
    private boolean swaggerSwitch;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("top.jasonkayzk.swaggerDemo"))
            .paths(PathSelectors.any())
            .build()
            .securitySchemes(securitySchemes())
            .securityContexts(securityContexts());
    }

    /**
     * 项目信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Swagger demo")
            .description("A demo for swagger bind with spring boot")
            .contact(new Contact("Jasonkay", "https://jasonkayzk.github.io/", "271226192@qq.com"))
            .termsOfServiceUrl("https://jasonkayzk.github.io/")
            .version("1.0")
            .build();
    }

    /**
     * 配置认证模式
     */
    private List<ApiKey> securitySchemes() {
        return newArrayList(new ApiKey("Authorization", "Authorization", "header"));
    }

    /**
     * 配置认证上下文
     */
    private List<SecurityContext> securityContexts() {
        return newArrayList(SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.any())
            .build());
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(new SecurityReference("Authorization", authorizationScopes));
    }

}
