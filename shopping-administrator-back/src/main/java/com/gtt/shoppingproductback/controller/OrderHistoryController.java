package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.OrderHistoryCreateIn;
import com.gtt.shoppingproductback.dto.out.OrderHistoryListOut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderHistory")
public class OrderHistoryController {

    @GetMapping("/search")
    public List<OrderHistoryListOut> getListByOrderId(@RequestParam Long orderId){return null;}

    @PostMapping("/create")
    public Integer create(@RequestBody OrderHistoryCreateIn orderHistoryCreateIn){return null;}
}
