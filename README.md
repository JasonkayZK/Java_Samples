## Java小栗子

### 项目介绍

Java_Samples是一个通过Java代码实现Java例子的仓库, 包括: RPC, Reflection, Lambda, Annotation, Proxy等;

### 项目使用

① 通过在下面表格中找到想要学习的Java相关的内容;

② 获取分支代码;

```bash
git clone git@github.com:JasonkayZK/Java_Samples.git -b 相应分支名称
```

③ 搭配相关文章学习相关内容;

>   **注意:**
>
>   本项目通过Maven构建, **并基于JDK 11开发**
>
>   **使用时请将pom.xml中`<build>`标签下换为你本地的版本, 如:**
>
>   ```xml
>   <build>
>        ......
>       <plugins>
>           <plugin>
>               <groupId>org.apache.maven.plugins</groupId>
>               <artifactId>maven-compiler-plugin</artifactId>
>               <version>3.8.0</version>
>               <configuration>
>                   <source>8</source> <!-- 修改 -->
>                   <target>8</target> <!-- 修改 -->
>                   <encoding>UTF-8</encoding>
>               </configuration>
>           </plugin>
>       </plugins>
>    </build>
>    ```

### 已完成内容

|           Demo           | Url                                                          | Last Modified |                           Comment                            |
| :----------------------: | ------------------------------------------------------------ | :-----------: | :----------------------------------------------------------: |
|        Spring-Ioc        | https://github.com/JasonkayZK/Java_Samples/tree/spring-ioc   |  2020-03-02   | 文章: [实现一个简单的SpringIOC容器](https://jasonkayzk.github.io/2020/03/02/实现一个简单的SpringIOC容器/) |
|    Java-Introspector     | https://github.com/JasonkayZK/Java_Samples/tree/java-introspector |  2020-03-02   | 文章: [Java的内省技术](https://jasonkayzk.github.io/2020/03/02/Java的内省技术/) |
|         Java-SSO         | https://github.com/JasonkayZK/Java_Samples/tree/java-sso     |  2020-02-12   |                        **UNFINISHED**                        |
|      Redis-Session       | https://github.com/JasonkayZK/Java_Samples/tree/redis-session |  2020-02-10   | 通过Spring-Session-Data-redis实现<br />文章: [Redis实现分布式Session](https://jasonkayzk.github.io/2020/02/10/Redis实现分布式Session/) |
|  Redis-distribute-lock   | https://github.com/JasonkayZK/Java_Samples/tree/redis-distribute-lock |  2020-02-09   | 文章: [Redis面试相关问题](https://jasonkayzk.github.io/2020/02/05/Redis面试相关问题/) |
|      Redis-Pub/Sub       | https://github.com/JasonkayZK/Java_Samples/tree/redis-pub/sub |  2020-02-09   | 文章: [Redis面试相关问题](https://jasonkayzk.github.io/2020/02/05/Redis面试相关问题/) |
|    Mybatis-Generator     | https://github.com/JasonkayZK/Java_Samples/tree/mybatis-generator |  2020-01-15   | 文章: [mybatis-generator逆向工程总结](https://jasonkayzk.github.io/2020/01/15/mybatis-generator逆向工程总结/) |
| Swagger with Spring Boot | https://github.com/JasonkayZK/Java_Samples/tree/swagger      |  2020-01-02   | 文章: [SpringBoot集成Swagger](https://jasonkayzk.github.io/2020/01/02/SpringBoot集成Swagger/) |
|          String          | https://github.com/JasonkayZK/Java_Samples/tree/java-string  |  2019-10-02   | 文章: [为什么在Java中String被设计为不可变](https://jasonkayzk.github.io/2019/10/01/为什么在Java中String被设计为不可变/) |
|           NIO            | https://github.com/JasonkayZK/Java_Samples/tree/java-nio     |  2019-09-25   | 包括: IO(OIO)/NIO等<br />文章: [Java中的IO流](https://jasonkayzk.github.io/2019/11/25/Java中的IO流/)<br />[NIO相关基础篇之JDK](https://jasonkayzk.github.io/2019/09/25/NIO相关基础篇之JDK/)<br />[NIO相关基础篇之操作系统I-O模型](https://jasonkayzk.github.io/2019/09/26/NIO相关基础篇之操作系统I-O模型/)<br />[NIO相关基础篇之实战](https://jasonkayzk.github.io/2019/09/26/NIO相关基础篇之实战/) |
|          Proxy           | https://github.com/JasonkayZK/Java_Samples/tree/java-proxy   |  2019-09-18   | 包括: 静态/动态(JDK/CGLib)<br />文章: [Java中的代理模式-静态代理与动态代理](https://jasonkayzk.github.io/2019/09/18/Java中的代理模式-静态代理与动态代理/) |
|        Annotation        | https://github.com/JasonkayZK/Java_Samples/tree/java-annotation |  2019-09-18   | 文章: [Java Annotation总结](https://jasonkayzk.github.io/2019/09/17/Java-Annotation总结/) |
|          Lambda          | https://github.com/JasonkayZK/Java_Samples/tree/java-lambda  |  2019-09-16   | 文章: [Lambda表达式总结](https://jasonkayzk.github.io/2019/09/16/Lambda表达式总结/) |
|        Reflection        | https://github.com/JasonkayZK/Java_Samples/tree/java-reflection |  2019-09-14   | 文章: [Java反射基础总结](https://jasonkayzk.github.io/2019/09/14/Java反射基础总结/) |
|           RPC            | https://github.com/JasonkayZK/Java_Samples/tree/java-rpc     |  2019-09-14   | 文章: [Java实现的一个原生RPC例子](https://jasonkayzk.github.io/2019/09/13/Java实现的一个原生RPC例子/) |

### 更新计划

目前正在添加关于Spring框架实现相关例子, 敬请期待…

### 其他

本项目所有内容均是本人学习Java过程中的总结, 分享出去希望能帮助大家更好学习Java

欢迎大家在issue区提出意见, 觉得本项目不错的可以给个star~
