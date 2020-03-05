package com.gtt.shoppingproductback.service;

import com.gtt.shoppingproductback.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getListByOrderId(Long orderId);

    Long create(OrderHistory orderHistory);

}
