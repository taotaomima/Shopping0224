package com.gtt.shoppingproductback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gtt.shoppingproductback.dao")
public class ShoppingProductBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingProductBackApplication.class, args);
    }

}
