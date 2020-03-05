package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingproductback.dao.CustomerMapper;
import com.gtt.shoppingproductback.dto.in.CustomerCreateIn;
import com.gtt.shoppingproductback.dto.in.CustomerSearchIn;
import com.gtt.shoppingproductback.dto.in.CustomerSetStatusIn;
import com.gtt.shoppingproductback.dto.out.CustomerListOut;
import com.gtt.shoppingproductback.dto.out.CustomerOut;
import com.gtt.shoppingproductback.po.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> search(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        Page<Customer> search = customerMapper.search();
        return search;
    }

    @Override
    public void disable(CustomerSetStatusIn customerSetStatusIn) {
        Customer customer = new Customer();
        customer.setCustomerId(customerSetStatusIn.getCustomerId());
        customer.setStatus(customerSetStatusIn.getStatus());
        customerMapper.updateByPrimaryKeySelective(customer);
    }


    @Override
    public Customer getById(Integer customerId) {
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        return customer;
    }
}
