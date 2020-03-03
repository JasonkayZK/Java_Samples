## 基于Java实现的一个RPC的例子

### 项目说明

```
.
└── main
    ├── java
    │   └── rpc
    │       ├── api
    │       │   ├── bean
    │       │   │   ├── NetModel.java
    │       │   │   └── Person.java
    │       │   └── util
    │       │       └── SerializeUtils.java
    │       ├── client
    │       │   ├── proxy
    │       │   │   └── ProxyFactory.java
    │       │   └── RpcClient.java
    │       └── server
    │           ├── RpcServer.java
    │           └── service
    │               ├── HelloService.java
    │               └── impl
    │                   └── HelloServiceImpl.java
    └── resources
        └── config.properties

```

本项目为一个RPC Maven项目, 共有三个模块: 

-   API模块: 公共类
-   Server模块: 服务端
-   Client模块: 客户端

### 调用测试

先开启Server端, 输出:

```
Service on!
```

再开启客户端, 向服务端发送请求, 客户端收到回复:

```
say: Say hello to zhangsan
Person: Person{name='zhangsan', age=22}
```

服务端收到Socket请求:

```
Service on!
/127.0.0.1-connected!
/127.0.0.1-connected!
```

### 其他

更多与RPC实现相关: [Java实现的一个原生RPC例子](https://jasonkayzk.github.io/2019/09/13/Java%E5%AE%9E%E7%8E%B0%E7%9A%84%E4%B8%80%E4%B8%AA%E5%8E%9F%E7%94%9FRPC%E4%BE%8B%E5%AD%90/)
