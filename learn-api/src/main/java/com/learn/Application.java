package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.learn.mapper") // 扫描mybatis通用Mapper所在的包
@ComponentScan(basePackages = {"com.learn", "org.n3r.idworker"}) // 扫描所有包和相关组件包
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
