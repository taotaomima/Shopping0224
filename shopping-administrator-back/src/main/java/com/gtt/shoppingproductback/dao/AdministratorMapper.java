package com.gtt.shoppingproductback.dao;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.po.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator getByUsername(@Param("username") String username);

    int betchDelete(@Param("administratorIds") List<Integer> administratorIds);

    Page<Administrator> getList();
    Administrator getByEamil(@Param("email") String email);
 }