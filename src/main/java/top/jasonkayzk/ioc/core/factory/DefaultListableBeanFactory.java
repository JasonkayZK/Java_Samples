package top.jasonkayzk.ioc.core.factory;

import top.jasonkayzk.ioc.core.annotation.MyAutowired;
import top.jasonkayzk.ioc.core.entity.BeanDefinition;
import top.jasonkayzk.ioc.core.processor.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static top.jasonkayzk.ioc.core.scanner.ClassPathBeanDefinitionScanner.toLowercaseIndex;

/**
 * Spring中默认的Bean的工厂类
 *
 * @author zk
 */
public class DefaultListableBeanFactory implements BeanFactory {

    /**
     * 一级缓存
     * 用于存放完全初始化好的Bean，从该缓存中拿出来的Bean可以直接使用
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    /**
     * 二级缓存:
     * 存储的原始的Bean(还未完全填充属性),
     * 用于解决Spring中的循环依赖问题，此时已经分配了内存地址
     * <p>
     * Cache of early singleton objects: bean name --> bean instance
     */
    private final Map<String, Object> earlySingletonObjects = new HashMap<>(16);

    /**
     * 三级缓存:
     * 单例对象工厂的cache，存放bean工厂对象，用于解决循环依赖
     * Cache of singleton factories: bean name --> ObjectFactory
     */
    private final Map<String, Object> singletonFactories = new HashMap<>(16);

    /**
     * 保存所有BeanPostProcessor
     */
    private Set<BeanPostProcessor> beanPostProcessorSet = new HashSet<>(16);

    /**
     * Bean的源数据集合，存储的是扫描器扫描的类的源数据信息
     */
    public final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(128);

    /**
     * 配置文件
     */
    private Properties properties = null;

