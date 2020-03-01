package com.gtt.shoppingproductback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.gtt.shoppingproductback.constant.ClientExceptionConstant;
import com.gtt.shoppingproductback.dto.in.*;
import com.gtt.shoppingproductback.dto.out.*;
import com.gtt.shoppingproductback.exception.ClientException;
import com.gtt.shoppingproductback.po.Administrator;
import com.gtt.shoppingproductback.service.AdministratorService;
import com.gtt.shoppingproductback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminstratorController {

    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/login")
    public AdministratorLoginOutDTO login(@RequestBody AdminstratorLoginIn adminstratorLoginIn) throws ClientException {
        Administrator administrator = administratorService.getByUsername(adminstratorLoginIn.getUsername());
        if (administrator == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encPwdDB = administrator.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(adminstratorLoginIn.getPassword().toCharArray(), encPwdDB);

        if (result.verified) {
            AdministratorLoginOutDTO administratorLoginOutDTO = jwtUtil.issueToken(administrator);
            return administratorLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRMSG);
        }
    }

    @GetMapping("/getProfile")
    public AdminstratorGetProfileOut getProfile(@RequestAttribute Integer adminstratorId){
        Administrator administrator = administratorService.getById(adminstratorId);
        AdminstratorGetProfileOut adminstratorGetProfileOut=new AdminstratorGetProfileOut();
        adminstratorGetProfileOut.setAdministratorId(adminstratorId);
        adminstratorGetProfileOut.setUsername(administrator.getUsername());
        adminstratorGetProfileOut.setRealName(administrator.getRealName());
        adminstratorGetProfileOut.setEmail(administrator.getEmail());
        adminstratorGetProfileOut.setAvatarUrl(administrator.getAvatarUrl());
        adminstratorGetProfileOut.setCreateTimestamp(administrator.getCreateTime().getTime());
        return adminstratorGetProfileOut;
    }

    @GetMapping("/getList")
    public PageOut<AdminstratorListOut> getList(@RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public AdminstratorShowOut getById(@RequestParam Integer adminstratorId){
        return null;
    }

    @PostMapping("/create")
    public Integer addAdminstrator(AdminstratorCreateIn adminstratorCreateIn){
        return null;
    }

    @PostMapping("/update")
    public void updateAdminstrator(AdminstratorUpdateIn adminstratorUpdateIn){

    }



    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdminstratorUpdateProfileIn adminstratorUpdateProfileIn, @RequestAttribute Integer adminstratorId){}

    @GetMapping("/changePwd")
    public void changePwd(@RequestBody AdminstratorChangePwdIn adminstratorChangePwdIn, @RequestAttribute Integer adminstratorId){}

    @GetMapping("/getPwdRestCode")
    public String getPwdRestCode(@RequestParam String email){return null;}

    @PostMapping("/resetCode")
    public void resetCode(@RequestBody AdminstratorRestPwdIn adminstratorRestPwdIn){}
    }

