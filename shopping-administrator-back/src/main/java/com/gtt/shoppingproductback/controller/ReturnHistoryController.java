package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.ReturnHistoryCreateIn;
import com.gtt.shoppingproductback.dto.out.ReturnHistoryListOut;
import com.gtt.shoppingproductback.po.ReturnHistory;
import com.gtt.shoppingproductback.service.ReturnHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/returnHistory")
@CrossOrigin
public class ReturnHistoryController {
    @Resource
    private ReturnHistoryService returnHistoryService;

    @GetMapping("/search")
    public List<ReturnHistoryListOut> getListByReturnId(@RequestParam Integer returnId){
        List<ReturnHistory> listByReturnId = returnHistoryService.getListByReturnId(returnId);
        List<ReturnHistoryListOut> returnHistoryListOuts = listByReturnId.stream().map(returnHistory -> {
            ReturnHistoryListOut returnHistoryListOut = new ReturnHistoryListOut();
            returnHistoryListOut.setReturnHistoryId(returnHistory.getReturnId());
            returnHistoryListOut.setTimesTamp(returnHistory.getTime().getTime());
            returnHistoryListOut.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOut.setComment(returnHistory.getComment());
            returnHistoryListOut.setCustomerNotified(returnHistory.getCustomerNotified());
            return returnHistoryListOut;
        }).collect(Collectors.toList());

        return returnHistoryListOuts;
    }
    @PostMapping("/create")
    public Long create(@RequestBody ReturnHistoryCreateIn returnHistoryCreateIn){
        ReturnHistory returnHistory = new ReturnHistory();
        returnHistory.setReturnId(returnHistoryCreateIn.getReturnId());
        returnHistory.setTime(new Date());
        returnHistory.setReturnStatus(returnHistoryCreateIn.getReturnStatus());
        returnHistory.setComment(returnHistoryCreateIn.getComment());
        Boolean customerNotified = returnHistoryCreateIn.getCustomerNotified();
        returnHistory.setCustomerNotified(customerNotified);

        Long returnHistoryId = returnHistoryService.carete(returnHistory);
        return returnHistoryId;
    }
}
