package com.github.hcsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//1.spring+mysql+mybatis+redis
//2.模板引擎(后端渲染Html)
//3.前段渲染和后端渲染
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
