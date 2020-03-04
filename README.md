## 手动实现一个简单的线程池

### 实例说明

本实例通过Java内部的阻塞队列和自旋操作实现一个简单的线程池;

然后通过使用这个线程池并发实现对1~100的相加

当然本例中有很多缺陷, 只是为了简要说明线程的基本原理, 从而帮助更好的理解Java线程池的源码;

### 目录结构

```bash
.
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── top
│       │       └── jasonkayzk
│       │           ├── app
│       │           │   └── SimpleThreadPoolTest.java
│       │           └── core
│       │               ├── Pool.java
│       │               └── SimpleThreadPool.java
│       └── resources
└── target
```

其中app目录下为本用例的一个使用实例

而core目录下为线程池的具体实现

### 如何使用本示例

例子基于Maven构建, 导入项目后, 直接运行app目录下的SimpleThreadPoolTest即可获取结果!

### 文章

[Java线程池ThreadPoolExecutor分析与实战](https://jasonkayzk.github.io/2020/02/06/Java线程池ThreadPoolExecutor分析与实战/)