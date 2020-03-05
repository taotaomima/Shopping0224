package com.gtt.shoppingproductback.dao;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.out.OrderListOut;
import com.gtt.shoppingproductback.po.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);


    Page<OrderListOut> search();
}