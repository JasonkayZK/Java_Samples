package top.jasonkayzk.ioc.app.config;

import top.jasonkayzk.ioc.core.annotation.MyComponent;
import top.jasonkayzk.ioc.core.processor.BeanPostProcessor;

/**
 * 测试后置处理器
 *
 * @author zk
 */
@MyComponent
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("正在处理" + beanName + "的初始化前的操作");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("正在处理" + beanName + "的初始化后的操作");
        return bean;
    }

}
