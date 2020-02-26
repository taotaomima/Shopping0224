package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingproductback.dao.CustomerMapper;
import com.gtt.shoppingproductback.dto.in.CustomerCreateIn;
import com.gtt.shoppingproductback.dto.in.CustomerSearchIn;
import com.gtt.shoppingproductback.dto.out.CustomerListOut;
import com.gtt.shoppingproductback.dto.out.CustomerOut;
import com.gtt.shoppingproductback.po.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Integer createCustomer(CustomerCreateIn customerCreateIn) {
        Customer customer = new Customer();
        customer.setAvatarUrl(customerCreateIn.getAvatarUrl());
        customer.setCreateTime(customerCreateIn.getCreateTimeTemp());
        customer.setEmail(customerCreateIn.getEmail());
        customer.setMobile(customerCreateIn.getMobile());
        customer.setEncryptedPassword(customerCreateIn.getPassword());
        customer.setRealName(customerCreateIn.getRealName());
        customer.setUsername(customerCreateIn.getUsername());
        customer.setStatus(customerCreateIn.getStatus());
        customerMapper.insertSelective(customer);
        Integer customerId = customer.getCustomerId();
        return customerId;
    }

    @Override
    public Page<CustomerListOut> search(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        Page<CustomerListOut> search = customerMapper.search(pageNum);
        return search;
    }


    @Override
    public void disable(Integer customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setStatus((byte) 1);

        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public CustomerOut getById(Integer customerId) {
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        CustomerOut customerOut = new CustomerOut();
        customerOut.setCreateTimeTemp(customer.getCreateTime());
        //customerOut.setDefaultAddress(customer.getDefaultAddressId());
        customerOut.setEmail(customer.getEmail());
        customerOut.setMobile(customer.getMobile());
        customerOut.setRealName(customer.getRealName());
        customerOut.setStatus(customer.getStatus());
        customerOut.setUsername(customer.getUsername());

        return customerOut;
    }
}
