package top.jasonkayzk.ioc.core.factory;

/**
 * Spring中工厂模式创建Bean的工厂接口
 *
 * @author zk
 */
public interface BeanFactory {

    /**
     * 根据Bean的名称获取Bean对象
     *
     * @param beanName Bean的名称
     * @return Bean对象
     */
    Object getBean(String beanName);

    /**
     * 真正开始获取Bean
     *
     * @param beanName Bean的名称
     * @return Bean对象
     */
    Object doGetBean(String beanName);

    /**
     * 根据bean的名称创建Bean
     *
     * @param beanName Bean的名称
     * @return Bean对象
     */
    Object createBean(String beanName);

    /**
     * 根据bean的名称真正开始创建bean
     *
     * @param beanName Bean的名称
     * @return Bean对象
     */
    Object doCreateBean(String beanName);

}
