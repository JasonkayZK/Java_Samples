package top.jasonkayzk.ioc.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 访问控制层url处理
 *
 * @author zk
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {
    /**
     * 请求访问url路径
     *
     * @return 请求访问url路径, 默认为: "/"
     */
    String value() default "/";
}
