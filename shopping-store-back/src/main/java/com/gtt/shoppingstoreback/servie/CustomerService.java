package com.gtt.shoppingstoreback.servie;

import com.gtt.shoppingstoreback.dto.in.CustomerRegisterIn;
import com.gtt.shoppingstoreback.po.Customer;

public interface CustomerService {
    Integer register(CustomerRegisterIn customerRegisterIn);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    void update(Customer customer);

    Customer getByEmail(String email);
}
