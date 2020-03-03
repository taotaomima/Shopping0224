package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.CustomerCreateIn;
import com.gtt.shoppingproductback.dto.in.CustomerSearchIn;
import com.gtt.shoppingproductback.dto.out.CustomerListOut;
import com.gtt.shoppingproductback.dto.out.CustomerOut;


public interface CustomerService {
    Integer createCustomer(CustomerCreateIn customerCreateIn);
   // PageOut<CustomerListOut> search(CustomerSearchIn customerSearchIn, @RequestParam Integer pageNum)
    Page<CustomerListOut> search(Integer pageNum);
    void disable(Integer customerId);
    CustomerOut getById(Integer customerId);
}
