package com.gtt.shoppingstoreback.controller;

import com.gtt.shoppingstoreback.dto.in.AddressCreateIn;
import com.gtt.shoppingstoreback.dto.in.AddressUpdateIn;
import com.gtt.shoppingstoreback.dto.out.AddressListOut;
import com.gtt.shoppingstoreback.dto.out.AddressShowOut;
import com.gtt.shoppingstoreback.po.Address;
import com.gtt.shoppingstoreback.servie.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Resource
    private AddressService addressService;

    @GetMapping("/getAddressByCustomerId")
    public List<AddressListOut> getAddressByCustomerId(@RequestAttribute Integer customerId){
        List<Address> addressList=addressService.getAddressByCustomerId(customerId);
        List<AddressListOut> addressListOuts = addressList.stream().map(address -> {
            AddressListOut addressListOut = new AddressListOut();
            addressListOut.setAddressId(address.getAddressId());
            addressListOut.setTag(address.getTag());
            addressListOut.setReceiverName(address.getReceiverName());
            addressListOut.setReceiverMobile(address.getReceiverMobile());
            addressListOut.setContent(address.getContent());
            return addressListOut;
        }).collect(Collectors.toList());

        return addressListOuts;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateIn addressCreateIn,@RequestAttribute Integer customerId){
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setReceiverName(addressCreateIn.getReceiverName());
        address.setReceiverMobile(addressCreateIn.getReceiverMobile());
        address.setTag(addressCreateIn.getTag());
        address.setContent(addressCreateIn.getContent());
        addressService.create(address);
        Integer addressId = address.getAddressId();
        return addressId;
    }

    @PostMapping("/update")
    public void update(@RequestBody AddressUpdateIn addressUpdateIn){
        Address address = new Address();
        address.setAddressId(addressUpdateIn.getAddressId());
        address.setContent(addressUpdateIn.getContent());
        address.setReceiverName(addressUpdateIn.getReceiverName());
        address.setReceiverMobile(addressUpdateIn.getReceiverMobile());
        address.setTag(addressUpdateIn.getTag());
        addressService.update(address);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer addressId){
        addressService.delete(addressId);
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
