package top.jasonkayzk.ioc.core.processor;

/**
 * Bean的后置处理器
 *
 * @author zk
 */
public interface BeanPostProcessor {

    /**
     * Bean的初始化前置处理
     * @param bean JavaBean
     * @param beanName bean名称
     * @return 初始化前对bean进行处理
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * Bean的初始化的后置处理
     * @param bean JavaBean
     * @param beanName bean名称
     * @return 初始化后对bean进行处理
     */
    public Object postProcessAfterInitialization(Object bean, String beanName);

}
