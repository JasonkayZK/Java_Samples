package top.jasonkayzk.ioc.core.scanner;

import org.apache.commons.lang3.StringUtils;
import top.jasonkayzk.ioc.app.controller.CustomerController;
import top.jasonkayzk.ioc.core.annotation.MyComponent;
import top.jasonkayzk.ioc.core.annotation.MyController;
import top.jasonkayzk.ioc.core.annotation.MyLazy;
import top.jasonkayzk.ioc.core.annotation.MyRequestMapping;
import top.jasonkayzk.ioc.core.annotation.MyService;
import top.jasonkayzk.ioc.core.entity.BeanDefinition;
import top.jasonkayzk.ioc.core.entity.IocConstant;
import top.jasonkayzk.ioc.core.registry.BeanDefinitionRegistry;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

/**
 * 类扫描器
 *
 * @author zk
 */
public class ClassPathBeanDefinitionScanner {

    /**
     * Bean注册表
     */
    private final BeanDefinitionRegistry registry;

    /**
     * 扫描包下所有的类的字节码对象(候选资源和非候选资源)
     */
    private final static Set<String> BASE_PACKAGE_CLASS_NAME = new HashSet<>();

    /**
     * 存储所有的候选资源的名称
     */
    private final static Set<String> BEAN_DEFINITION_NAMES = new HashSet<>();

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * 开始进行包扫描
     *
     * @param basePackages 包的路径
     */
    public void scan(String[] basePackages) {
        doScan(basePackages);
    }

    /**
     * 获取所有的候选资源元数据信息
     *
     * @param basePackages 包的路径
     */
    private void doScan(String[] basePackages) {
        Set<BeanDefinition> candidates = new HashSet<>();

        // 扫描并注册配置文件
        Properties properties = findAllConfigurationFile();
        registry.registerProperties(properties);

        // 扫描所有的候选资源列表
        findCandidateComponents(basePackages, candidates);

        // 将扫描出来的候选资源信息添加到注册表中
        candidates.forEach(beanDefinition -> registry.registerBeanDefinition(beanDefinition.getBeanName(), beanDefinition));
    }

