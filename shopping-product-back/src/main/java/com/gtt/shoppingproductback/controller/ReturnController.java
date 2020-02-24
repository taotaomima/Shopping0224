package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.ReturnIn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @PostMapping("/create")
    public void addReturn(@RequestBody ReturnIn returnIn){

    }
}
