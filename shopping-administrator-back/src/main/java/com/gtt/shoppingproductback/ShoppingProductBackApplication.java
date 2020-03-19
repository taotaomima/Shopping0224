package com.gtt.shoppingproductback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.gtt.shoppingproductback.dao")
@EnableAsync
public class ShoppingProductBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingProductBackApplication.class, args);
    }

}
