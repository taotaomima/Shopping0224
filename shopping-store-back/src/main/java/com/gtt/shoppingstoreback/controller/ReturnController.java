package com.gtt.shoppingstoreback.controller;

import com.github.pagehelper.Page;
import com.gtt.shoppingstoreback.dto.in.ReturnCreateIn;
import com.gtt.shoppingstoreback.dto.out.PageOut;
import com.gtt.shoppingstoreback.dto.out.ReturnHistoryListOut;
import com.gtt.shoppingstoreback.dto.out.ReturnListOut;
import com.gtt.shoppingstoreback.dto.out.ReturnShowOut;
import com.gtt.shoppingstoreback.enumeration.ReturnReason;
import com.gtt.shoppingstoreback.enumeration.ReturnStatus;
import com.gtt.shoppingstoreback.po.Return;
import com.gtt.shoppingstoreback.po.ReturnHistory;
import com.gtt.shoppingstoreback.servie.ReturnHistoryService;
import com.gtt.shoppingstoreback.servie.ReturnService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {
    @Resource
    private ReturnService returnService;
    @Resource
    private ReturnHistoryService returnHistoryService;

    @PostMapping("/returnApply")
    public Integer getReturnApply(@RequestBody ReturnCreateIn returnCreateIn,@RequestAttribute Integer customerId){
        Return ireturn = new Return();
        ireturn.setOrderId(returnCreateIn.getOrderId());
        ireturn.setOrderTime(new Date(returnCreateIn.getOrderTimesTamp()));
        ireturn.setCustomerId(customerId);
        ireturn.setCustomerName(returnCreateIn.getCustomerName());
        ireturn.setMobile(returnCreateIn.getMobile());
        ireturn.setEmail(returnCreateIn.getEmail());
        ireturn.setStatus((byte) ReturnStatus.ToProcess.ordinal());
        ireturn.setProductCode(returnCreateIn.getProductCode());
        ireturn.setProductName(returnCreateIn.getProductName());
        ireturn.setQuantity(returnCreateIn.getQuantity());
        ireturn.setReason(returnCreateIn.getReason());
        ireturn.setOpened(returnCreateIn.getOpened());
        ireturn.setComment(returnCreateIn.getComment());
        ireturn.setCreateTime(new Date());
        ireturn.setUpdateTime(new Date());

        Integer returnId = returnService.create(ireturn);
        return returnId;
    }

    @GetMapping("/getlList")
    public PageOut<ReturnListOut> list(@RequestAttribute Integer customerId,@RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<Return> page = returnService.list(pageNum, customerId);
        List<ReturnListOut> returnListOuts = page.stream().map(iReturn -> {
            ReturnListOut returnListOut = new ReturnListOut();
            returnListOut.setReturnId(iReturn.getReturnId());
            returnListOut.setOrderId(iReturn.getOrderId());
            returnListOut.setCustomerName(iReturn.getCustomerName());
            returnListOut.setStatus(iReturn.getStatus());
            returnListOut.setCreateTime(iReturn.getCreateTime().getTime());
            return returnListOut;
        }).collect(Collectors.toList());

        PageOut<ReturnListOut> pageOut = new PageOut<>();
        pageOut.setList(returnListOuts);
        pageOut.setPageSize(page.getPageSize());
        pageOut.setPageNum(page.getPageNum());
        pageOut.setTotal(page.getTotal());
        return pageOut;
    }

    @GetMapping("/getById")
    public ReturnShowOut getById(@RequestParam Integer returnId){
        Return aReturn = returnService.getById(returnId);

        ReturnShowOut returnShowOut = new ReturnShowOut();
        returnShowOut.setReturnId(aReturn.getReturnId());
        returnShowOut.setOrderId(aReturn.getOrderId());
        returnShowOut.setOrderTimesTamp(aReturn.getOrderTime().getTime());
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
        returnShowOut.setCreateTimeTamp(aReturn.getCreateTime().getTime());
        returnShowOut.setUpdateTimeTamp(aReturn.getUpdateTime().getTime());

        List<ReturnHistory> returnHistoryList = returnHistoryService.getByReturnId(returnId);
        List<ReturnHistoryListOut> returnHistoryListOuts = returnHistoryList.stream().map(returnHistory -> {
            ReturnHistoryListOut returnHistoryListOut = new ReturnHistoryListOut();
            returnHistoryListOut.setComment(returnHistory.getComment());
            returnHistoryListOut.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOut.setTimesTamp(returnHistory.getTime().getTime());
            return returnHistoryListOut;
        }).collect(Collectors.toList());

        returnShowOut.setReturnHistoryListOuts(returnHistoryListOuts);

        return returnShowOut;
    }


}
