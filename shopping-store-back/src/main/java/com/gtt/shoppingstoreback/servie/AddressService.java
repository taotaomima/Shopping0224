package com.gtt.shoppingstoreback.servie;


import com.gtt.shoppingstoreback.po.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressByCustomerId(Integer customerId);
    Integer create(Address address);
    void update(Address address);
    void delete(Integer addressId);
    Address getById(Integer addressId);
}
