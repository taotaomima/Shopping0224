package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingproductback.dao.AdministratorMapper;
import com.gtt.shoppingproductback.po.Administrator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Resource
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator getByUsername(String username) {
        Administrator administrator = administratorMapper.getByUsername(username);
        return administrator;
    }

    @Override
    public Administrator getById(Integer administratorId) {
        return administratorMapper.selectByPrimaryKey(administratorId);
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public Integer create(Administrator administrator) {
        int administratorId = administratorMapper.insertSelective(administrator);
        return administratorId;
    }

    @Override
    public void delete(Integer administratorId) {
        administratorMapper.deleteByPrimaryKey(administratorId);
    }

    @Override
    public void betchDelete(List<Integer> administratorIds) {
        administratorMapper.betchDelete(administratorIds);
    }

    @Override
    public Page<Administrator> getList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Administrator> list = administratorMapper.getList();
        return list;
    }

    @Override
    public Administrator getByEamil(String email) {
        return administratorMapper.getByEamil(email);
    }
}
