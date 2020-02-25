package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.*;
import com.gtt.shoppingproductback.dto.out.AdminstratorListOut;
import com.gtt.shoppingproductback.dto.out.AdminstratorShowOut;
import com.gtt.shoppingproductback.dto.out.PageOut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminstratorController {



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
    @GetMapping("/login")
    public void login(@RequestBody AdminstratorLoginIn adminstratorLoginIn){}

    @GetMapping("/getProfile")
    public String getProfile(@RequestAttribute Integer adminstratorId){return null;}

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdminstratorUpdateProfileIn adminstratorUpdateProfileIn, @RequestAttribute Integer adminstratorId){}

    @GetMapping("/changePwd")
    public void changePwd(@RequestBody AdminstratorChangePwdIn adminstratorChangePwdIn, @RequestAttribute Integer adminstratorId){}

    @GetMapping("/getPwdRestCode")
    public String getPwdRestCode(@RequestParam String email){return null;}

    @PostMapping("/resetCode")
    public void resetCode(@RequestBody AdminstratorRestPwdIn adminstratorRestPwdIn){}
    }

