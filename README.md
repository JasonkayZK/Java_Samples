## Spring框架IoC实现的小例子

### 示例说明

本例子**仅仅使用了Lombok和commons-lang3实现了Spring-core中的大部分IoC功能**

包括:

-   `@MyAutowired`, `@MyService`, `@MyComponent`, `@MyController`, `@MyLazy`等注解
-   创建基于AnnotationConfig的上下文容器AnnotationConfigApplicationContext
-   DefaultListableBeanFactory: Bean工厂的实现
-   BeanPostProcessor: 实现Bean的初始化前置/后置处理
-   AnnotationConfigRegistry: JavaBean的元数据BeanDefinition的注册类
-   ClassPathBeanDefinitionScanner: 根据ClassPath的包扫描器

可完成类似于:

-   读取并解析配置文件(可配置dev等)
-   扫描指定包的注解(`@Component`, `@Service`等)实现Bean和容器的初始化
-   通过context.getBean()获取指定的bean
-   通过继承BeanPostProcessor实现Bean的初始化前置/后置处理
-   通过`@MyLazy`实现懒加载
-   通过`@MyService`或`@MyController`的name属性指定Bean名称(Id)
-   解决循环依赖问题

### 目录结构

```bash
zk@zk:~/workspace/Java_Samples$ tree
.
├── pom.xml
├── README.md
├── src
│   └── main
│       ├── java
│       │   └── top
│       │       └── jasonkayzk
│       │           └── ioc
│       │               ├── app
│       │               │   ├── config
│       │               │   │   └── MyBeanPostProcessor.java
│       │               │   ├── controller
│       │               │   │   └── CustomerController.java
│       │               │   ├── IocApplication.java
│       │               │   └── service
│       │               │       ├── CustomerService.java
│       │               │       ├── LazyService.java
│       │               │       └── UserService.java
│       │               └── core
│       │                   ├── annotation
│       │                   │   ├── MyAutowired.java
│       │                   │   ├── MyComponent.java
│       │                   │   ├── MyController.java
│       │                   │   ├── MyLazy.java
│       │                   │   ├── MyRequestMapping.java
│       │                   │   └── MyService.java
│       │                   ├── context
│       │                   │   ├── AbstractApplicationContext.java
│       │                   │   └── AnnotationConfigApplicationContext.java
│       │                   ├── entity
│       │                   │   ├── BeanDefinition.java
│       │                   │   └── IocConstant.java
│       │                   ├── factory
│       │                   │   ├── BeanFactory.java
│       │                   │   └── DefaultListableBeanFactory.java
│       │                   ├── processor
│       │                   │   └── BeanPostProcessor.java
│       │                   ├── registry
│       │                   │   ├── AnnotationConfigRegistry.java
│       │                   │   └── BeanDefinitionRegistry.java
│       │                   └── scanner
│       │                       └── ClassPathBeanDefinitionScanner.java
│       └── resources
│           ├── application-dev.properties
│           ├── application-extra.properties
│           └── application.properties
└── target
```

其中app目录下为使用本用例中实现的Spring-core构建的项目;

而core目录下为Spring-core的具体实现

### 示例使用

例子基于Maven构建, 导入项目后, 直接运行app目录下的IocApplication即可获取结果!

### 项目参考

-   https://github.com/zzzzbw/doodle
-   https://gitlab.com/qingsongxi/spring-ioc

