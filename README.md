## Java反射基础

### 项目说明
```
.
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── reflection
│       │       ├── chapter3
│       │       │   └── getClass
│       │       │       └── GetClassDemo.java
│       │       ├── chapter4
│       │       │   └── constructObject
│       │       │       ├── DefaultConstructor.java
│       │       │       └── SelectConstructor.java
│       │       ├── chapter5
│       │       │   └── param
│       │       │       └── GetAndModifyParamDemo.java
│       │       ├── chapter6
│       │       │   └── method
│       │       │       └── InvokeMethodDemo.java
│       │       ├── chapter7
│       │       │   └── main
│       │       │       └── InvokeMainDemo.java
│       │       ├── chapter8
│       │       │   └── settings
│       │       │       ├── CommonDemo.java
│       │       │       ├── ReflectSettingsDemo.java
│       │       │       └── service
│       │       │           ├── Service1.java
│       │       │           └── Service2.java
│       │       ├── chapter9
│       │       │   └── genericType
│       │       │       └── AviodGenericTypeCheckDemo.java
│       │       └── pojo
│       │           └── Hero.java
│       └── resources
│           └── reflection.properties
└── target
```

本项目通过Maven构建, 共有几个章节对反射进行学习;

目录结构:

-   pojo: 一个Hero的POJO类
-   chapter3: 获取一个类的Class对象演示
-   chapter4: 通过Class对象获取某个类中的: 构造方法, 成员变量, 成员方法;
-   chapter5: 通过反射获取类的的属性字段
-   chapter6: 通过反射执行类的方法
-   chapter7: 通过反射执行类中main方法
-   chapter8: 通过反射动态执行业务方法, 实现业务层解耦
-   chapter9: 通过反射越过泛型检查

### 其他

更多与Java反射相关: [Java反射基础总结](https://jasonkayzk.github.io/2019/09/14/Java反射基础总结/)