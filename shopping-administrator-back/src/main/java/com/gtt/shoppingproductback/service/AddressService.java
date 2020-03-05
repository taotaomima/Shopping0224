package com.gtt.shoppingproductback.service;

import com.gtt.shoppingproductback.po.Address;


import java.util.List;

public interface AddressService {
    List<Address> getList(Integer customerId);
    Address getById(Integer addressId);
}
