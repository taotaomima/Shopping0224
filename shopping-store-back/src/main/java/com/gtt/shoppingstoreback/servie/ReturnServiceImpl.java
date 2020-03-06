package com.gtt.shoppingstoreback.servie;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingstoreback.dao.ReturnMapper;
import com.gtt.shoppingstoreback.po.Return;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Resource
    private ReturnMapper returnMapper;

    @Override
    public Integer create(Return ireturn) {
        returnMapper.insertSelective(ireturn);
        Integer returnId = ireturn.getReturnId();
        return returnId;
    }

    @Override
    public Page<Return> list(Integer pageNum,Integer customerId) {
        PageHelper.startPage(pageNum,10);
        Page<Return> page = returnMapper.selectPageByCustomerId(customerId);
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }
}
