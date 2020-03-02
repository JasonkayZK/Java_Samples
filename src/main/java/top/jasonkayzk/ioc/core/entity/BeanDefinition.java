package top.jasonkayzk.ioc.core.entity;

import lombok.Data;

/**
 * JavaBean元数据定义，记录候选Bean的行为信息
 *
 * @author zk
 */
@Data
public class BeanDefinition {

    /**
     * Bean的name(同时也是Id)
     */
    private String beanName;

    /**
     * Bean的字节码对象
     */
    public Class<?> beanClass;

    /**
     * Bean的全限制名
     */
    public String beanReferenceName;

    /**
     * 是否是抽象的
     */
    private boolean abstractFlag = false;

    /**
     * 是否是懒加载的
     */
    private boolean lazyInit = false;

    /**
     * Bean的作用域: 设置默认单例
     */
    private String scope = "singleton";

    public BeanDefinition(String beanName, Class<?> beanClass, String beanReferenceName) {
        this.beanName = beanName;
        this.beanClass = beanClass;
        this.beanReferenceName = beanReferenceName;
    }

    public BeanDefinition(String beanName, Class<?> beanClass, String beanReferenceName, boolean abstractFlag) {
        this.beanName = beanName;
        this.beanClass = beanClass;
        this.beanReferenceName = beanReferenceName;
        this.abstractFlag = abstractFlag;
    }

    public BeanDefinition(String beanName, Class<?> beanClass, String beanReferenceName, boolean lazyInit,  boolean abstractFlag) {
        this.beanName = beanName;
        this.beanClass = beanClass;
        this.beanReferenceName = beanReferenceName;
        this.lazyInit = lazyInit;
        this.abstractFlag = abstractFlag;
    }
}
