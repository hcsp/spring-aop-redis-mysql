package com.github.hcsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//通过编写SQL查询该MySQL数据库的内容，获取商品排行榜，即商品按照其销售金额倒序的表格，如下所示。

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
