package top.jasonkayzk.ioc.core.context;

import top.jasonkayzk.ioc.core.registry.AnnotationConfigRegistry;
import top.jasonkayzk.ioc.core.scanner.ClassPathBeanDefinitionScanner;

/**
 * 通过Annotation配置的上下文容器
 *
 * @author zk
 */
public class AnnotationConfigApplicationContext extends AbstractApplicationContext implements AnnotationConfigRegistry {

    /**
     * 创建一个扫描器
     */
    private final ClassPathBeanDefinitionScanner scanner;

    public AnnotationConfigApplicationContext() {
        this.scanner = new ClassPathBeanDefinitionScanner(this);
    }

    public AnnotationConfigApplicationContext(String... basePackages) {
        // 容器初始化
        this();

        // 加载: 扫描指定包路径下的所有的类
        // 将所有的带有指定标记的类扫描到一个集合中，集合中保存的是类的元数据信息
        scan(basePackages);

        // 注入Bean
        refresh();
    }

    @Override
    public void register(Class<?>... annotatedClasses) {
    }

    @Override
    public void scan(String... basePackages) {
        this.scanner.scan(basePackages);
    }
}
