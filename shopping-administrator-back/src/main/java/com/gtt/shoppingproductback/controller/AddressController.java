package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.out.AddressListOut;
import com.gtt.shoppingproductback.dto.out.AddressShowOut;
import com.gtt.shoppingproductback.po.Address;
import com.gtt.shoppingproductback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;
    @GetMapping("/getListByCustomerId")
    public List<AddressListOut> getList(@RequestParam Integer customerId){
        List<Address> addressList = addressService.getList(customerId);
        List<AddressListOut> addressListOuts = addressList.stream().map(address -> {
            AddressListOut addressListOut = new AddressListOut();
            addressListOut.setAddressId(address.getAddressId());
            addressListOut.setReceiverName(address.getReceiverName());
            addressListOut.setReceiverMobile(address.getReceiverMobile());
            addressListOut.setContent(address.getContent());
            addressListOut.setTag(address.getTag());
            return addressListOut;
        }).collect(Collectors.toList());

        return addressListOuts;
    }

    @GetMapping("/getById")
    public AddressShowOut getById(@RequestParam Integer addressId){
        Address address = addressService.getById(addressId);
        AddressShowOut addressShowOut = new AddressShowOut();
        addressShowOut.setAddressId(address.getAddressId());
        addressShowOut.setContent(address.getContent());
        addressShowOut.setReceiverName(address.getReceiverName());
        addressShowOut.setReceiverMobile(address.getReceiverMobile());
        addressShowOut.setTag(address.getTag());
        return addressShowOut;

    }
}
