package top.jasonkayzk.ioc.core.registry;

import top.jasonkayzk.ioc.core.entity.BeanDefinition;

import java.util.Properties;
import java.util.Set;

/**
 * bean的注册器
 *
 * @author zk
 */
public interface BeanDefinitionRegistry {

    /**
     * 往注册表中注册一个新的BeanDefinition实例[关键]
     *
     * @param beanName       bean的名称
     * @param beanDefinition bean对应的元数据类BeanDefinition的实例
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 从注册中取得指定的BeanDefinition实例
     *
     * @param beanName bean的名称
     * @return BeanDefinition bean对应的元数据类BeanDefinition的实例
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 判断BeanDefinition实例是否在注册表中(是否已经注册)
     *
     * @param beanName bean的名称
     * @return 是否已经注册
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 取得注册表中所有BeanDefinition实例的beanName(标识)
     *
     * @return 注册表中所有BeanDefinition实例的beanName的Set
     */
    Set<String> getBeanDefinitionNames();

    /**
     * 注册配置文件
     *
     * @param properties 配置文件
     */
    void registerProperties(Properties properties);
}
