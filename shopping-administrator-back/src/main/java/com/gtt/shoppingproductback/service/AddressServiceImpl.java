package com.gtt.shoppingproductback.service;

import com.gtt.shoppingproductback.dao.AddressMapper;
import com.gtt.shoppingproductback.po.Address;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
   private AddressMapper addressMapper;

    @Override
    public List<Address> getList(Integer customerId) {
        List<Address> addresses = addressMapper.selectByCustomerId(customerId);
        return addresses;
    }

    @Override
    public Address getById(Integer addressId) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        return address;
    }

}
