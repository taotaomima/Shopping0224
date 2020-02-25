package com.gtt.shoppingstoreback.controller;

import com.gtt.shoppingstoreback.dto.in.OrderCreateIn;
import com.gtt.shoppingstoreback.dto.out.OrderListOut;
import com.gtt.shoppingstoreback.dto.out.OrderShowOut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/checkOut")
    public Integer checkOut(@RequestBody OrderCreateIn orderCreateIn){return null;}

    @GetMapping("/search")
    public List<OrderListOut> search(){return null;}

    @GetMapping("/getById")
    public OrderShowOut getById(@RequestParam Long orderId){return null;}
}
