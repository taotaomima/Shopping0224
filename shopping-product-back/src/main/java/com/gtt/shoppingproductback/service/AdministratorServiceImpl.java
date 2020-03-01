package com.gtt.shoppingproductback.service;

import com.gtt.shoppingproductback.dao.AdministratorMapper;
import com.gtt.shoppingproductback.po.Administrator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}