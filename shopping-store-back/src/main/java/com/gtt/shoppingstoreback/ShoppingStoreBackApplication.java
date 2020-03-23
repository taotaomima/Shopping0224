package com.gtt.shoppingstoreback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.gtt.shoppingstoreback.dao")
@EnableCaching
@EnableScheduling
public class ShoppingStoreBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingStoreBackApplication.class, args);
    }

}