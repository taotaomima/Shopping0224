package com.gtt.shoppingstoreback.dao;

import com.github.pagehelper.Page;
import com.gtt.shoppingstoreback.po.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Page<Order> getByCustomerId(@Param("customerId") Integer customerId);
}