    /**
     * 获取所有的候选资源源数据信息
     *
     * @param basePackages 需要扫描的包的候选资源信息
     */
    private void findCandidateComponents(String[] basePackages, Set<BeanDefinition> candidates) {
        // 加载所有class
        for (String basePackage : basePackages) {
            loadClass(basePackage);
        }

        // 获取到需要扫描的包路径下所有的类后
        // 开始挑选出需要所有的候选资源信息: BeanDefinition
        BASE_PACKAGE_CLASS_NAME.forEach(packageClassName -> {
            try {
                Class<?> packageClass = Class.forName(packageClassName);

                // 判断是否是候选资源(携带指定注解: @MyComponent, @MyService)
                Class<?> annos = getAnnos(packageClass);
                if (!Objects.isNull(annos)) {
                    String beanName;
                    // 被@MyComponent标注, 并且@MyComponent的name(id)不为空
                    // 按照@MyComponent的name来注册beanName;
                    if (annos.getTypeName().equals(MyComponent.class.getTypeName()) && StringUtils.isNotEmpty(packageClass.getAnnotation(MyComponent.class).name())) {
                        beanName = packageClass.getAnnotation(MyComponent.class).name();
                        // 被@MyService标注, 并且@MyService的name(id)不为空
                        // 按照@MyService的name来注册beanName;
                    } else if (annos.getTypeName().equals(MyService.class.getTypeName()) && StringUtils.isNotEmpty(packageClass.getAnnotation(MyService.class).name())) {
                        beanName = packageClass.getAnnotation(MyService.class).name();
                    } else {
                        // 否则name为空, 按照类名首字母变成小写创建Bean
                        // (此处注意: 由于是单例, 这样做一定不会重复!!!)
                        beanName = toLowercaseIndex(packageClass.getSimpleName());
                    }

                    // 如果BEAN_DEFINITION_NAMES集合中存在了beanName
                    // 说明beanName声明重复!
                    if (BEAN_DEFINITION_NAMES.contains(beanName)) {
                        throw new RuntimeException("beanName已经存在：" + beanName);
                    }

                    // 判断当前类是否是抽象的
                    boolean isAbstract = false;
                    if (Modifier.isAbstract(packageClass.getModifiers())) {
                        isAbstract = true;
                    }

                    // 判断是否是懒加载的
                    if (packageClass.isAnnotationPresent(MyLazy.class)) {
                        candidates.add(new BeanDefinition(beanName, packageClass, packageClassName, true, isAbstract));
                    } else {
                        candidates.add(new BeanDefinition(beanName, packageClass, packageClassName, isAbstract));
                    }

                    // 加入Bean
                    BEAN_DEFINITION_NAMES.add(beanName);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 类名首字母转小写
     *
     * @param name 类名
     * @return 类名首字母转小写后的字符串
     */
    public static String toLowercaseIndex(String name) {
        if (StringUtils.isNotEmpty(name)) {
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        return name;
    }

    /**
     * 扫描配置文件
     * <p>
     * 从这里可以看出优先级:
     * <p>
     * include >> active >> 默认
     */
    private Properties findAllConfigurationFile() {
        Properties properties = new Properties();
        InputStream is = null, is1 = null;
        try {
            // 寻找: "application.properties"文件
            is = this.getClass().getClassLoader().getResourceAsStream("application.properties");
            if (!Objects.isNull(is)) {
                InputStreamReader inputStreamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                properties.load(inputStreamReader);
            }
            // 如果properties中存在IocConstant.ACTIVE("spring.profiles.active")
            // 需要扫描application-${spring.profiles.active}.properties配置
            if (properties.containsKey(IocConstant.ACTIVE) && !Objects.isNull(properties.get(IocConstant.ACTIVE))) {
                is1 = this.getClass().getClassLoader().getResourceAsStream("application-" + properties.get(IocConstant.ACTIVE) + ".properties");
                if (!Objects.isNull(is1)) {
                    InputStreamReader inputStreamReader = new InputStreamReader(is1, StandardCharsets.UTF_8);
                    properties.load(inputStreamReader);
                }
            }
            // 如果properties中存在IocConstant.INCLUDE("spring.profiles.include")
            // 需要扫描application-${spring.profiles.include}.properties配置
            if (properties.containsKey(IocConstant.INCLUDE) && !Objects.isNull(properties.get(IocConstant.INCLUDE))) {
                is1 = this.getClass().getClassLoader().getResourceAsStream("application-" + properties.get(IocConstant.INCLUDE) + ".properties");
                if (!Objects.isNull(is1)) {
                    InputStreamReader inputStreamReader = new InputStreamReader(is1, StandardCharsets.UTF_8);
                    properties.load(inputStreamReader);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is1 != null) {
                try {
                    is1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    /**
     * 加载所有的候选资源信息
     *
     * @param basePackage 需要扫描的包的候选资源信息
     */
    private void loadClass(String basePackage) {
        URL url = this.getClass().getClassLoader().getResource(basePackage.replaceAll("\\.", "/"));
        File file = new File(Objects.requireNonNull(url).getFile());
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fileSon : Objects.requireNonNull(files)) {
                if (fileSon.isDirectory()) {
                    // 递归扫描
                    loadClass(basePackage + "/" + fileSon.getName());
                } else {
                    // 是文件并且是以 .class结尾
                    if (fileSon.getName().endsWith(".class")) {
                        String beanReferenceName = basePackage.replace("/", ".") + "." + fileSon.getName().replaceAll(".class", "");
                        System.out.println("正在读取class文件： " + beanReferenceName);
                        BASE_PACKAGE_CLASS_NAME.add(beanReferenceName);
                    }
                }
            }
        } else {
            throw new RuntimeException("没有找到需要扫描的文件目录");
        }
    }

    /**
     * 判断当前类是否包含组合注解: @MyComponent
     * 注意: interface java.lang.annotation.Documented等存在循环，会导致内存溢出，所以需要排除java的源注解
     *
     * @param clazz 类对象
     */
    private static Class<?> getAnnos(Class<?> clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() != Deprecated.class &&
                    annotation.annotationType() != SuppressWarnings.class &&
                    annotation.annotationType() != Override.class &&
                    annotation.annotationType() != Target.class &&
                    annotation.annotationType() != Retention.class &&
                    annotation.annotationType() != Documented.class &&
                    annotation.annotationType() != Inherited.class &&
                    annotation.annotationType() != MyRequestMapping.class
            ) {
                if (annotation.annotationType() == MyComponent.class) {
                    return clazz;
                } else {
                    return getAnnos(annotation.annotationType());
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Class<CustomerController> customerControllerClass = CustomerController.class;
        Class<?> annos = getAnnos(customerControllerClass);
        System.out.println(Objects.requireNonNull(annos).getSimpleName().equals(MyController.class.getSimpleName()));
        System.out.println(annos.getName());
        System.out.println(Arrays.toString(annos.getTypeParameters()));
        System.out.println(annos.getTypeName());
    }
}