    /**
     * 动态向候选资源集合中添加候选数据
     *
     * @param beanName       bean名称
     * @param beanDefinition bean元数据实例
     */
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 注册配置文件
     *
     * @param properties 配置文件
     */
    public void registerProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName);
    }

    @Override
    public Object doGetBean(String beanName) {
        // 一级缓存寻找, 存在则直接返回
        if (singletonObjects.containsKey(beanName)) {
            return this.singletonObjects.get(beanName);
        }
        // 一级缓存不存在, 创建
        return this.createBean(beanName);
    }

    @Override
    public Object createBean(String beanName) {
        return doCreateBean(beanName);
    }

    @Override
    public Object doCreateBean(String beanName) {
        synchronized (DefaultListableBeanFactory.class) {
            // 先判断当前对象是否正在被创建
            // 因为这是一个synchronized方法, 如果存在当前对象则说明出现了循环依赖
            // A -> B -> A
            // 包括两个判断: 二级缓存(原始的Bean[还未完全填充属性])的创建和三级缓存Bean的工厂类的缓存
            if (earlySingletonObjects.containsKey(beanName) || singletonFactories.containsKey(beanName)) {
                throw new RuntimeException("IOC容器中存在循环依赖异常 beanName=" + beanName);
            }

            // 添加到三级缓存中，标记当前Bean正准备创建
            singletonFactories.put(beanName, "");
            // Bean的定义元数据
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (Objects.isNull(beanDefinition)) {
                // 无Bean的定义则直接返回
                return null;
            }

            // 获取Bean
            Object beanObj = null;
            try {
                // 通过beanDefinition获取对应类的Class, 并通过反射生成对象
                // 此方法在JDK 9过时:
                // beanObj = beanDefinition.getBeanClass().newInstance();
                // 推荐使用clazz.getDeclaredConstructor().newInstance()创建
                beanObj = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();

                // 如果Bean实现了后置处理器, 添加到beanPostProcessorSet中(进行后置处理)
                if (beanObj instanceof BeanPostProcessor) {
                    beanPostProcessorSet.add((BeanPostProcessor) beanObj);
                }

                // 添加到二级缓存中，标记当前Bean正在被创建，只是还没有完全填充属性
                earlySingletonObjects.put(beanName, beanObj);
                // 由于是单例, 直接删除了这个Bean的工厂类实例(因为已经创建了Bean)
                singletonFactories.remove(beanName);

                // 进行属性填充
                // 属性填充后，有可能对象被反射之类的或者是产生了代理对象!
                populateBean(beanObj);

                // 进行Bean的后置处理器处理
                initializeBeanPostProcessor(beanName, beanObj);

                // 属性填充完毕后，保存当前对象到一级缓存中，表示当前Bean可以直接拿出来使用
                singletonObjects.put(beanName, beanObj);
                earlySingletonObjects.remove(beanName);
            } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return beanObj;
        }
    }

    /**
     * 实例化所有单例非懒加载的bean
     * (在context中进行)
     */
    public void preInstantiateSingletons() {
        // 获取所有的候选资源Bean的名称
        Set<String> beanNames = beanDefinitionMap.keySet();
        beanNames.forEach(beanName -> {
            BeanDefinition bd = beanDefinitionMap.get(beanName);
            // 如果不是抽象的，并且是单例的，并且不是懒加载的Bean
            // 抽象类不能被实例化，只能被继承
            if (!Objects.isNull(bd) && !bd.isAbstractFlag() && !bd.isLazyInit()) {
                getBean(beanName);
            }
        });
    }

    /**
     * 完成Bean的后置处理器工作
     *
     * @param beanName bean名称
     * @param beanObj  操作的bean对象
     */
    private void initializeBeanPostProcessor(String beanName, Object beanObj) {
        // 遍历beanPostProcessorSet
        // 完成所有(Init前)Bean的后置处理器工作
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorSet) {
            beanObj = beanPostProcessor.postProcessBeforeInitialization(beanObj, beanName);
        }

        // 执行Bean的init方法
        System.out.println("假设正在执行" + beanName + "的init方法.....");

        // 遍历beanPostProcessorSet
        // 完成所有(Init后)Bean的后置处理器工作
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorSet) {
            beanObj = beanPostProcessor.postProcessAfterInitialization(beanObj, beanName);
        }
    }

    /**
     * 对当前Bean进行依赖注入
     *
     * @param beanObj 此处返回当前Bean，后期如果有更改，可能返回是一个代理类
     */
    private void populateBean(Object beanObj) throws IllegalAccessException {
        // 反射获取Bean的所有属性
        Field[] fields = beanObj.getClass().getDeclaredFields();

        // 遍历属性并进行依赖注入
        for (Field field : fields) {
            // 将access改为true(防止private属性)
            field.setAccessible(true);

            // 判断当前属性是否需要进行依赖注入
            // 有无@MyAutowired注解
            if (field.isAnnotationPresent(MyAutowired.class)) {
                // 类名首字母转小写字符串
                String simpleName = toLowercaseIndex(field.getType().getSimpleName());

                // 先判断当前属性类型名称小写是否在候选资源中
                Set<String> beanDefinitionNames = beanDefinitionMap.keySet();
                // 如果候选资源中不存在
                if (!beanDefinitionNames.contains(simpleName)) {
                    // 通过全名寻找Bean实例
                    simpleName = toLowercaseIndex(field.getName());
                    if (!beanDefinitionNames.contains(simpleName)) {
                        // 注入的属性的类型名称小写和属性名称都不在候选资源中
                        throw new RuntimeException("当前类" + beanObj + "找不到属性类型" + field.getType() + "的Bean");
                    }
                }

                // 否则候选资源中存在
                // 一级缓存查找: 判断依赖的Bean是否已经被创建好可以直接被使用了
                if (singletonObjects.containsKey(simpleName)) {
                    field.set(beanObj, singletonObjects.get(simpleName));
                    // 查看二级缓存中是否存在
                } else if (earlySingletonObjects.containsKey(simpleName)) {
                    field.set(beanObj, earlySingletonObjects.get(simpleName));
                } else {
                    // 上面通过全名寻找的Bean实例(一级缓存)
                    field.set(beanObj, getBean(simpleName));
                }
            }
        }
    }
}
