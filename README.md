# Spring+AOP+Redis+MySQL练习

请开发一个简单的应用，练习Spring+AOP/MySQL/Redis完成如下功能：

- 将`src/main/resources/db/migration`中的数据导入本地的MySQL数据库`jdbc:mysql://localhost:3306/mall?characterEncoding=utf-8`中。
- 通过编写SQL查询该MySQL数据库的内容，获取商品排行榜，即商品按照其销售金额倒序的表格，如下所示。
- 该排行榜页面使用Redis进行缓存，缓存时间1s——即，在同一秒中，无论有多少次页面访问请求，都只查数据库一次，其他数据都从Redis缓存获取。


## 开发

### 数据库
1. docker 起 MySQL 数据库 => `docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql:8`
2. IDEA 连接 docker MySQL 数据库
3. 创建数据库 => ` create database mall ` + ` use mall `
4. 导入数据 => ` mvn flyway:migrate `
5. 测试是否导入成功 => ` select * from user ` + ` select * from goods ` + ` select * from order `

### 启动 Spring 并展示界面
1. 创建 ApplicationController => https://spring.io/guides/gs/spring-boot/ => ` http://localhost:8080 `
2. 创建 rank.html => ` http://localhost:8080/rank.html `
3. 使用 MyBatis => https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
   - Spring Boot MyBatis starter => https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter/2.2.0
   - MyBatis config file => https://mybatis.org/mybatis-3/getting-started.html
   - MyBatis Mapper file
   - MyBatis Mapper resultType entity => GoodsSales
   - Spring MyBatis config => ` mybatis.config-location=classpath:db/mybatis/config.xml `
   - MyBatis SqlSession Dao => com.github.hcsp.dao.GoodsSalesDao
4. 业务代码 Service => com.github.hcsp.service.GoodsSalesService
5. 创建接口 getGoodsSalesList => ApplicationController => ` http://localhost:8080/getGoodsSalesList `
6. rank.html 使用 ` /getGoodsSalesList ` 接口 => ` http://localhost:8080/rank.html ` => 获取数据库数据

### Cache
1. 创建 @Cache Annotation => com.github.hcsp.anno.Cache
2. AOP 内存缓存 => https://www.baeldung.com/spring-aop
   - Spring Boot AOP starter
   - com.github.hcsp.CacheAspect
   - 时间限制
   - Redis
      - Docker 启动 Redis 服务
      - Spring Boot Redis starter => https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-redis
      - Spring Redis config => 
        ```
        // application.properties
        spring.redis.host=localhost
        spring.redis.port=6379
        ```
        
