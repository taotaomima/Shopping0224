package com.gtt.shoppingstoreback.servie;

import com.gtt.shoppingstoreback.dao.AddressMapper;
import com.gtt.shoppingstoreback.po.Address;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;


    @Override
    public List<Address> getAddressByCustomerId(Integer customerId) {
        return addressMapper.getAddressByCustomerId(customerId);
    }

    @Override
    public Integer create(Address address) {
        addressMapper.insertSelective(address);
        Integer addressId = address.getAddressId();
        return addressId;
    }

    @Override
    public void update(Address address) {
        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public void delete(Integer addressId) {
        addressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public Address getById(Integer addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }
}
