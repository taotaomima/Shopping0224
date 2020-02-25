package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.CustomerCreateIn;
import com.gtt.shoppingproductback.dto.in.CustomerSearchIn;
import com.gtt.shoppingproductback.dto.out.CustomerListOut;
import com.gtt.shoppingproductback.dto.out.CustomerOut;
import com.gtt.shoppingproductback.dto.out.PageOut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/create")
    public Integer createCustomer(@RequestBody CustomerCreateIn customerCreateIn){return null;}

    @GetMapping("/search")
    public PageOut<CustomerListOut> search(CustomerSearchIn customerSearchIn,@RequestParam Integer pageNum){return null;}

    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){}

    @GetMapping("/getById")
    public CustomerOut getById(@RequestParam Integer customerId){return null;}

}
