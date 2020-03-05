package com.gtt.shoppingproductback.service;

import com.gtt.shoppingproductback.dao.OrderHistoryMapper;
import com.gtt.shoppingproductback.po.OrderHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Resource
    private OrderHistoryMapper orderHistoryMapper;

    @Override
    public List<OrderHistory> getListByOrderId(Long orderId) {

        return orderHistoryMapper.getListByOrderId(orderId);
    }

    @Override
    public Long create(OrderHistory orderHistory) {
        orderHistoryMapper.insertSelective(orderHistory);
        Long orderHistoryId = orderHistory.getOrderHistoryId();
        return orderHistoryId;
    }
}
