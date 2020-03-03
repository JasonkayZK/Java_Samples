## Java Annotation总结

### 项目说明

```
zk@zk:~/workspace/Java_Samples$ tree .
.
├── java_samples.iml
├── pom.xml
├── README.md
├── src
│   └── main
│       ├── java
│       │   └── annotation
│       │       ├── chapter1
│       │       │   └── grammer
│       │       │       ├── lesson1
│       │       │       │   └── define
│       │       │       │       └── DefineAnnotation.java
│       │       │       └── lesson2
│       │       │           └── apply
│       │       │               └── ApplyClassDemo.java
│       │       ├── chapter2
│       │       │   └── metaAnnotation
│       │       │       ├── inherited
│       │       │       │   └── InheritedDemo.java
│       │       │       ├── repeatable
│       │       │       │   └── Persons.java
│       │       │       ├── retention
│       │       │       │   └── RetentionDemo.java
│       │       │       └── target
│       │       │           ├── TargetClassDemo.java
│       │       │           └── TargetDemo.java
│       │       ├── chapter3
│       │       │   └── attribute
│       │       │       ├── defaultValue
│       │       │       │   └── DefaultValueDemo.java
│       │       │       ├── giveValue
│       │       │       │   └── GiveAttributeValue.java
│       │       │       ├── setupAttr
│       │       │       │   └── AttributeDemo.java
│       │       │       └── singleAttr
│       │       │           └── SingleAttrDemo.java
│       │       ├── chapter4
│       │       │   └── javaDefalut
│       │       │       ├── deprecated
│       │       │       │   └── DeprecatedDemo.java
│       │       │       ├── functionalInterface
│       │       │       │   └── FunctionalDemo.java
│       │       │       ├── override
│       │       │       │   └── OverrideDemo.java
│       │       │       ├── safeVarargs
│       │       │       │   └── SafeVarargsDemo.java
│       │       │       └── suppresswarnings
│       │       │           └── SuppressWarningsDemo.java
│       │       ├── chapter5
│       │       │   └── getAnnotation
│       │       │       ├── getClassAnnotation
│       │       │       │   └── GetClassAnnotaionDemo.java
│       │       │       └── getOtherAnnotation
│       │       │           └── GetOtherAnnotationDemo.java
│       │       └── chapter7
│       │           └── test
│       │               ├── dbutilExample
│       │               │   ├── anno
│       │               │   │   ├── DBUtil.java
│       │               │   │   └── JDBCConfig.java
│       │               │   └── noAnno
│       │               │       └── DBUtil.java
│       │               └── testExample
│       │                   ├── MyTest.java
│       │                   ├── NoBug.java
│       │                   └── TestTool.java
│       └── resources
└── target
```

本项目通过Maven构建, 共有几个章节对反射进行学习;

目录结构:

-   chapter1: 注解语法
-   chapter2: 元注解: 
    -   @Retention
    -   @Documented
    -   @Target
    -   @Inherited
    -   @Repeatable
-   chapter3: 注解的属性
-   chapter4: Java预置注解
-   chapter5: 注解的提取
-   chapter7: 使用注解的实例
    -   使用注解进行测试
    -   把数据库连接的工具类DBUtil改造成为注解的方式

### 其他

学习Annotation的文章: 

-   [Java Annotation总结](https://jasonkayzk.github.io/2019/09/17/Java-Annotation%E6%80%BB%E7%BB%93/)