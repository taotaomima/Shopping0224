package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.ReturnHistoryCreateIn;
import com.gtt.shoppingproductback.dto.out.ReturnHistoryListOut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class ReturnHistoryController {
    @GetMapping("/search")
    public List<ReturnHistoryListOut> getListByReturnId(@RequestParam Integer returnId){return null;}
    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateIn returnHistoryCreateIn){return null;}
}
