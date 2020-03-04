package com.gtt.shoppingstoreback.servie;

import com.gtt.shoppingstoreback.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    List<OrderHistory> getByOrderId(Long orderId);
}
