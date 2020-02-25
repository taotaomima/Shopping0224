package com.gtt.shoppingstoreback.controller;

import com.gtt.shoppingstoreback.dto.in.AddressCreateIn;
import com.gtt.shoppingstoreback.dto.in.AddressUpdateIn;
import com.gtt.shoppingstoreback.dto.out.AddressListOut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping("/getAddressByCustomerId")
    public List<AddressListOut> getAddressByCustomerId(@RequestAttribute Integer customerId){return null;}

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateIn addressCreateIn,@RequestAttribute Integer customerId){return null;}

    @PostMapping("/")
    public void update(@RequestBody AddressUpdateIn addressUpdateIn,@RequestAttribute Integer customerId){}

}
