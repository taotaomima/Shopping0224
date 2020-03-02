package com.gtt.shoppingproductback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.constant.ClientExceptionConstant;
import com.gtt.shoppingproductback.dto.in.*;
import com.gtt.shoppingproductback.dto.out.*;
import com.gtt.shoppingproductback.enumeration.AdministratorStatus;
import com.gtt.shoppingproductback.exception.ClientException;
import com.gtt.shoppingproductback.po.Administrator;
import com.gtt.shoppingproductback.service.AdministratorService;
import com.gtt.shoppingproductback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminstratorController {

    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/login")
    public AdministratorLoginOutDTO login(AdminstratorLoginIn adminstratorLoginIn) throws ClientException {

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

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdministratorUpdateProfileIn administratorUpdateProfileIn,@RequestAttribute Integer adminstratorId){
        Administrator administrator = new Administrator();
        administrator.setRealName(administratorUpdateProfileIn.getRealName());
        administrator.setEmail(administratorUpdateProfileIn.getEmail());
        administrator.setAvatarUrl(administratorUpdateProfileIn.getAvatarUrl());

        administratorService.update(administrator);
    }

    @PostMapping("/create")
    public Integer addAdminstrator(@RequestBody AdminstratorCreateIn adminstratorCreateIn){
        Administrator administrator = new Administrator();
        administrator.setUsername(adminstratorCreateIn.getUsername());
        administrator.setRealName(adminstratorCreateIn.getRealName());
        administrator.setEmail(adminstratorCreateIn.getEmail());
        administrator.setAvatarUrl(adminstratorCreateIn.getAvatorUrl());
        administrator.setStatus((byte) AdministratorStatus.Enable.ordinal());
        administrator.setCreateTime(new Date());
        String password=BCrypt.withDefaults().hashToString(12,adminstratorCreateIn.getPassword().toCharArray());
        administrator.setEncryptedPassword(password);

        Integer administratorId = administratorService.create(administrator);
        return administratorId;
    }
    @PostMapping("/update")
    public void updateAdminstrator(@RequestBody AdminstratorUpdateIn adminstratorUpdateIn){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(adminstratorUpdateIn.getAdminstratorId());
        administrator.setRealName(adminstratorUpdateIn.getRealName());
        administrator.setEmail(adminstratorUpdateIn.getEmail());
        administrator.setStatus(adminstratorUpdateIn.getStatus());
        String password = adminstratorUpdateIn.getPassword();
        if(password!=null && !password.isEmpty()){
            String password1=BCrypt.withDefaults().hashToString(12,adminstratorUpdateIn.getPassword().toCharArray());
            administrator.setEncryptedPassword(password1);
        }

        administratorService.update(administrator);
    }



    @GetMapping("/getList")
    public PageOut<AdminstratorListOut> getList(@RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<Administrator> administratorPage = administratorService.getList(pageNum);
        List<AdminstratorListOut> adminstratorListOuts = administratorPage.stream().map(administrator -> {
            AdminstratorListOut adminstratorListOut = new AdminstratorListOut();
            adminstratorListOut.setAdminstratorId(administrator.getAdministratorId());
            adminstratorListOut.setUsername(administrator.getUsername());
            adminstratorListOut.setRealName(administrator.getRealName());
            adminstratorListOut.setCresteTimeTemp(administrator.getCreateTime().getTime());
            adminstratorListOut.setStatus(administrator.getStatus());
            return adminstratorListOut;
        }).collect(Collectors.toList());
        PageOut<AdminstratorListOut> pageOut= new PageOut<>();
        pageOut.setList(adminstratorListOuts);
        pageOut.setPageNum(administratorPage.getPageNum());
        pageOut.setPageSize(administratorPage.getPageSize());
        pageOut.setTotal(administratorPage.getTotal());

        return pageOut;
    }

    @GetMapping("/getById")
    public AdminstratorShowOut getById(@RequestParam Integer adminstratorId){
        Administrator administrator = administratorService.getById(adminstratorId);
        AdminstratorShowOut adminstratorShowOut = new AdminstratorShowOut();
        adminstratorShowOut.setAdminstratorId(administrator.getAdministratorId());
        adminstratorShowOut.setUsername(administrator.getUsername());
        adminstratorShowOut.setRealName(administrator.getRealName());
        adminstratorShowOut.setEmail(administrator.getEmail());
        adminstratorShowOut.setAvatorUrl(administrator.getAvatarUrl());
        adminstratorShowOut.setStatus(administrator.getStatus());
        return adminstratorShowOut;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer administratorId){
        administratorService.delete(administratorId);
    }

    @PostMapping("/betchDelete")
    public void betcahDelete(@RequestBody List<Integer> administratorIds){
        administratorService.betchDelete(administratorIds);
    }


    @GetMapping("/changePwd")
    public void changePwd(@RequestBody AdminstratorChangePwdIn adminstratorChangePwdIn, @RequestAttribute Integer adminstratorId){}

    @GetMapping("/getPwdRestCode")
    public String getPwdRestCode(@RequestParam String email){return null;}

    @PostMapping("/resetCode")
    public void resetCode(@RequestBody AdminstratorRestPwdIn adminstratorRestPwdIn){}
    }

