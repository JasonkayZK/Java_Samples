## Java中一些IO相关的例子



### 项目说明

本分支展示了关于JavaIO相关的一些操作, 用于学习IO, NIO等

项目目录如下:

```
zk@zk:~/workspace/Java_Samples$ tree .
.
├── pom.xml
├── src
│   ├── fileIODemo.txt
│   ├── fromFile.txt
│   ├── fromFile.xml
│   ├── generate.py
│   ├── main
│   │   ├── java
│   │   │   └── nio
│   │   │       ├── basic
│   │   │       │   ├── buffer
│   │   │       │   │   └── model
│   │   │       │   │       └── BufferModelDemo.java
│   │   │       │   ├── channel
│   │   │       │   │   └── fileChannel
│   │   │       │   │       └── FileChannelDemo.java
│   │   │       │   ├── charset
│   │   │       │   │   └── ShowCharSetDemo.java
│   │   │       │   ├── filelock
│   │   │       │   │   └── FileLockDemo.java
│   │   │       │   └── nio
│   │   │       │       ├── Client.java
│   │   │       │       └── Server.java
│   │   │       ├── fileChannel
│   │   │       │   ├── FileReadCompareTest.java
│   │   │       │   ├── NioFileDemo.java
│   │   │       │   └── OioFileDemo.java
│   │   │       ├── mappedByteBuffer
│   │   │       │   ├── ByteBufferDemo.java
│   │   │       │   ├── FileReadCompareTest.java
│   │   │       │   └── MappedByteBufferDemo.java
│   │   │       ├── other
│   │   │       │   ├── datagranChannel
│   │   │       │   │   └── DatagramChannelDemo.java
│   │   │       │   ├── pipe
│   │   │       │   │   └── PipeDemo.java
│   │   │       │   ├── scatterAndGatter
│   │   │       │   │   └── ScatterAndGatherDemo.java
│   │   │       │   └── transferFromAndTo
│   │   │       │       └── TransferFromAndToDemo.java
│   │   │       └── socketChannel
│   │   │           ├── NioClient.java
│   │   │           ├── NioServer.java
│   │   │           └── OioServer.java
│   │   └── resources
│   ├── scatterAndGather.txt
│   ├── testFileChannel.txt
│   ├── toFile.txt
│   └── toFile.xml
└── target
```

目录结构说明:

-   basic: 展示JavaIO/NIO的一些常见用法
-   fileChannel: 通过OIO(Old Input & Output)和NIO操作文件例子
-   mappedByteBuffer: 展示Java中Buffer的使用
-   socketChannel: 通过OIO和NIO建立Socket连接
-   other: 
    -   pipe: 展示数据管道使用
    -   datagramChannel: 展示数据报channel使用
    -   scatterAndGatter: Scatter&Gatter的使用
    -   transferFromAndTo: 展示流中transferTo/From方法使用

### 相关文章

-   IO(OIO)基础学习
    -   [Java中的IO流](https://jasonkayzk.github.io/2019/11/25/Java中的IO流/)
-   NIO学习
    -   [NIO相关基础篇之JDK](https://jasonkayzk.github.io/2019/09/25/NIO相关基础篇之JDK/)
    -   [NIO相关基础篇之操作系统I-O模型](https://jasonkayzk.github.io/2019/09/26/NIO相关基础篇之操作系统I-O模型/)
    -   [NIO相关基础篇之实战](https://jasonkayzk.github.io/2019/09/26/NIO相关基础篇之实战/)

