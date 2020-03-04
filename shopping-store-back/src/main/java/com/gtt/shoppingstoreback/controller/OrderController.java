package com.gtt.shoppingstoreback.controller;

import com.github.pagehelper.Page;
import com.gtt.shoppingstoreback.dto.in.OrderCreateIn;
import com.gtt.shoppingstoreback.dto.out.OrderListOut;
import com.gtt.shoppingstoreback.dto.out.OrderShowOut;
import com.gtt.shoppingstoreback.dto.out.PageOut;
import com.gtt.shoppingstoreback.po.Order;
import com.gtt.shoppingstoreback.servie.OrderService;
import com.gtt.shoppingstoreback.servie.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Resource
    private OrderService orderService;


    @PostMapping("/checkOut")
    public Long checkOut(@RequestBody OrderCreateIn orderCreateIn,@RequestAttribute Integer customerId){
        Long orderId = orderService.checkOut(orderCreateIn, customerId);
        return orderId;
    }

    @GetMapping("/getList")
    public PageOut<OrderListOut> getList(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                         @RequestAttribute Integer customerId){
        Page<Order> page = orderService.getByCustomerId(customerId, pageNum);
        List<OrderListOut> orderListOuts = page.stream().map(order -> {
            OrderListOut orderListOut = new OrderListOut();
            orderListOut.setOrderId(order.getOrderId());
            orderListOut.setStatus(order.getStatus());
            orderListOut.setTotalPrice(order.getTotalPrice());
            orderListOut.setCreateTimeTamp(order.getCreateTime().getTime());
            return orderListOut;
        }).collect(Collectors.toList());

        PageOut<OrderListOut> pageOut = new PageOut<>();
        pageOut.setTotal(page.getTotal());
        pageOut.setPageNum(page.getPageNum());
        pageOut.setPageSize(page.getPageSize());
        pageOut.setList(orderListOuts);
        return pageOut;
    }

    @GetMapping("/getById")
    public OrderShowOut getById(@RequestParam Long orderId){
        OrderShowOut orderShowOut=orderService.getById(orderId);
        return orderShowOut;
    }
}
