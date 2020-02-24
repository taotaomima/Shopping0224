package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.CustomerIn;
import com.gtt.shoppingproductback.dto.out.CustomerOut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/resign")
    public void addCustomer(@RequestBody CustomerIn customerIn){

    }

    @GetMapping("/login")
    public CustomerOut login(@RequestParam String username, @RequestParam String password){
        return null;
    }
}
