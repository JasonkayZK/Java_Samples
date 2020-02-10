package top.jasonkayzk.redissession;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author zk
 */
@SpringBootApplication
public class RedisSessionApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RedisSessionApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
