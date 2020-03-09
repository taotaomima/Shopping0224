package com.gtt.shoppingproductback.dao;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.out.CustomerListOut;
import com.gtt.shoppingproductback.po.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Page<Customer> search(@Param("username")String username,@Param("realName")String realName,@Param("status")Byte status,
                          @Param("email")String email,@Param("mobile")String mobile);
}