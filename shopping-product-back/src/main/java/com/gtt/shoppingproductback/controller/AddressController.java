package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.AddressIn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @PostMapping("/create")
    public void createAddress(@RequestBody AddressIn addressIn){

    }

}
