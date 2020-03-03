## Java中String相关例子

### 项目说明

本分支展示了在Java编程中的一些坑, 项目目录如下:

```
zk@zk:~/workspace/Java_Samples$ tree .
.
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── string
│       │       ├── examples
│       │       │   └── StringDemo.java
│       │       ├── intern
│       │       │   └── InternDemo.java
│       │       └── memoryStructure
│       │           └── StringCompare.java
│       └── resources
└── target
```

本项目通过Maven构建, 共有几个章节对String在编程时的一些坑进行展示

目录结构:

-   examples: 展示String在编程时的一些坑
-   intern: 通过str.intern()方法创建一个String
-   memoryStructure: 一个例子展示String在JVM中存储的内存结构

### 相关文章

-   [为什么在Java中String被设计为不可变](https://jasonkayzk.github.io/2019/10/01/为什么在Java中String被设计为不可变/)
    -   String源码简单分析
    -   String在JVM中的常量池的解析: 字面量, new, +连接, intern()
    -   String中的==和equals
    -   什么是Java中的不可变? 不可变的好处与坏处?
    -   证明回答String被设计成不可变和不能被继承的原因
    -   ......

