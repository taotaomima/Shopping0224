package com.gtt.shoppingproductback.service;

import com.gtt.shoppingproductback.dto.out.AddressListOut;


import java.util.List;

public interface AddressService {
    List<AddressListOut> getList(Integer customerId);

}
