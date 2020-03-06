package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingproductback.dao.ReturnMapper;
import com.gtt.shoppingproductback.po.Return;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Resource
    private ReturnMapper returnMapper;
    @Override
    public Page<Return> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Return> page = returnMapper.search();
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
