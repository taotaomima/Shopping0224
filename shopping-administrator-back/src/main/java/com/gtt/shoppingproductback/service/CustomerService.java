package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.CustomerSetStatusIn;
import com.gtt.shoppingproductback.dto.out.CustomerOut;
import com.gtt.shoppingproductback.po.Customer;


public interface CustomerService {

    Page<Customer> search(Integer pageNum);
    void disable(CustomerSetStatusIn customerSetStatusIn);
    Customer getById(Integer customerId);
}
