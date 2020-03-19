package com.gtt.shoppingproductback.dao;


import com.gtt.shoppingproductback.po.Administrator;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministratorMapperTest {

    @Resource
    private AdministratorMapper administratorMapper;

    @Test
    public void getByUsername() {
        String userName = "admin";
        Administrator byUsername = administratorMapper.getByUsername(userName);
        assertNotNull(byUsername);

        userName ="admin10";
        byUsername = administratorMapper.getByUsername(userName);
        assertNull(byUsername);
    }
}