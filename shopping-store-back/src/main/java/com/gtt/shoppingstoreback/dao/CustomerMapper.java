package com.gtt.shoppingstoreback.dao;

import com.gtt.shoppingstoreback.po.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}