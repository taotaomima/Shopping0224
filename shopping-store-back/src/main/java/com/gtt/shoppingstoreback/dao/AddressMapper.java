package com.gtt.shoppingstoreback.dao;

import com.gtt.shoppingstoreback.po.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> getAddressByCustomerId(Integer customerId);
}