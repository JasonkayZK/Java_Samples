package top.jasonkayzk.ioc.core.registry;

import top.jasonkayzk.ioc.core.annotation.MyComponent;

/**
 * 注解的注册器
 *
 * @author zk
 */
public interface AnnotationConfigRegistry {

    /**
     * 将一个或者多个类进行注册
     * 调用此方法{@code register}是幂等的, 即:
     * 将同一个注解过的类注册多次没有副作用!
     * <p>
     * Register one or more annotated classes to be processed.
     * Calls to {@code register} are idempotent; adding the same
     * annotated class more than once has no additional effect.
     *
     * @param annotatedClasses 一个或者多个被注解的类
     *                         如: {@link MyComponent @MyComponent} 类
     */
    void register(Class<?>... annotatedClasses);

    /**
     * 基于指定的包进行扫描注解类
     *
     * Perform a scan within the specified base packages.
     *
     * @param basePackages the packages to check for annotated classes
     */
    void scan(String... basePackages);

}
