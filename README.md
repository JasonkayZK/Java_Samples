## Spring Boot集成Swagger案例项目

本项目基于Spring Boot 2.x, 项目的依赖版本如下所示:

-   JDK 11.0.4
-   Spring boot: 2.1.1.RELEASE
-   Spring Data JPA & Test
-   Swagger: 2.9.2
-   Swagger-UI: 2.9.2
-   Database: H2
-   Lombok: 1.18.10

<br/>

项目基于内置的H2数据库作为演示, 演示构建User实体类的文档

> 运行:
>
> 1. 启动`SwaggerDemoApplication`类;
> 2. 打开[http://localhost:8848/swagger-ui.html](http://localhost:8801/swagger-;ui.html)，即见接口页面;
>
> 测试:
>
> 1.  启动test目录下的SwaggerDemoApplicationTests进行测试;

<br/>

### 文档界面展示

![swaggerDemo1.png](https://raw.githubusercontent.com/JasonkayZK/blog_static/master/images/swaggerDemo1.png)

![swaggerDemo2.png](https://raw.githubusercontent.com/JasonkayZK/blog_static/master/images/swaggerDemo2.png)

![swaggerDemo3.png](https://raw.githubusercontent.com/JasonkayZK/blog_static/master/images/swaggerDemo3.png)