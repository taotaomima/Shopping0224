package com.gtt.shoppingstoreback.controller;

import com.gtt.shoppingstoreback.dto.in.ReturnCreateIn;
import com.gtt.shoppingstoreback.dto.out.PageOut;
import com.gtt.shoppingstoreback.dto.out.ReturnListOut;
import com.gtt.shoppingstoreback.dto.out.ReturnShowOut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {
    @PostMapping("/returnApply")
    public Integer getReturnApply(@RequestBody ReturnCreateIn returnCreateIn){return null;}

    @GetMapping("/list")
    public PageOut<ReturnListOut> list(@RequestParam Integer pageNum){return null;}

    @GetMapping("/show")
    public ReturnShowOut getById(@RequestParam Integer returnId){return null;}

}
