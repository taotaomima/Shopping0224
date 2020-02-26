package com.gtt.shoppingproductback.controller;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.CustomerCreateIn;
import com.gtt.shoppingproductback.dto.in.CustomerSearchIn;
import com.gtt.shoppingproductback.dto.out.CustomerListOut;
import com.gtt.shoppingproductback.dto.out.CustomerOut;
import com.gtt.shoppingproductback.dto.out.PageOut;
import com.gtt.shoppingproductback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Integer createCustomer(@RequestBody CustomerCreateIn customerCreateIn){
        Integer customerId = customerService.createCustomer(customerCreateIn);
        return customerId;
    }

    @GetMapping("/search")
    public PageOut<CustomerListOut> search(CustomerSearchIn customerSearchIn,@RequestParam Integer pageNum){
        Page<CustomerListOut> customerListOutPage = customerService.search(pageNum);
        PageOut<CustomerListOut> page = new PageOut<>();
        page.setPageSize(customerListOutPage.getPageSize());
        page.setPageNum(customerListOutPage.getPageNum());
        page.setTotal((int) customerListOutPage.getTotal());
        page.setList(customerListOutPage);
        return page;
    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){
        customerService.disable(customerId);
    }

    @GetMapping("/getById")
    public CustomerOut getById(@RequestParam Integer customerId){
        CustomerOut customerOut = customerService.getById(customerId);
        return customerOut;
    }

}
