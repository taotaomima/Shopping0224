package com.gtt.shoppingstoreback.servie;

import com.gtt.shoppingstoreback.dao.OrderHistoryMapper;
import com.gtt.shoppingstoreback.po.OrderHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Resource
    private OrderHistoryMapper orderHistoryMapper;

    @Override
    public List<OrderHistory> getByOrderId(Long orderId) {
        List<OrderHistory> orderHistoryList = orderHistoryMapper.getByOrderId(orderId);
        return orderHistoryList;
    }
}
