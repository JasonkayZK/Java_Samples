## Lambda表达式总结

### 项目说明

```
zk@zk:~/workspace/Java_Samples$ tree .
.
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── lambda
│       │       ├── lesson0
│       │       │   └── functional
│       │       │       ├── FunctionalDemo.java
│       │       │       └── FunctionalService.java
│       │       ├── lesson2
│       │       │   └── helloLambda
│       │       │       ├── examples
│       │       │       │   └── HeroCompareDemo.java
│       │       │       ├── findMethod
│       │       │       │   ├── interfaceMethod
│       │       │       │   │   └── InterfaceFind.java
│       │       │       │   ├── lambda
│       │       │       │   │   └── LambdaFind.java
│       │       │       │   └── normal
│       │       │       │       └── NormalFind.java
│       │       │       └── generateLambda
│       │       │           └── GenerateLambdaDemo.java
│       │       ├── lesson3
│       │       │   └── methodReferece
│       │       │       ├── collection
│       │       │       │   └── LambdaInCollection.java
│       │       │       ├── constructor
│       │       │       │   └── ConstructorLambdaDemo.java
│       │       │       ├── examples
│       │       │       │   ├── ConstructorDemo.java
│       │       │       │   └── HeroCompareDemo.java
│       │       │       ├── memberMethod
│       │       │       │   └── MemberMethodDemo.java
│       │       │       └── staticMethod
│       │       │           └── StaticMethodDemo.java
│       │       ├── lesson4
│       │       │   └── polymerization
│       │       │       ├── end
│       │       │       │   └── EndingOptDemo.java
│       │       │       ├── examples
│       │       │       │   └── FindThirdHero.java
│       │       │       ├── middle
│       │       │       │   └── MiddleOptDemo.java
│       │       │       ├── source
│       │       │       │   └── ArrayToPipeSource.java
│       │       │       └── TraverseDemo.java
│       │       ├── lesson5
│       │       │   └── examples
│       │       │       ├── example1
│       │       │       │   └── RunnableDemo.java
│       │       │       ├── example10
│       │       │       │   └── MaxMinAveSumDemo.java
│       │       │       ├── example2
│       │       │       │   └── ListenerDemo.java
│       │       │       ├── example3
│       │       │       │   └── TraverseDemo.java
│       │       │       ├── example4
│       │       │       │   └── PredicateDemo.java
│       │       │       ├── example5
│       │       │       │   └── MultiPredicate.java
│       │       │       ├── example6
│       │       │       │   ├── LambdaMap.java
│       │       │       │   └── MapReduceDemo.java
│       │       │       ├── example7
│       │       │       │   └── FilterDemo.java
│       │       │       ├── example8
│       │       │       │   └── InvokeMethodDemo.java
│       │       │       └── example9
│       │       │           └── DistinctDemo.java
│       │       ├── pojo
│       │       │   └── Hero.java
│       │       └── service
│       │           └── HeroChecker.java
│       └── resources
└── target
```

本项目通过Maven构建, 共有几个章节对Lambda表达式进行学习;

目录结构:

-   pojo: 一个Hero的POJO类
-   lesson0: 一个`@FunctionalInterface`函数式接口例子
-   lesson2: Lambda表达式的演变过程
-   lesson3: Lambda表达式的方法引用
-   lesson4: Lambda表达式对集合进行聚合操作
-   lesson5: 十个经典的Lambda表达式例子
    -   用Lambda实现Runnable
    -   使用Java 8 lambda表达式进行事件处理
    -   使用lambda表达式对列表进行迭代
    -   使用lambda表达式和函数式接口Predicate
    -   在lambda表达式中加入Predicate
    -   Java 8中使用lambda表达式的Map和Reduce示例
    -   通过过滤创建一个String列表
    -   对列表的每个元素应用函数
    -   复制不同的值，创建一个子列表
    -   计算集合元素的最大值、最小值、总和以及平均值

### 其他

学习Lambda表达式文章:

-   [Lambda表达式总结](https://jasonkayzk.github.io/2019/09/16/Lambda表达式总结/)
