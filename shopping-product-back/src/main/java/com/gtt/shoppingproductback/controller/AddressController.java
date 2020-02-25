package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.out.AddressListOut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping("/list")
    public List<AddressListOut> getList(@RequestParam Integer customerId){return null;}
}
