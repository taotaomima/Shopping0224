package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.constant.ClientExceptionConstant;
import com.gtt.shoppingproductback.dto.in.AdminstratorLoginIn;
import com.gtt.shoppingproductback.dto.out.AdministratorLoginOutDTO;
import com.gtt.shoppingproductback.exception.ClientException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdministratorControllerTest {

    @Resource
    public AdminstratorController administratorController;

    @Test
    void getByUsername() throws ClientException {
        AdminstratorLoginIn adminstratorLoginIn = new AdminstratorLoginIn();
        adminstratorLoginIn.setUsername("admin");
        adminstratorLoginIn.setPassword("123456");
        AdministratorLoginOutDTO login = administratorController.login(adminstratorLoginIn);
        assertNotNull(login);
    }

    @Test
    void loginWrongUsername(){
        AdminstratorLoginIn adminstratorLoginIn = new AdminstratorLoginIn();
        adminstratorLoginIn.setUsername("admin10");
        adminstratorLoginIn.setPassword("123456");
        try{
            AdministratorLoginOutDTO login = administratorController.login(adminstratorLoginIn);

        }catch (ClientException ex){
            String errCode = ex.getErrCode();
            assertEquals(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE,errCode);
        }
    }

    @Test
    void loginWrongPassword(){
        AdminstratorLoginIn adminstratorLoginIn = new AdminstratorLoginIn();
        adminstratorLoginIn.setUsername("admin");
        adminstratorLoginIn.setPassword("1234567");

        try{
            AdministratorLoginOutDTO login = administratorController.login(adminstratorLoginIn);
        }catch (ClientException ex){
            String errCode = ex.getErrCode();
            assertEquals(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE,errCode);
        }
    }

}
