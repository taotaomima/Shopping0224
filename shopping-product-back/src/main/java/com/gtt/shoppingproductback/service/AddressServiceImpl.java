package com.gtt.shoppingproductback.service;

import com.alibaba.fastjson.JSON;
import com.gtt.shoppingproductback.dao.AddressMapper;
import com.gtt.shoppingproductback.dto.out.AddressListOut;
import com.gtt.shoppingproductback.po.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Override
    public AddressListOut getList(Integer customerId) {
        Address address = addressMapper.selectByCustomerId(customerId);
        String content = address.getContent();//地址信息
        AddressListOut addressListOut = new AddressListOut();
        addressListOut.setContent(JSON.parseArray(content,String.class));
        addressListOut.setCustomerId(customerId);
        return addressListOut;
    }
}
