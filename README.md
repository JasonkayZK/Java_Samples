## Mybatis-Generator使用案例

Mybatis-Generator官方仓库: https://github.com/mybatis/generator

-   JDK 11.0.5
-   MySQL: 8.0.18
-   Mybatis-Generator: 1.3.6

<br/>

本项目基于MySQL数据库作为演示, 演示使用逆向工程产生test数据库中的表

>使用:
>
>1.  创建数据库, 并运行resources/schema.sql创建数据库表
>2.  修改配置 generatorConfig.xml
>3.  运行GeneratorSqlMap即可生成代码

**使用注意事项:**

在生成新的代码之前, 需要删除原来的旧代码, 否则代码生成做的是在已有的文件内添加内容(append)