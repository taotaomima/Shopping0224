package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.OrderIn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @PostMapping("/create")
    public void addOrder(@RequestBody OrderIn orderIn){

    }
}
