package com.gtt.shoppingproductback.dao;

import com.gtt.shoppingproductback.po.Address;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    List<Address> selectByCustomerId(Integer customerId);

}