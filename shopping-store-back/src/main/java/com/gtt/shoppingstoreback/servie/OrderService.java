package com.gtt.shoppingstoreback.servie;

import com.github.pagehelper.Page;
import com.gtt.shoppingstoreback.dto.in.OrderCreateIn;
import com.gtt.shoppingstoreback.dto.out.OrderShowOut;
import com.gtt.shoppingstoreback.po.Order;


public interface OrderService {
    Long checkOut(OrderCreateIn orderCreateIn,Integer customerId);
    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);
    OrderShowOut getById(Long orderId);

}
