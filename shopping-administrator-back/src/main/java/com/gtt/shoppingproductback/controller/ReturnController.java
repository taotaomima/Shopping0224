package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.RetuenSearchIn;
import com.gtt.shoppingproductback.dto.in.RetuenUpdateIn;
import com.gtt.shoppingproductback.dto.in.ReturnIn;
import com.gtt.shoppingproductback.dto.out.PageOut;
import com.gtt.shoppingproductback.dto.out.RetuenListOut;
import com.gtt.shoppingproductback.dto.out.ReturnShowOut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @GetMapping("/search")
    public PageOut<RetuenListOut> search(RetuenSearchIn retuenSearchIn,@RequestParam Integer pageNum){return null;}

    @GetMapping("/getById")
    public ReturnShowOut getById(@RequestParam Integer returnId){return null;}

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody RetuenUpdateIn retuenUpdateIn){}
}
