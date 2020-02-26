package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.out.AddressListOut;
import com.gtt.shoppingproductback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @GetMapping("/list")
    public AddressListOut getList(@RequestParam Integer customerId){
        AddressListOut addressListOut = addressService.getList(customerId);
        return addressListOut;
    }
}
