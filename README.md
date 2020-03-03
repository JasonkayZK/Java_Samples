## Java中的代理模式-静态代理与动态代理示例



### 项目说明

```
zk@zk:~/workspace/Java_Samples$ tree .
.
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── proxy
│       │       ├── cglib
│       │       │   ├── CGLibProxyTest.java
│       │       │   ├── interceptor
│       │       │   │   └── MyInterceptor.java
│       │       │   └── service
│       │       │       └── impl
│       │       │           └── CGLibServiceImpl.java
│       │       ├── dynamicProxy
│       │       │   ├── DynamicProxyTest2.java
│       │       │   ├── DynamicProxyTest3.java
│       │       │   ├── DynamicProxyTest.java
│       │       │   ├── handler
│       │       │   │   └── WineHandler.java
│       │       │   └── service
│       │       │       ├── CigarService.java
│       │       │       ├── impl
│       │       │       │   ├── CigarServiceImpl.java
│       │       │       │   ├── WineServiceImpl2.java
│       │       │       │   └── WineServiceImpl.java
│       │       │       └── WineService.java
│       │       ├── jdk
│       │       │   ├── handler
│       │       │   │   └── MyInvocationHandler.java
│       │       │   ├── JavaProxyTest.java
│       │       │   └── service
│       │       │       ├── impl
│       │       │       │   └── MyServiceImpl.java
│       │       │       └── MyService.java
│       │       └── staticProxy
│       │           ├── proxy
│       │           │   └── MovieProxy.java
│       │           ├── service
│       │           │   ├── impl
│       │           │   │   └── MovieServiceImpl.java
│       │           │   └── MovieService.java
│       │           └── StaticProxyTest.java
│       └── resources
└── target
```

本项目通过Maven构建, 共有几个章节对反射进行学习;

目录结构:

-   staticProxy: 静态代理示例
-   dynamicProxy: 动态代理示例
-   jdk: 一个原生jdk实现的动态代理
-   cglib: 通过cglib实现的动态代理

### 其他

学习Proxy的文章: [Java中的代理模式-静态代理与动态代理](https://jasonkayzk.github.io/2019/09/18/Java中的代理模式-静态代理与动态代理/)