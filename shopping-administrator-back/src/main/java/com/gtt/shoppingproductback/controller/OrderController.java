package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.OrderSearchIn;
import com.gtt.shoppingproductback.dto.out.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/search")
    public PageOut<OrderListOut> search(OrderSearchIn orderSearchIn,@RequestParam Integer pageNum){return null;}

    @GetMapping("/getById")
    public OrderShowOut getById(@RequestParam Long orderId){return null;}

    @GetMapping("/getInvoice")
    public OrderInvoiceOut getInvoice(@RequestParam Long orderId){return null;}

    @GetMapping("/getShipPrice")
    public OrderShipOut getShip(@RequestParam Long orderId){return null;}

}
