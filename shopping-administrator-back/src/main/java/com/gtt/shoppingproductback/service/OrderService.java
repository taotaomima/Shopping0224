package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.OrderSearchIn;
import com.gtt.shoppingproductback.dto.out.OrderListOut;
import com.gtt.shoppingproductback.dto.out.OrderShowOut;

public interface OrderService {
    Page<OrderListOut> search(OrderSearchIn orderSearchIn,Integer pageNum);
    OrderShowOut getById(Long orderId);
}
