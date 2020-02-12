package top.jasonkayzk.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author zk
 */
@MapperScan(basePackages = {"top.jasonkayzk.sso.mapper"})
@SpringBootApplication
public class SsoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SsoApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .build(args)
                .run();
    }

}
