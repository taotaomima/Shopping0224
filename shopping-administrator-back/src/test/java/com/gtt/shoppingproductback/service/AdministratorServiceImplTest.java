package com.gtt.shoppingproductback.service;

import com.gtt.shoppingproductback.po.Administrator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdministratorServiceImplTest {

    @Resource
    private AdministratorService administratorService;

    @Test
    public void getByUesrname(){
        String username="admin";
        Administrator administrator = administratorService.getByUsername(username);
        assertNotNull(administrator);
        username = "admin10";
        administrator=administratorService.getByUsername(username);
        assertNull(administrator);
    }

}
