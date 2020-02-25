package com.gtt.shoppingstoreback.controller;

import com.gtt.shoppingstoreback.dto.in.*;
import com.gtt.shoppingstoreback.dto.out.CustomerProfileOut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterIn customerRegisterIn){return null;}
    @GetMapping("/login")
    public String login(CustomerLoginIn customerLoginIn){return null;}
    @GetMapping("/getProdile")
    public CustomerProfileOut getProfile(@RequestAttribute Integer customerId){return null;}

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody CustomerUpdateProfileIn customerUpdateProfileIn,@RequestAttribute Integer customerId){}

    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdIn customerChangePwdIn,@RequestAttribute Integer customerId){}

    @GetMapping("/getPwdRestCode")
    public String getPwdRestCode(@RequestParam String email){return null;}

    @PostMapping("/resetCode")
    public void resetCode(@RequestBody CustomerRestPwdIn customerRestPwdIn){ }



}
