package com.gtt.shoppingproductback.controller;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.RetuenSearchIn;
import com.gtt.shoppingproductback.dto.in.RetuenUpdateIn;
import com.gtt.shoppingproductback.dto.in.ReturnIn;
import com.gtt.shoppingproductback.dto.out.PageOut;
import com.gtt.shoppingproductback.dto.out.RetuenListOut;
import com.gtt.shoppingproductback.dto.out.ReturnShowOut;
import com.gtt.shoppingproductback.po.Return;
import com.gtt.shoppingproductback.service.ReturnService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
public class ReturnController {
    @Resource
    private ReturnService returnService;

    @GetMapping("/search")
    public PageOut<RetuenListOut> search(RetuenSearchIn retuenSearchIn,@RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<Return> page = returnService.search(retuenSearchIn,pageNum);
        List<RetuenListOut> retuenListOuts = page.stream().map(aReturn -> {
            RetuenListOut retuenListOut = new RetuenListOut();
            retuenListOut.setRetuenId(aReturn.getReturnId());
            retuenListOut.setOrderId(aReturn.getOrderId());
            retuenListOut.setCustomerId(aReturn.getCustomerId());
            retuenListOut.setCustomerName(aReturn.getCustomerName());
            retuenListOut.setProductCode(aReturn.getProductCode());
            retuenListOut.setCustomerName(aReturn.getProductName());
            retuenListOut.setStatus(aReturn.getStatus());
            retuenListOut.setCreateTimeTamp(aReturn.getCreateTime().getTime());
            retuenListOut.setUpdateTimeTamp(aReturn.getUpdateTime().getTime());
            return retuenListOut;
        }).collect(Collectors.toList());

        PageOut<RetuenListOut> pageOut = new PageOut<>();
        pageOut.setList(retuenListOuts);
        pageOut.setTotal(page.getTotal());
        pageOut.setPageSize(page.getPageSize());
        pageOut.setPageNum(page.getPageNum());
        return pageOut;
    }

    @GetMapping("/getById")
    public ReturnShowOut getById(@RequestParam Integer returnId){
        Return aReturn = returnService.getById(returnId);
        ReturnShowOut returnShowOut = new ReturnShowOut();
        returnShowOut.setReturnId(aReturn.getReturnId());
        returnShowOut.setOrderId(aReturn.getOrderId());
        returnShowOut.setCustomerId(aReturn.getCustomerId());
        returnShowOut.setCustomerName(aReturn.getCustomerName());
        returnShowOut.setMobile(aReturn.getMobile());
        returnShowOut.setEmail(aReturn.getEmail());
        returnShowOut.setStatus(aReturn.getStatus());
        returnShowOut.setAction(aReturn.getAction());
        returnShowOut.setProductCode(aReturn.getProductCode());
        returnShowOut.setProductName(aReturn.getProductName());
        returnShowOut.setQuantity(aReturn.getQuantity());
        returnShowOut.setReason(aReturn.getReason());
        returnShowOut.setOpened(aReturn.getOpened());
        returnShowOut.setComment(aReturn.getComment());
        returnShowOut.setCreateTimeTamp(aReturn.getCreateTime().getTime());
        returnShowOut.setUpdateTimeTamp(aReturn.getUpdateTime().getTime());

        return returnShowOut;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody RetuenUpdateIn retuenUpdateIn){
        Return aReturn = new Return();
        aReturn.setReturnId(retuenUpdateIn.getReturnId());
        aReturn.setAction(retuenUpdateIn.getAction());
        aReturn.setUpdateTime(new Date());

        returnService.update(aReturn);
    }
}
