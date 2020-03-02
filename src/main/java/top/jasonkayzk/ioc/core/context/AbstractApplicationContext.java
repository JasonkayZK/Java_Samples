package top.jasonkayzk.ioc.core.context;

import top.jasonkayzk.ioc.core.entity.BeanDefinition;
import top.jasonkayzk.ioc.core.factory.DefaultListableBeanFactory;
import top.jasonkayzk.ioc.core.registry.BeanDefinitionRegistry;

import java.util.Properties;
import java.util.Set;

/**
 * ApplicationContext, Spring容器的顶层抽象类
 *
 * @author zk
 */
public abstract class AbstractApplicationContext implements BeanDefinitionRegistry {

    /**
     * Bean工厂，用户Bean的创建和管理
     */
    public final DefaultListableBeanFactory beanFactory;

    /**
     * 创建一个新的AbstractApplicationContext
     */
    public AbstractApplicationContext() {
        // 调用父类的构造函数
        // 为ApplicationContext Spring上下文对象初始化BeanFactory
        this.beanFactory = new DefaultListableBeanFactory();
    }

    /**
     * 往注册表中注册一个新的 BeanDefinition实例[关键]
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanName, beanDefinition);
    }

    /**
     * 根据Bean的名称获取Bean的定义
     *
     * @param beanName Bean的名称
     * @return Bean的定义
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return this.beanFactory.beanDefinitionMap.get(beanName);
    }

    /**
     * 判断是否包含某个Bean
     *
     * @param beanName Bean的名称
     * @return 是否包含某个Bean
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return this.beanFactory.beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 获取所有Bean的id
     *
     * @return 所有Bean的id(name)的Set集合
     */
    @Override
    public Set<String> getBeanDefinitionNames() {
        return this.beanFactory.beanDefinitionMap.keySet();
    }

    /**
     * 注册配置文件
     *
     * @param properties 配置文件
     */
    @Override
    public void registerProperties(Properties properties) {
        this.beanFactory.registerProperties(properties);
    }

    /**
     * 从容器中获取Bean
     *
     * @param beanName Bean名称
     * @return Bean名称对应的Bean
     */
    public Object getBean(String beanName) {
        return this.beanFactory.getBean(beanName);
    }

    /**
     * 注入Bean
     */
    public void refresh() {
        // 获取bean工厂
        DefaultListableBeanFactory beanFactory = obtainFreshBeanFactory();
        // 工厂信息初始化完成后，开始创建单例非懒加载的bean
        finishBeanFactoryInitialization(beanFactory);
    }

    /**
     * 获取Bean工厂类
     *
     * @return Bean工厂类
     */
    private DefaultListableBeanFactory obtainFreshBeanFactory() {
        return this.beanFactory;
    }

    /**
     * 开始进行Bean的注入工作
     *
     * @param beanFactory bean工厂的实例
     */
    private void finishBeanFactoryInitialization(DefaultListableBeanFactory beanFactory) {
        beanFactory.preInstantiateSingletons();
    }

}