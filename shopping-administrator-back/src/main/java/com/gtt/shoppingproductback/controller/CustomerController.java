package com.gtt.shoppingproductback.controller;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.CustomerSearchIn;
import com.gtt.shoppingproductback.dto.in.CustomerSetStatusIn;
import com.gtt.shoppingproductback.dto.out.CustomerListOut;
import com.gtt.shoppingproductback.dto.out.CustomerShowOut;
import com.gtt.shoppingproductback.dto.out.PageOut;
import com.gtt.shoppingproductback.po.Address;
import com.gtt.shoppingproductback.po.Customer;
import com.gtt.shoppingproductback.service.AddressService;
import com.gtt.shoppingproductback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/search")
    public PageOut<CustomerListOut> search(CustomerSearchIn customerSearchIn,@RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<Customer> page = customerService.search(pageNum);
        List<CustomerListOut> customerListOuts = page.stream().map(customer -> {
            CustomerListOut customerListOut = new CustomerListOut();
            customerListOut.setCustomerId(customer.getCustomerId());
            customerListOut.setUsername(customer.getUsername());
            customerListOut.setRealName(customer.getRealName());
            customerListOut.setMobile(customer.getMobile());
            customerListOut.setEmail(customer.getEmail());
            customerListOut.setStatus(customer.getStatus());
            customerListOut.setCreateTime(customer.getCreateTime().getTime());
            return customerListOut;
        }).collect(Collectors.toList());

        PageOut<CustomerListOut> pageOut = new PageOut<>();
        pageOut.setPageSize(page.getPageSize());
        pageOut.setPageNum(page.getPageNum());
        pageOut.setTotal(page.getTotal());
        pageOut.setList(customerListOuts);
        return pageOut;
    }

    @PostMapping("/disable")
    public void disable(@RequestBody CustomerSetStatusIn customerSetStatusIn){
       customerService.disable(customerSetStatusIn);
    }

    @GetMapping("/getById")
    public CustomerShowOut getById(@RequestParam Integer customerId){
        Customer customer = customerService.getById(customerId);
        CustomerShowOut customerShowOut = new CustomerShowOut();
        customerShowOut.setCustomerId(customerId);
        customerShowOut.setUsername(customer.getUsername());
        customerShowOut.setRealName(customer.getRealName());
        customerShowOut.setEmail(customer.getEmail());
        customerShowOut.setMobile(customer.getMobile());
        customerShowOut.setAvatarUrl(customer.getAvatarUrl());
        customerShowOut.setStatus(customer.getStatus());
        customerShowOut.setRewordPoints(customer.getRewordPoints());
        customerShowOut.setNewsSubscribed(customer.getNewsSubscribed());
        customerShowOut.setCreateTimeTemp(customer.getCreateTime().getTime());
        customerShowOut.setDefaultAddressId(customer.getDefaultAddressId());

        Address defaultAddress = addressService.getById(customer.getDefaultAddressId());
        if(defaultAddress!=null){
            customerShowOut.setDefaultAddress(defaultAddress.getContent());
        }
        return customerShowOut;
    }

}
