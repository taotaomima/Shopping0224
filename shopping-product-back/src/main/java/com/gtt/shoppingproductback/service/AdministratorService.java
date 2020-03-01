package com.gtt.shoppingproductback.service;

import com.gtt.shoppingproductback.po.Administrator;

public interface AdministratorService {
    Administrator getByUsername(String username);
    Administrator getById(Integer administratorId);
}
