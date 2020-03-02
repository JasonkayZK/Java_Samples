package top.jasonkayzk.ioc.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实现Bean的扫描
 *
 * 类加载时会添加到候选资源中，后期完成Bean的注入
 *
 * @author zk
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyComponent {

    /**
     * 组件名称
     *
     * @return 组件名称
     */
    String name() default "";

}
