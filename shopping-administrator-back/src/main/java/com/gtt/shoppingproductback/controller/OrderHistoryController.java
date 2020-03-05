package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.OrderHistoryCreateIn;
import com.gtt.shoppingproductback.dto.out.OrderHistoryListOut;
import com.gtt.shoppingproductback.po.OrderHistory;
import com.gtt.shoppingproductback.service.OrderHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderHistory")
@CrossOrigin
public class OrderHistoryController {
    @Resource
    private OrderHistoryService orderHistoryService;

    @GetMapping("/search")
    public List<OrderHistoryListOut> getListByOrderId(@RequestParam Long orderId){
        List<OrderHistory> listByOrderId = orderHistoryService.getListByOrderId(orderId);
        List<OrderHistoryListOut> orderHistoryListOuts = listByOrderId.stream().map(orderHistory -> {
            OrderHistoryListOut orderHistoryListOut = new OrderHistoryListOut();
            orderHistoryListOut.setOrderHistoryId(orderHistory.getOrderHistoryId());
            orderHistoryListOut.setTimestamp(orderHistory.getTime().getTime());
            orderHistoryListOut.setOrderStatus(orderHistory.getOrderStatus());
            orderHistoryListOut.setComment(orderHistory.getComment());
            orderHistoryListOut.setCustomerNotified(orderHistory.getCustomerNotified());
            return orderHistoryListOut;
        }).collect(Collectors.toList());

        return orderHistoryListOuts;
    }

    @PostMapping("/create")
    public Long create(@RequestBody OrderHistoryCreateIn orderHistoryCreateIn){
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderId(orderHistoryCreateIn.getOrderId());
        orderHistory.setComment(orderHistoryCreateIn.getComment());
        orderHistory.setCustomerNotified(orderHistoryCreateIn.getCustomerNotified());
        orderHistory.setOrderStatus(orderHistoryCreateIn.getOrderStatus());
        orderHistory.setTime(new Date());

        Long orderHistoryId = orderHistoryService.create(orderHistory);
        return orderHistoryId;
    }
}
