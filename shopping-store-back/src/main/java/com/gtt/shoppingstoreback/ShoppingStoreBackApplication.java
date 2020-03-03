package com.gtt.shoppingstoreback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gtt.shoppingstoreback.dao")
public class ShoppingStoreBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingStoreBackApplication.class, args);
    }

}