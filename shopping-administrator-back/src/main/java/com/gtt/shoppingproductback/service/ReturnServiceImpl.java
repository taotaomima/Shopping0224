package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingproductback.dao.ReturnMapper;
import com.gtt.shoppingproductback.dto.in.RetuenSearchIn;
import com.gtt.shoppingproductback.po.Return;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Resource
    private ReturnMapper returnMapper;
    @Override
    public Page<Return> search(RetuenSearchIn retuenSearchIn,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Return> page = returnMapper.search(retuenSearchIn.getReturnId(),retuenSearchIn.getOrderId(),
                retuenSearchIn.getStartTimestamp()==null? null:new Date(retuenSearchIn.getStartTimestamp()),
                retuenSearchIn.getEndTimestamp()==null? null:new Date(retuenSearchIn.getEndTimestamp()),
                retuenSearchIn.getStatus(),retuenSearchIn.getProductCode(),retuenSearchIn.getCustomerName(),
                retuenSearchIn.getProductName());
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }

    @Override
    public void update(Return aReturn) {
        returnMapper.updateByPrimaryKeySelective(aReturn);
    }
}
