package top.jasonkayzk.ioc.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Spring中业务层注解
 *
 * @author zk
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponent
public @interface MyService {
    /**
     * 业务Bean名称
     *
     * @return 业务Bean名称
     */
    String name() default "";
}
