package com.gtt.shoppingproductback.controller;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.OrderSearchIn;
import com.gtt.shoppingproductback.dto.out.*;
import com.gtt.shoppingproductback.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/search")
    public PageOut<OrderListOut> search(OrderSearchIn orderSearchIn,@RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<OrderListOut> page = orderService.search(orderSearchIn,pageNum);
        PageOut<OrderListOut> pageOut = new PageOut<>();
        pageOut.setPageNum(page.getPageNum());
        pageOut.setPageSize(page.getPageSize());
        pageOut.setTotal(page.getTotal());
        pageOut.setList(page);
        return pageOut;

    }

    @GetMapping("/getById")
    public OrderShowOut getById(@RequestParam Long orderId){
        OrderShowOut orderShowOut = orderService.getById(orderId);
        return orderShowOut;
    }

    @GetMapping("/getInvoice")
    public OrderInvoiceOut getInvoice(@RequestParam Long orderId){return null;}

    @GetMapping("/getShipPrice")
    public OrderShipOut getShip(@RequestParam Long orderId){return null;}

}
