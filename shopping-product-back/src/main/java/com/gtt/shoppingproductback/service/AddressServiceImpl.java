package com.gtt.shoppingproductback.service;

import com.alibaba.fastjson.JSON;
import com.gtt.shoppingproductback.dao.AddressMapper;
import com.gtt.shoppingproductback.dto.out.AddressListOut;
import com.gtt.shoppingproductback.po.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressListOut> getList(Integer customerId) {
        List<Address> addresses = addressMapper.selectByCustomerId(customerId);
        List<AddressListOut> addressListOuts = new ArrayList<>();
        for (Address address : addresses) {
            String content = address.getContent();//地址信息
            AddressListOut addressListOut = new AddressListOut();
            addressListOut.setCustomerId(customerId);
            addressListOut.setContent(JSON.parseArray(content,String.class));
            addressListOut.setReceiverMobile(address.getReceiverMobile());
            addressListOut.setReceiverName(address.getReceiverName());
            addressListOuts.add(addressListOut);
        }
        return addressListOuts;
    }

}
