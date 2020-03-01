package com.gtt.shoppingproductback.dao;

import com.gtt.shoppingproductback.po.Administrator;
import org.apache.ibatis.annotations.Param;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator getByUsername(@Param("username") String username);
}