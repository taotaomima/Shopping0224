package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.po.Administrator;

import java.util.List;

public interface AdministratorService {
    Administrator getByUsername(String username);
    Administrator getById(Integer administratorId);
    void update(Administrator administrator);
    Integer create(Administrator administrator);
    void delete(Integer administratorId);
    void betchDelete(List<Integer> administratorIds);
    Page<Administrator> getList(Integer pageNum);

    Administrator getByEamil(String email);
}
